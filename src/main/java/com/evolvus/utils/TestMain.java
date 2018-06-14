package com.evolvus.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import generated.EsignResp;



public class TestMain {
	
	public static void main(String[] args) throws Exception {

		/*ObjectMapper mapper = new ObjectMapper();

		JSONWEBENC json=new JSONWEBENC();

		
		Emandate emandate=new Emandate();
		
		Request  req= new Request();
		ContactDetails contactDetails=new ContactDetails();
		contactDetails.setAdharNumber("1234567777777");
		contactDetails.setEmailId("nagendra.shravanagudi@gmail.com");
		contactDetails.setOthers("Nagendra Ravi");
		contactDetails.setMobileNo("8892636021");
		req.setContactDetails(contactDetails);
		emandate.setRequest(req);
		
	String	input = mapper.writeValueAsString(emandate);
	String  encdata=json.encryptJsonData(input);
	System.out.println("the encyptiondata:::::::::"+encdata);
	String decData=json.decryptJsonData(encdata);
	System.out.println("the decrypted data::::"+decData);
	
		
		*/
		
		TestMain test=new TestMain();
		
		String data=test.getFile();
		
		System.out.println("hiiiiiiiii");
		InputStream issuerInfoStream =TestMain.class.getResourceAsStream("/Request.xml");
	
		
		
		 File file = new File("/home/mahanteshm/Documents/ESIGNED/CDACRESP.xml");  
	        JAXBContext jaxbContext = JAXBContext.newInstance(EsignResp.class);  
	   
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        EsignResp que= (EsignResp) jaxbUnmarshaller.unmarshal(file);  
	          
	        System.out.println(que.getSignatures().getDocSignature()+" "+que.getResCode());  
	        System.out.println("Answers:");  
	
	
	}

	private  String getFile() {
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
