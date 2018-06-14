package com.evolvus.controller;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.evolvus.bean.FormBean;
import com.evolvus.bean.ResponseJson;
//import com.evolvus.repository.ITaCBSLogging;
import com.evolvus.security.CreateSignature;
import com.evolvus.security.KeyExtractor;
import com.evolvus.utils.CDAC;
import com.evolvus.utils.Pain009Request;
import com.evolvus.utils.XmlStrSubstitutor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "/FLUX")
public class FLuxController {

	@Value("${REDIRECT_URL}")
	private String redirectUrl;

	@Value("${esign_version}")
	private String esignVersion;

	@Value("${eKYCMode}")
	private String eKYCMode;

	@Value("${eKYCIdType}")
	private String eKYCIdType;

	@Value("${authMode}")
	private String authMode;

	@Value("${ResponseURL}")
	private String ResponseURL;

	@Value("${E-ASBA_REDIRECT}")
	private String easbaURL;

	@Value("${aspId}")
	private String aspId;

	@Value("${responseSigType}")
	private String responseSigType;

	DocumentBuilderFactory builderFactory = null;

	/*
	 * @Autowired private VerifySignedData verifySignedData;
	 */
	// @Autowired
	//
	// private ITaCBSLogging iTaCBSLogging;

	Document xmlDocument = null;
	DocumentBuilder builder = null;

	XPath xPath = null;

	/*
	 * @Value("${syndicate_bank_code}") private String syndicateBankCode;
	 */

	/*
	 * @Autowired private ASBAServices asbaService;
	 */

	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * showWelcomePage(ModelMap model) { model.put("name", "nagendra"); return
	 * "login"; }
	 */
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		List<String> utilityCodes = new ArrayList<String>();
		utilityCodes.add("NACH00000000001");
		utilityCodes.add("NACH00000000002");
		utilityCodes.add("NACH00000000003");
		model.put("utilityCodes", utilityCodes);

		List<String> accountTypes = new ArrayList<String>();
		accountTypes.add("Savings");
		accountTypes.add("Current");
		model.put("accountTypes", accountTypes);

		List<String> collectionTypes = new ArrayList<String>();
		collectionTypes.add("Fixed");
		collectionTypes.add("Variable");
		model.put("collectionTypes", collectionTypes);

