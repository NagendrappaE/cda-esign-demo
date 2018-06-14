/**
 * 
 *//*
package com.evolvus.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import javax.security.auth.x500.X500Principal;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.CMSAttributes;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessable;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.evolvus.model.TaCBSlogging;
import com.evolvus.repository.ITaCBSLogging;
import com.evolvus.utils.TestMain;

import sun.security.pkcs.PKCS7;

*//**
 * @author EVOLVUS\mahanteshm
 *
 *//*
@Service("verifySignedData")

public class VerifySignedData {

	private static final Object TaCBSlogging = null;

	@Value("${achPath}")
	private String achPath;
	
	@Autowired

	private ITaCBSLogging iTaCBSLogging;

	public boolean verifySignedDataRequest(String x509cert, String signeddata, String signature) {

				InputStream in = null;
		boolean value = false;

		try {

			System.out.println("the trimmed string:::::" + signature);

			
			Security.addProvider(new BouncyCastleProvider());
			byte[] orgC = Base64.decodeBase64(signeddata.getBytes());
			byte[] signC = Base64.decodeBase64(signature.getBytes());
			byte[] certC = Base64.decodeBase64(x509cert.getBytes());
			
			CMSProcessable cpbaorgC = new CMSProcessableByteArray(orgC);
			CMSSignedData cms = new CMSSignedData(cpbaorgC, signC);

			SignerInformationStore signers = cms.getSignerInfos();

			SignerInformation signerInfo = (SignerInformation) signers.getSigners().iterator().next();

			CertificateFactory certFactory = CertificateFactory.getInstance("X.509", "BC");
			in = new ByteArrayInputStream(certC);
			X509Certificate certN = (X509Certificate) certFactory.generateCertificate(in);

			if (signerInfo.verify(new JcaSimpleSignerInfoVerifierBuilder().setProvider("BC").build(certN))) {
				value = true;
				System.out.println("verified");

			} else {
				value = false;
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	
	//return false;	
	}

	public void dataVerification(String signedContent) {
		
		
		//String 
		
		File   file=new File("/home/mahanteshm/Documents/ESIGNED/MMS-CREATE-HDFC-HDFCMaker-19022018-ESIGN1163157066-INP.xml");
		
		
		
		File signedContentFolder = new File(achPath + File.separator + "EMND-MMS-SIGNED-CONTENT");
		if (!signedContentFolder.exists()) {
			signedContentFolder.mkdirs();
		}
		
		Random rand = new Random();

		int filenameIncr = rand.nextInt(500000) + 1;

		String FileName = +filenameIncr + "-INP.xml";
		byte[] orgC = Base64.decodeBase64(signedContent.getBytes());
		File xmlFile = new File(achPath + File.separator + "EMND-MMS-SIGNED-CONTENT" + File.separator + FileName);
		try (FileOutputStream outputStream = new FileOutputStream(xmlFile);) {
			outputStream.write(orgC); // write the bytes and your done.
		} catch (Exception e) {
				}
		try {
			String signedXmlFile = getXmlString(xmlFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getXmlString(File xmlFile) throws IOException {
		StringBuilder xml = new StringBuilder();
		try (FileInputStream fis = new FileInputStream(xmlFile);) {
			Reader reader = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(reader);
			String line = br.readLine();

			while (line != null) {
				xml.append(line);
				line = br.readLine();
			}
		} catch (Exception e) {
			// LOG.error("Exception while converting xml to string",e);
		}
		System.out.println("the signed content:::::" + xml);
		return xml.toString();
	}

	public void verifySignaturePkcs7(String x509certdata, String signeddatadata, String signatureValuedata) throws Exception {
		
		
		
		SignerInformation siinfo = null;
    byte[] signatureEcc = null;
    PKCS7 pkcs7=null;

    Security.addProvider(new BouncyCastleProvider());

  InputStream issuerInfoStream = TestMain.class.getResourceAsStream("/privateKeyData");

    
    byte[] respBytes;
    try {
        respBytes = IOUtils.toByteArray(issuerInfoStream);


        
        CMSSignedData cms = new CMSSignedData(Base64.decode(respBytes));
        Collection<SignerInformation> si = cms.getSignerInfos().getSigners();
    
        
    
        
            
        if (si.iterator().hasNext()) {
            siinfo = si.iterator().next();
            AttributeTable attributes = siinfo.getSignedAttributes();
            signatureEcc = siinfo.getSignature();

            if (attributes != null) {

                Attribute messageDigestAttribute = attributes.get(CMSAttributes.messageDigest);
                DEROctetString derocHash = (DEROctetString) messageDigestAttribute.getAttrValues().getObjectAt(0);
                String hashToMatch = derocHash.toString().replace("#", "");
                if (hashToMatch.equals("b4fbde4d144b617fc78679413f8e7b6286243e822c6b05f29b50e18c04a5297d")) {
                    System.out.println("hash matched");
                } else {
                    System.out.println("hash verification failed");
                }

            }
        }

        /// for certificates

        Store cs = cms.getCertificates();

        Collection certCollection = cs.getMatches(siinfo.getSID());
        X509CertificateHolder cert = (X509CertificateHolder) certCollection.iterator().next();
        X509Certificate certFromSignedData = new JcaX509CertificateConverter()
                .setProvider(new BouncyCastleProvider()).getCertificate(cert);
        Signature ecdsaVerify = Signature.getInstance("sha256WithECDSA", new BouncyCastleProvider());
        ecdsaVerify.initVerify(certFromSignedData.getPublicKey());
        ecdsaVerify.update(siinfo.getEncodedSignedAttributes());
        
        PKCS7 pp= new PKCS7(signatureEcc);
       // SignerInfo[] val= pp.verify();
        
        
        

        boolean value = ecdsaVerify.verify(signatureEcc);
        if (value == true) {
            System.out.println("verified");
        } else {
            System.out.println("verification failed");
        }

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (CMSException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SignatureException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (InvalidKeyException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}



	public void certificateAadharVerification(String x509certdata, String aadharNumber) {
		
	boolean valid = false;
	InputStream in1=null;
	try {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(aadharNumber.getBytes(StandardCharsets.UTF_8));
		String sha256hex = new String(Hex.encode(encodedhash));
		byte[] certC = Base64.decode(x509certdata.getBytes());
		CertificateFactory certFactory = CertificateFactory.getInstance("X.509", "BC");
		in1 = new ByteArrayInputStream(certC);
		X509Certificate certN = (X509Certificate) certFactory.generateCertificate(in1);
		String humanReadableDN = certN.getSubjectX500Principal().getName();
		String[] contents = humanReadableDN.split(",");
		Map<String, String> knownOids = new HashMap<String, String>();
		knownOids.put("2.5.4.45", "aadharNumber");
		humanReadableDN = certN.getSubjectX500Principal().getName(X500Principal.RFC2253, knownOids);
		String aadharHash = null;
		for (String value : contents) {
			if (value.startsWith("2.5.4.45")) {
				aadharHash = value.split("=")[1];
				break;
			}
		}
		String str = new String(org.apache.commons.codec.binary.Hex.encodeHex(sha256hex.getBytes()));
		valid = aadharHash.contains(str);
		
		System.out.println("the  HumanReadable data::::"+humanReadableDN);
		
		System.out.println("the  certificateAadhaarVerification  response::::"+valid);

		//LOG.error(humanReadableDN);
		//LOG.error("inside  EsignValidationService  certificateAadhaarVerification   response  flag  :::::" + valid);

	} catch (Exception e) {
		//LOG.error("" + e.getMessage());
	} finally {
		if (in1 != null) {
			try {
				in1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	}
	
	}

	public void writePAINXML(String xmlInput,int mndtReqRef) {

		
		
		File signedContentFolder = new File(achPath + File.separator + "EMND-MMS-PAIN-CONTENT");
		if (!signedContentFolder.exists()) {
			signedContentFolder.mkdirs();
		}
		
		Random rand = new Random();

		int filenameIncr = rand.nextInt(500000) + 1;

		String FileName = +filenameIncr + "-INP.xml";
		//byte[] orgC = Base64.decodeBase64(signedContent.getBytes());
		File xmlFile = new File(achPath + File.separator + "EMND-MMS-PAIN-CONTENT" + File.separator + FileName);
		
		
		
		
		
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(xmlFile))) {

			String content = "This is the content to write into file\n";

			bw.write(xmlInput);
		
		
		
		
		} catch (IOException e) {

			e.printStackTrace();

		}

	
		
		TaCBSlogging cbs=new TaCBSlogging();
		cbs.setRequestStr(xmlInput);
		cbs.setName(String.valueOf(mndtReqRef));
		
		iTaCBSLogging.save(cbs);
		
	
	
	}
	
	public  String getFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file11 = new File(classLoader.getResource("Request.xml").getFile());
		StringBuilder result = new StringBuilder("");
		
		try (Scanner scanner = new Scanner(file11)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return result.toString();
				
	}

}

	
*/