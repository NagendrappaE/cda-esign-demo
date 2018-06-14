/*package com.evolvus.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.evolvus.bean.FormBean;
import com.evolvus.security.CreateSignature;
import com.evolvus.security.KeyExtractor;
import com.evolvus.utils.CDAC;
import com.evolvus.utils.Pain009Request;
import com.evolvus.utils.XmlStrSubstitutor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "FLUX")
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
	
	
	
	@Value("${aspId}")
	private String aspId;
	
	@Value("${responseSigType}")
	private String responseSigType;

	
	 * @Value("${syndicate_bank_code}") private String syndicateBankCode;
	 

	
	 * @Autowired private ASBAServices asbaService;
	 

	
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * showWelcomePage(ModelMap model) { model.put("name", "nagendra"); return
	 * "login"; }
	 
	@RequestMapping(value = "/home", method = RequestMethod.GET)
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
		//return "esignCorporate";
		 return "finSmartFinanace";
	}

	@RequestMapping(value = "/return")
	public String showWelcomePagelog(ModelMap model) {
		System.out.println("gfsdjghsdfgfg");
		model.put("name", "nagendra");
		return "errorPage";
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
			String sponserBankifsc = "INDB000001";//request.getParameter("sponserBankifsc");
			model.put("sponserBankifsc", sponserBankifsc);
			String utilityDesc = request.getParameter("utilityDesc");
			model.put("utilityDesc", utilityDesc);
			String sponserBankName = request.getParameter("sponserBankName");
			model.put("sponserBankName", sponserBankName);
			String customerName = "Rajesh T";//request.getParameter("customerName");
			model.put("customerName", customerName);
			String mobile = "9591991998";// request.getParameter("mobile");
			model.put("mobile", mobile);
			String email ="rajesh.t@evolvussolutions.com"; //request.getParameter("email");
			model.put("email", email);
			String bankIfsc = "FDRL000001";//request.getParameter("bankIfsc");
			model.put("bankIfsc", bankIfsc);
			String accountnumber = request.getParameter("accountnumber");
			model.put("accountnumber", accountnumber);
			String branchName = request.getParameter("branchName");
			model.put("branchName", branchName);
			String confirmAccountNumber = request.getParameter("confirmAccountNumber");
			model.put("confirmAccountNumber", confirmAccountNumber);
			//String frequency = request.getParameter("frequency");
			//model.put("frequency", frequency);
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
			// String consumerRefeNumber=request.getParameter("consumerRefeNumber");

			
			 * Emandate emandate=new Emandate(); Request requestEmnd=new Request(); Header
			 * header=new Header(); EmandateRoot emandateroot=new EmandateRoot(); BankInfo
			 * bankInfo=new BankInfo();
			 * 
			 * ContactDetails contact=new ContactDetails();
			 * 
			 * 
			 * emandateroot.setAmount(amount); emandateroot.setCollectAmount(collectAmount);
			 * // emandateroot.setConsumerRefeNumber(consumerRefeNumber);
			 * emandateroot.setCorporateId("DHFL");
			 * emandateroot.setCorporateName("DHFL India Limited");
			 * emandateroot.setCustomerAccType(accountType);
			 * emandateroot.setFrequency(frequency);
			 * emandateroot.setLegalAccountNumber(accountnumber);
			 * emandateroot.setMandateAmountType(collectionType);
			 * emandateroot.setMandateCataogoryCode("C");
			 * 
			 * 
			 * requestEmnd.setEmandateRoot(emandateroot); emandate.setRequest(requestEmnd);
			 * emandate.setHeader(header);
			 * 
			 * try { input = mapper.writeValueAsString(emandate); } catch
			 * (JsonProcessingException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 

			
			 * By using XML Request
			 * 
			 
			Random random = new Random();
			int msgId = random.nextInt(100000);//6
			int mndtReqRef = random.nextInt(1000000000);//16
			int consumerRefeNumber = random.nextInt(1600000000);//50
			valueMap.put("msgId", msgId);
			valueMap.put("sponserBankCode", sponserBankifsc.toUpperCase());
			valueMap.put("sponserBankName", sponserBankName);
			model.put("sponserBankName", sponserBankName);
			valueMap.put("destbankCode", bankIfsc.toUpperCase());
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
		//	valueMap.put("frequency", frequency);
			String reqXml = Pain009Request.Pain009;
			XmlStrSubstitutor sub = new XmlStrSubstitutor(valueMap);
			String xmlInput = sub.replace(reqXml);
			String encodedXML = URLEncoder.encode(xmlInput, "UTF-8");
			//encodedXML = this.EncryptedString(xmlInput);
			encodedXML=this.hashDataMkyong(xmlInput);
			valueMap.put("hashXMLData", encodedXML);
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss.sss");
			System.out.println(sdf.format(new Date()));
			valueMap.put("dateTime", sdf.format(new Date()));
			valueMap.put("esignVersion", esignVersion);
			int transcationReferenceNumber = 177 + random.nextInt(50000);
			valueMap.put("txnId", transcationReferenceNumber);
			valueMap.put("eKYCMode", eKYCMode);
			valueMap.put("eKYCIdType", eKYCIdType);
			valueMap.put("ekycId", aadharNumber);
			valueMap.put("authMode", authMode);
			valueMap.put("responseURL", ResponseURL);
			valueMap.put("aspId", aspId);
			valueMap.put("responseSigType", responseSigType);
			String cdacRequestStringUnsiged = CDAC.CDACREQUEST;
			sub = new XmlStrSubstitutor(valueMap);
			String cdacRequestedxml = sub.replace(cdacRequestStringUnsiged);
			KeyExtractor keyExtractor = new KeyExtractor();
			KeyPair keypair = keyExtractor.extractKeysFromStream();
			System.out.println("the private key :::::::" + keypair.getPrivate());
			CreateSignature createSignature = new CreateSignature();
			String xmlString = "Hi thsi  is nagendra";
			String signedXml = createSignature.signFile(cdacRequestedxml, keypair.getPrivate());
			
			String  replaceEdxml=signedXml.replaceAll("&gt;", ">");
			System.out.println("after replace the string :::::::::"+replaceEdxml);
			System.out.println("signed xml::::::"+signedXml);
			
			
			 * String redirectURL = redirectUrl + "?" + encodedXML; response.setStatus(307);
			 * response.setHeader("Location", redirectURL);
			 
			//URLEncoder.encode(signedXml, "UTF-8")
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

			
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return "esignCorporate";
		//return "cdac";
	}

	private String hashDataMkyong(String xmlInput) {
   	 StringBuffer hexString =null;

		try {
		String password = "123456";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(xmlInput.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Hex format : " + sb.toString());

        //convert the byte to hex format method 2
         hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	}catch(Exception  e)
    	{
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
	public ModelAndView getData(@ModelAttribute("formBean") FormBean formDta,HttpServletResponse res) throws IOException {
		String abc = null;
		System.out.println("the data from :::"+formDta.getSponserBankName());
		System.out.println("abc");
		
		
		return new ModelAndView(new RedirectView("https://www.evolvussolutions.com"));
		//String redirectURL ="https://www.evolvussolutions.com";
		res.setStatus(307);
		 res.setHeader("Location", redirectURL);
		 //res.sendRedirect(redirectURL);
		//return "redirect:https://www.evolvussolutions.com";
		//return "errorPage";
	}
	
	@RequestMapping(value = "/CDACRESPONSE" )
	public  @ResponseBody String ResponseFromCDACAfterEsign(@RequestBody String xmlData,HttpServletResponse res,HttpServletRequest req) throws IOException {
		try {
			HttpSession httpsession=req.getSession(true);
		
			System.out.println("Response data"+xmlData);

			

			
		} catch (Exception e) {
			System.out.println("error::::::" + e.getMessage());

		}
		  String redirectURL ="https://192.168.1.177:6060/CDAC/login";
	      // res.sendRedirect(redirectURL);
		URI yahoo = new URI("http://www.yahoo.com"); HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(yahoo); 
		return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
		
	//	String redirectURL1 ="https://www.evolvussolutions.com";
		 res.setStatus(307);
		 res.setHeader("Location", redirectURL);
		  
		// return  redirectURL;
		//return "success";
	//return "success"
		//call me ok
//		020 2550 3336?? i am  calling  not  respod..getClass().
	   // return new ModelAndView("redirect:"+redirectURL);
	 return 	redirectURL;
			 
	}

}
*/