		List<String> frequency = new ArrayList<String>();
		frequency.add("Monthly");
		frequency.add("Bi-Monthly");
		frequency.add("Quaterly");
		frequency.add("Half-Yearly");
		model.put("frequency", frequency);
		//return "BackUp";
		// return "finSmartFinanace";
		// return "login";
		 return "index";

	}

	@RequestMapping(value = "/EASBA", method = RequestMethod.GET)

	public String EASBA(ModelMap model) {
		return "EASBA";

	}

	@RequestMapping(value = "/return")
	public String showWelcomePagelog(ModelMap model) {
		System.out.println("gfsdjghsdfgfg");
		model.put("name", "nagendra");
		return "errorPage";
	}

	@RequestMapping(value = "/login")
	public void redirectFederal(ModelMap model, HttpServletResponse resp, HttpServletRequest req) throws IOException {

		resp.setContentType("text/html");

		// System.out.println("gfsdjghsdfgfg"+requestString);
		String name = "SNEHA";// req.getParameter("name");

		String url = easbaURL + "?CorpId=" + name;
		resp.sendRedirect(url);

	}

	@RequestMapping(value = "/register", params = "Save", method = RequestMethod.POST)
	public String saveDetails(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestBody String str) {
		String input = null;
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> valueMap = new HashMap<>();
		try {
			System.out.println("the request  dat  is" + str);
			String utilityCode = request.getParameter("utilityCode");
			model.put("utilityCode", utilityCode);
			String sponserBankifsc = request.getParameter("sponserBankifsc");
			model.put("sponserBankifsc", sponserBankifsc);
			String utilityDesc = request.getParameter("utilityDesc");
			model.put("utilityDesc", utilityDesc);
			String sponserBankName = request.getParameter("sponserBankName");
			model.put("sponserBankName", sponserBankName);
			String customerName = request.getParameter("customerName");
			model.put("customerName", customerName);
			String mobile = request.getParameter("mobile");
			model.put("mobile", mobile);
			String email = request.getParameter("email");
			model.put("email", email);
			String bankIfsc = request.getParameter("bankIfsc");
			model.put("bankIfsc", bankIfsc);
			String accountnumber = request.getParameter("accountnumber");
			model.put("accountnumber", accountnumber);
			String branchName = request.getParameter("branchName");
			model.put("branchName", branchName);
			String confirmAccountNumber = request.getParameter("confirmAccountNumber");
			model.put("confirmAccountNumber", confirmAccountNumber);
			// String frequency ; //request.getParameter("frequency");
			// model.put("frequency", frequency);
			String collectAmount = request.getParameter("maxamount");
			model.put("collectAmount", collectAmount);
			String maxAmt = request.getParameter("amount");
			model.put("maxAmt", maxAmt);
			String collectionType = request.getParameter("collectionType");
			model.put("collectionType", collectionType);
			String accountType = request.getParameter("accountType");
			model.put("accountType", accountType);
			String aadharNumber = request.getParameter("aadhar");
			model.put("aadharNumber", aadharNumber);
			String startDate = request.getParameter("startDate");
			model.put("startDate", startDate);
			String endDate = request.getParameter("endDate");
			model.put("endDate", endDate);
			// String
			// consumerRefeNumber=request.getParameter("consumerRefeNumber");

			/*
			 * Emandate emandate=new Emandate(); Request requestEmnd=new
			 * Request(); Header header=new Header(); EmandateRoot
			 * emandateroot=new EmandateRoot(); BankInfo bankInfo=new
			 * BankInfo();
			 * 
			 * ContactDetails contact=new ContactDetails();
			 * 
			 * 
			 * emandateroot.setAmount(amount);
			 * emandateroot.setCollectAmount(collectAmount); //
			 * emandateroot.setConsumerRefeNumber(consumerRefeNumber);
			 * emandateroot.setCorporateId("DHFL");
			 * emandateroot.setCorporateName("DHFL India Limited");
			 * emandateroot.setCustomerAccType(accountType);
			 * emandateroot.setFrequency(frequency);
			 * emandateroot.setLegalAccountNumber(accountnumber);
			 * emandateroot.setMandateAmountType(collectionType);
			 * emandateroot.setMandateCataogoryCode("C");
			 * 
			 * 
			 * requestEmnd.setEmandateRoot(emandateroot);
			 * emandate.setRequest(requestEmnd); emandate.setHeader(header);
			 * 
			 * try { input = mapper.writeValueAsString(emandate); } catch
			 * (JsonProcessingException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */

			/*
			 * By using XML Request
			 * 
			 */
			Random random = new Random();
			int msgId = random.nextInt(100000);// 6
			int mndtReqRef = random.nextInt(1000000000);// 16
			int consumerRefeNumber = random.nextInt(1600000000);// 50
			valueMap.put("msgId", msgId);
			// valueMap.put("sponserBankCode", sponserBankifsc.toUpperCase());
			valueMap.put("sponserBankName", sponserBankName);
			model.put("sponserBankName", sponserBankName);
			// valueMap.put("destbankCode", bankIfsc.toUpperCase());
			valueMap.put("destbankName", branchName);
			valueMap.put("mndtReqRef", mndtReqRef);
			valueMap.put("mandateCataogoryCode", "C");
			valueMap.put("mndStartDate", startDate);
			valueMap.put("mndEnddate", endDate);
			valueMap.put("collectAmount", collectAmount);
			valueMap.put("maxAmt", maxAmt);
			valueMap.put("corporateName", utilityDesc);
			valueMap.put("utilityCode", utilityCode);
			valueMap.put("payerName", customerName);
			valueMap.put("consumerRefeNumber", utilityCode);
			valueMap.put("mobileNo", mobile);
			valueMap.put("emailId", email);
			valueMap.put("legalAccountNumber", accountnumber);
			valueMap.put("customerAccType", accountType);
			valueMap.put("aadharNumber", aadharNumber);
			// valueMap.put("frequency", frequency);
			String reqXml = Pain009Request.Pain009;
			XmlStrSubstitutor sub = new XmlStrSubstitutor(valueMap);
			String xmlInput = sub.replace(reqXml);

			System.out.println("the generated xml ::::::::" + xmlInput);

			// verifySignedData.writePAINXML(xmlInput, mndtReqRef);

			byte[] orgC = Base64.encodeBase64(xmlInput.getBytes());

			System.out.println("the signature content:::::+orgC" + orgC);

			// encodedXML = this.EncryptedString(xmlInput);
			String encodedXML = this.hashDataMkyong(xmlInput);
			valueMap.put("hashXMLData", encodedXML);
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss.sss");
			System.out.println(sdf.format(new Date()));
			valueMap.put("dateTime", sdf.format(new Date()));
			valueMap.put("esignVersion", esignVersion);
			int transcationReferenceNumber = 177 + random.nextInt(50000);
			valueMap.put("txnId", mndtReqRef);
			valueMap.put("eKYCMode", eKYCMode);
			valueMap.put("eKYCIdType", eKYCIdType);
			valueMap.put("ekycId", aadharNumber);
			valueMap.put("authMode", authMode);
			valueMap.put("responseURL", ResponseURL);
			valueMap.put("aspId", aspId);
			valueMap.put("responseSigType", responseSigType);
			// String cdacRequestStringUnsiged = NSDL.NSDL_REQUEST;

			String cdacRequestStringUnsiged = CDAC.CDACREQUEST;
			sub = new XmlStrSubstitutor(valueMap);
			String cdacRequestedxml = sub.replace(cdacRequestStringUnsiged);
			KeyExtractor keyExtractor = new KeyExtractor();
			KeyPair keypair = keyExtractor.extractKeysFromStream();
			System.out.println("the private key :::::::" + keypair.getPrivate());
			CreateSignature createSignature = new CreateSignature();
			String xmlString = "Hi thsi  is nagendra";
			String signedXml = createSignature.signFile(cdacRequestedxml, keypair.getPrivate());
			// String signedXml=verifySignedData.getFile();
			System.out.println("signed xml::::::" + signedXml);

			/*
			 * String redirectURL = redirectUrl + "?" + encodedXML;
			 * response.setStatus(307); response.setHeader("Location",
			 * redirectURL);
			 */
			// URLEncoder.encode(signedXml, "UTF-8")
			model.put("addharNumber", "563439949780");
			model.put("eSignRequestXML", signedXml);
			// model.addAttribute("eSignRequestXML", cdacRequestedxml);
			model.put("consent", "Y");

			List<String> utilityCodes = new ArrayList<String>();
			utilityCodes.add("NACH00000000001");
			utilityCodes.add("NACH00000000002");
			utilityCodes.add("NACH00000000003");
			model.put("utilityCodes", utilityCodes);

			List<String> accountTypes = new ArrayList<String>();
			accountTypes.add("Savings");
			accountTypes.add("Current");
			model.put("accountTypes", accountTypes);

			List<String> collectionTypes = new ArrayList<String>();
			collectionTypes.add("Fixed");
			collectionTypes.add("Variable");
			model.put("collectionTypes", collectionTypes);

			List<String> frequency = new ArrayList<String>();
			frequency.add("Monthly");
			frequency.add("Bi-Monthly");
			frequency.add("Quaterly");
			frequency.add("Half-Yearly");
			model.put("frequency", frequency);

			model.put("mobile", mobile);
			model.put("email", email);

			model.put("startDate", startDate);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		// return "BackUp";
		return "esignCorporate";
		// return "cdac";
	}

	private String hashDataMkyong(String xmlInput) {
		StringBuffer hexString = null;

		try {
			String password = "123456";
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(xmlInput.getBytes());

			byte byteData[] = md.digest();

			// convert the byte to hex format method 1
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

			System.out.println("Hex format : " + sb.toString());

			// convert the byte to hex format method 2
			hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Hex format : " + hexString.toString());
		return hexString.toString();
	}

	public String EncryptedString(String xmlString) {
		String hexString = null;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");

			String text = "Text to hash, cryptographically.";

			// Change this to UTF-16 if needed
			md.update(xmlString.getBytes(StandardCharsets.UTF_8));
			byte[] digest = md.digest();

			hexString = String.format("%064x", new BigInteger(1, digest));
			System.out.println(hexString);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hexString;

	}

	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public String show(@RequestBody String xmlData) {
		String abc = null;
		try {
			abc = URLDecoder.decode(xmlData, "UTF-8");
			System.out.println(abc);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return abc;
	}

	@RequestMapping(value = "/ONFAILURE", method = RequestMethod.GET)
	public ModelAndView getData(@ModelAttribute("formBean") FormBean formDta, HttpServletResponse res)
			throws IOException {
		String abc = null;
		System.out.println("the data from :::" + formDta.getSponserBankName());
		System.out.println("abc");

		return new ModelAndView(new RedirectView("https://www.evolvussolutions.com"));
		// String redirectURL ="https://www.evolvussolutions.com";
		/*
		 * res.setStatus(307); res.setHeader("Location", redirectURL);
		 */ // res.sendRedirect(redirectURL);
			// return "redirect:https://www.evolvussolutions.com";
			// return "errorPage";
	}

	@RequestMapping(value = "/CDACRESPONSE")
	public @ResponseBody String ResponseFromCDACAfterEsign(@RequestBody String RespxmlData, HttpServletResponse res,
			HttpServletRequest req) throws IOException {
		try {
			HttpSession httpsession = req.getSession(true);

			System.out.println("Response data" + RespxmlData);

			/*
			 * JAXBContext jaxbContext =
			 * JAXBContext.newInstance(EsignResp.class);
			 * 
			 * Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			 * EsignResp que = (EsignResp) jaxbUnmarshaller.unmarshal(new
			 * File(RespxmlData));
			 * 
			 * System.out.println(que.getSignatures().getDocSignature() + " " +
			 * que.getResCode());
			 */

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;

			dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(new ByteArrayInputStream(RespxmlData.getBytes()));

			XPath xPath = XPathFactory.newInstance().newXPath();

			String x509cert = "//UserX509Certificate";

			String signeddata = "//Signatures/DocSignature";

			String SignatureValue = "//SignatureValue";

			String wsName = "//EsignResp/txn";

			// read a string value
			String x509certdata = xPath.compile(x509cert).evaluate(doc);

			String signeddatadata = xPath.compile(signeddata).evaluate(doc);

			String signatureValuedata = xPath.compile(SignatureValue).evaluate(doc);

			String webService = doc.getFirstChild().getAttributes().getNamedItem("txn").getNodeValue();
			System.out.println("webService:::::" + webService);

			/*
			 * TaCBSlogging resp=asbaService.findByname(webService);
			 * 
			 * byte[] orgldata =
			 * Base64.encodeBase64(resp.getRequestStr().getBytes());
			 * 
			 * String signeddatadata=new String(orgldata);
			 * 
			 * System.out.println("the object ::::::;"+resp.getRequestStr());
			 */ // verifySignedData.verifySignaturePkcs7(que.getUserX509Certificate(),
				// que.getSignatures().getDocSignature(),
				// que.getSignature().getSignatureValue());

			// verifySignedData.verifySignedDataRequest(x509certdata,
			// signeddatadata, signatureValuedata);
			// verifySignedData.dataVerification(signeddatadata);
			String aadharNumber = "7005965608358";
			// verifySignedData.certificateAadharVerification(x509certdata,
			// aadharNumber);
			// verifySignedData.verifySignaturePkcs7(x509certdata,
			// signeddatadata, signatureValuedata);
			// this.writeData(RespxmlData);

			/*
			 * JAXBContext jaxbContext =
			 * JAXBContext.newInstance(Signature.class); Unmarshaller
			 * jaxbUnmarshaller = jaxbContext.createUnmarshaller(); StringReader
			 * reader=new StringReader(RespxmlData); Signature sig=(Signature)
			 * jaxbUnmarshaller.unmarshal(reader);
			 * 
			 * 
			 * 
			 * SignedInfo sf=sig.getSignedInfo();
			 */
			// System.out.println("signed info"+ sf.getReference()+"signature
			// method"+ sf.getSignatureMethod());

			// this.createSignedXML(x509certdata, signeddatadata,
			// signatureValuedata);

		} catch (Exception e) {
			System.out.println("error::::::" + e.getMessage());

		}
		// String redirectURL ="https://www.evolvussolutions.com";

		String redirectURL = "https://192.168.1.177:8443/FLUX/loginSuccess";

		return redirectURL;

	}

	@RequestMapping("/loginSuccess")
	public String showHomePage(ModelMap model) {
		System.out.println("in showHome() method");
		Random rand = new Random();

		int value = rand.nextInt(20000);
		model.addAttribute("message", "Emandate has been  applied succesfully with  the reference number " + value);
		// return "success";
		return "summary";
	}

	private void writeData(
			String respxmlData) { /*
									 * Properties pro = new Properties();
									 * InputStream in = null; try { in = new
									 * FileInputStream( new
									 * File(System.getenv("CONFIG").toString() +
									 * "/path.properties")); pro.load(in); }
									 * catch (IOException e) { //
									 * logger.error("Error occured :" +
									 * e.getMessage()); }
									 * 
									 * finally { if(in!=null) { in.close(); } }
									 */
		/*
		 * String pathCorporat= pro.getProperty("PATH_CORPORATE");
		 * 
		 * String pathCorporatAck=pro.getProperty("PATH_CORPORATE_ACK");
		 */
		/*
		 * Path ESIGN_CORPORATE =Paths.get("C:\\EMANDATE\\ESIGN-CORPORATE\\IN");
		 * 
		 * Path ESIGN_CORPORATE_ACK
		 * =Paths.get("C:\\EMANDATE\\ESIGN-CORPORATE\\OUT");
		 */
		Path ESIGN_CORPORATE = Paths.get("/home/mahanteshm/ESIGNEDDATA");
		// Path ESIGN_CORPORATE_ACK
		// =Paths.get("/home/nagendrappae/Music/ESIGN-CORPORATE/OUT");

		// if directory exists?
		if (!Files.exists(ESIGN_CORPORATE)) {
			try {
				Files.createDirectories(ESIGN_CORPORATE);
			} catch (IOException e) {
				// fail to create directory
				e.printStackTrace();
			}
		}

		// if directory exists?
		/*
		 * if (!Files.exists(ESIGN_CORPORATE_ACK)) { try {
		 * Files.createDirectories(ESIGN_CORPORATE_ACK); } catch (IOException e)
		 * { //fail to create directory e.printStackTrace(); } }
		 */

		// String FILENAME =
		// "E:\\test\\MMS-CANCEL-ICIC-ICICMaker-02052016-ESIGN000005-INP.xml";

		Random rand = new Random();

		int filenameIncr = rand.nextInt(500000) + 1;

		String FileName = ESIGN_CORPORATE + "/MMS-CREATE-HDFC-HDFCMaker-18022017-ESIGN" + filenameIncr + "-INP.xml";

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = "This is the content to write into file\n";

			fw = new FileWriter(FileName);
			bw = new BufferedWriter(fw);
			bw.write(respxmlData);

			System.out.println("Done");

			// copyFileUsingApacheCommonsIO(source, dest);

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}

	private void extractCDACRESP(String respxmlData) throws SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub

		File file = new File("/home/mahanteshm/Documents/ESIGNED/xmlresp.txt");
		builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		xmlDocument = builder.parse(file);
		XPath xPath = XPathFactory.newInstance().newXPath();

		String val = (String) getXpathElement("//EsignResp/status");
		String val1 = (String) getXpathElement("//EsignResp/UserX509Certificate");

		String val2 = (String) getXpathElement("//status");

	}

	private Object getXpathElement(String string) {

		String value = "";
		try {
			value = xPath.compile(string).evaluate(xmlDocument).trim();
		} catch (Exception e) {
			// LOG.error("EmndPain009Processor :: getXpathElement = {}",
			// e.getMessage());
		}
		return value;
	}

	private void createSignedXML(String x509certdata, String signeddatadata, String signatureValuedata) {
		try {

			String filepath = "/home/mahanteshm/Documents/ESIGNED/XML/EmandatePAIN9RequestXMLdata.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			// Get the root element
			Node company = doc.getFirstChild();

			// Get the staff element , it may not working if tag has spaces, or
			// whatever weird characters in front...it's better to use
			// getElementsByTagName() to get it directly.
			// Node staff = company.getFirstChild();

			// Get the staff element by tag name directly
			// NodeList staff = doc.getElementsByTagName("Mndt");
			// Node MndtInitnReq = doc.getElementsByTagName("Document");

			// update staff attribute
			/*
			 * NamedNodeMap attr = staff.getAttributes(); Node nodeAttr =
			 * attr.getNamedItem("id"); nodeAttr.setTextContent("2");
			 */

			Element staff = doc.createElement("SplmtryData");
			company.appendChild(staff);

			// append a new node to staff
			Element age = doc.createElement("SignedContent");
			age.appendChild(doc.createTextNode(signeddatadata));
			company.appendChild(age);

			Element X509Certificate = doc.createElement("X509Certificate");
			age.appendChild(doc.createTextNode(x509certdata));
			company.appendChild(X509Certificate);

			Element Signature = doc.createElement("Signature");
			age.appendChild(doc.createTextNode(signatureValuedata));
			company.appendChild(Signature);

			/*
			 * Element staff1 = doc.createElement("EsignResp");
			 * company.appendChild(staff1);
			 */
			// loop the staff child node
			// NodeList list = staff.getChildNodes();

			/*
			 * for (int i = 0; i < list.getLength(); i++) {
			 * 
			 * Node node = list.item(i);
			 * 
			 * // get the salary element, and update the value if
			 * ("salary".equals(node.getNodeName())) {
			 * node.setTextContent("2000000"); }
			 * 
			 * //remove firstname if ("firstname".equals(node.getNodeName())) {
			 * staff.removeChild(node); }
			 * 
			 * }
			 * 
			 */ // write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			Path ESIGN_CORPORATE = Paths.get("/home/mahanteshm/ESIGNEDDATA");

			if (!Files.exists(ESIGN_CORPORATE)) {
				try {
					Files.createDirectories(ESIGN_CORPORATE);
				} catch (IOException e) {
					// fail to create directory
					e.printStackTrace();
				}
			}

			Random rand = new Random();

			int filenameIncr = rand.nextInt(500000) + 1;

			String FileName = ESIGN_CORPORATE + "/MMS-CREATE-HDFC-HDFCMaker-18022017-ESIGN" + filenameIncr + "-INP.xml";

			StreamResult result = new StreamResult(new File(FileName));
			transformer.transform(source, result);

			System.out.println("Done");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}

	@RequestMapping(value = "/CDACREQ", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> returnXml(@RequestParam("aadharNum") String aadharNumber)
			throws FileNotFoundException {

		Map<String, Object> valueMap = new HashMap<>();
		String reqXml = Pain009Request.Pain009;
		XmlStrSubstitutor sub = new XmlStrSubstitutor(valueMap);
		String xmlInput = sub.replace(reqXml);

		ResponseEntity<ResponseJson> resEntity = new ResponseEntity<ResponseJson>(HttpStatus.OK);
		ResponseJson res = new ResponseJson();
		res.setStatus(HttpStatus.OK);

		try {

			Random random = new Random();
			int msgId = random.nextInt(100000);// 6
			int mndtReqRef = random.nextInt(1000000000);// 16
			int consumerRefeNumber = random.nextInt(1600000000);// 50

			System.out.println("the generated xml ::::::::" + xmlInput);

			// verifySignedData.writePAINXML(xmlInput, mndtReqRef);

			// encodedXML = this.EncryptedString(xmlInput);
			String encodedXML = this.hashDataMkyong(xmlInput);
			valueMap.put("hashXMLData", encodedXML);
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss.sss");
			System.out.println(sdf.format(new Date()));
			valueMap.put("dateTime", sdf.format(new Date()));
			valueMap.put("esignVersion", esignVersion);
			int transcationReferenceNumber = 177 + random.nextInt(50000);
			valueMap.put("txnId", mndtReqRef);
			valueMap.put("eKYCMode", eKYCMode);
			valueMap.put("eKYCIdType", eKYCIdType);
			valueMap.put("ekycId", aadharNumber);
			valueMap.put("authMode", authMode);
			valueMap.put("responseURL", ResponseURL);
			valueMap.put("aspId", aspId);
			valueMap.put("responseSigType", responseSigType);
			// String cdacRequestStringUnsiged = NSDL.NSDL_REQUEST;

			String cdacRequestStringUnsiged = CDAC.CDACREQUEST;
			sub = new XmlStrSubstitutor(valueMap);
			String cdacRequestedxml = sub.replace(cdacRequestStringUnsiged);

			KeyExtractor keyExtractor = new KeyExtractor();
			KeyPair keypair = keyExtractor.extractKeysFromStream();
			System.out.println("the private key :::::::" + keypair.getPrivate());
			CreateSignature createSignature = new CreateSignature();
			String xmlString = "Hi thsi  is nagendra";
			String signedXml = createSignature.signFile(cdacRequestedxml, keypair.getPrivate());

			System.out.println("signed xml::::::" + signedXml);

			res.setData(signedXml);
			res.setStatus(HttpStatus.OK);
			resEntity = new ResponseEntity<ResponseJson>(res, HttpStatus.OK);

		} catch (Exception e) {

			res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setData(e.getMessage());
			resEntity = new ResponseEntity<ResponseJson>(res, HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resEntity;

	}

	@RequestMapping(value = "/processForm", params = "SendOTP", method = RequestMethod.POST)
	public String callOTP(HttpServletRequest request, Model model) {
		String msg;
		String page = "";
		System.out.println("in showOtpMsg method");
		String otp = request.getParameter("otp");
		msg = "Please  enter  the  obtained OTP";

		page = "newOTP";

		model.addAttribute("message", msg);
		return "";
	}

	@RequestMapping(value = "/processSuccess", method = RequestMethod.POST)
	public String showHomePageOnsc(ModelMap model) {
		System.out.println("in showHome() method");
		Random rand = new Random();

		int value = rand.nextInt(20000);
		model.addAttribute("message", "Emandate has been  applied succesfully with  the reference number " + value);
		// return "success";
		return "summary";
	}

	@PostMapping("/redirectedPostToPost")
	public String redirectedPostToPost(@RequestBody String strd, HttpServletRequest req)
			throws UnsupportedEncodingException {
		// String data = (String) req.getAttribute("aadharNum");
		// System.out.println("requested data:::::::"+req.getPar);
		String decodeURL = URLDecoder.decode(strd, "UTF-8");

		String requestEncd = req.getParameter("aspRequest");

		String decodedData = URLDecoder.decode(requestEncd, "UTF-8");

		System.out.println("the data:::::::" + strd);
		return "summary";

	}

	@RequestMapping(value = "/registerFlux", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> saveDetails(HttpServletRequest request, HttpServletResponse response,
			@RequestBody String str, @RequestParam("aadharNum") String aadharNum) {
		String signedXml = null;
		ResponseEntity<ResponseJson> resEntity = new ResponseEntity<ResponseJson>(HttpStatus.OK);
		ResponseJson res = new ResponseJson();
		res.setStatus(HttpStatus.OK);

		StringBuffer totaloutput = new StringBuffer();
		try {
			String esignVersion = "2.0";
			String eKYCMode = "U";
			String eKYCIdType = "A";
			String aadharNumber = aadharNum;
			String authMode = "1";
			String ResponseURL = "https://192.168.1.177:9443/FLUX/CDACRESPONSE";
			String aspId = "ELVS-900";

			String responseSigType = "pkcs7";
			Map<String, Object> valueMap = new HashMap<>();

			String reqXml = Pain009Request.Pain009;
			XmlStrSubstitutor sub = new XmlStrSubstitutor(valueMap);
			String xmlInput = sub.replace(reqXml);

			Random random = new Random();
			int msgId = random.nextInt(100000);// 6
			int mndtReqRef = random.nextInt(1000000000);// 16
			int consumerRefeNumber = random.nextInt(1600000000);// 50

			String encodedXML = this.hashDataMkyong(xmlInput);
			valueMap.put("hashXMLData", encodedXML);
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss.sss");
			System.out.println(sdf.format(new Date()));
			valueMap.put("dateTime", sdf.format(new Date()));

			valueMap.put("esignVersion", esignVersion);
			int transcationReferenceNumber = 177 + random.nextInt(50000);
			valueMap.put("txnId", mndtReqRef);
			valueMap.put("eKYCMode", eKYCMode);
			valueMap.put("eKYCIdType", eKYCIdType);
			valueMap.put("ekycId", aadharNumber);
			valueMap.put("authMode", authMode);
			valueMap.put("responseURL", ResponseURL);
			valueMap.put("aspId", aspId);
			valueMap.put("responseSigType", responseSigType);
			// String cdacRequestStringUnsiged = NSDL.NSDL_REQUEST;

			String cdacRequestStringUnsiged = CDAC.CDACREQUEST;
			sub = new XmlStrSubstitutor(valueMap);
			String cdacRequestedxml = sub.replace(cdacRequestStringUnsiged);

			/*
			 * Security.addProvider(new BouncyCastleProvider());
			 * 
			 * KeyExtractor keyExtractor = new KeyExtractor();
			 * 
			 * InputStream inputStream =
			 * ACHOutwardMandateController.class.getResourceAsStream
			 * ("/privateKeyData");
			 * 
			 * KeyPair keypair =
			 * keyExtractor.extractKeysFromStream(inputStream);
			 * 
			 * CreateSignature createSignature = new CreateSignature();
			 * 
			 * signedXml = createSignature.signFile(cdacRequestedxml,
			 * keypair.getPrivate());
			 * 
			 * System.out.println("signed xml::::::" + signedXml);
			 */
			/*
			 * javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier( new
			 * javax.net.ssl.HostnameVerifier(){
			 * 
			 * public boolean verify(String hostname, javax.net.ssl.SSLSession
			 * sslSession) { System.out.println("Hostname"+hostname); return
			 * hostname.equals("192.168.1.177"); } });
			 */

			URL url = new URL(String.format("https://192.168.1.177:8443/FLUX/CDACREQ?aadharNum=%s", aadharNum));
			// HttpURLConnection conn = (HttpURLConnection)
			// url.openConnection();

			url = new URL(String.format("https://192.168.1.177:8443/FLUX/CDACREQ?aadharNum=%s", aadharNum));
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

			// print_https_cert(conn);

			// dump all the content
			// print_content(conn);
			/*
			 * conn.setDoOutput(true); conn.setRequestMethod("POST");
			 * conn.setRequestProperty("Content-Type", "application/xml");
			 * 
			 * String urlParameters = "aadharNumber=" + aadharNumber;
			 * OutputStream os = conn.getOutputStream();
			 * os.write(urlParameters.getBytes()); os.flush();
			 * 
			 * if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			 * throw new RuntimeException("Failed : HTTP error code : " +
			 * conn.getResponseCode()); }
			 * 
			 * BufferedReader br = new BufferedReader(new
			 * InputStreamReader((conn.getInputStream()))); String output;
			 * System.out.println("Output from Server .... \n");
			 * 
			 * while ((output = br.readLine()) != null) {
			 * System.out.println(output); totaloutput =
			 * totaloutput.append(output);
			 * 
			 * }
			 */

			// signedXml = totaloutput.toString();
			// signedXml = CDAC.req;
			System.out.println("responseString" + signedXml);

			res.setData(signedXml);
			res.setStatus(HttpStatus.OK);
			resEntity = new ResponseEntity<ResponseJson>(res, HttpStatus.OK);

			System.out.println("signed xml::::::" + signedXml);
		} catch (Exception e) {
			res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			res.setData(e.getMessage());
			resEntity = new ResponseEntity<ResponseJson>(res, HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resEntity;

	}
}