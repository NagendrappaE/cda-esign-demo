package com.evolvus.jsonSign;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Date;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.IOUtils;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.DirectEncrypter;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import javax.crypto.SecretKeyFactory;

public class JsonWebNestedSignature {
	
	public  void encrypt(String val)
	{
		
		try{
		// Generate 256-bit AES key for HMAC as well as encryption
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(256);
		SecretKey secretKey = keyGen.generateKey();

		this.writeToFile("/data/RSA-KEY-PAIR/publicKey", secretKey.getEncoded());
		
/*		String str = "PANKAJ";
		char[] password = str.toCharArray();
		byte[] salt = str.getBytes();
		
		//byte salt=10;
		KeySpec spec = new PBEKeySpec(password, salt, 65536, 256);
		
		SecretKey tmp = factory.generateSecret(spec);
		SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
		SecretKey secretKey=secret.ge*/
		

		// Create HMAC signer
		JWSSigner signer = new MACSigner(secretKey.getEncoded());

		// Prepare JWT with claims set
		JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
		    .subject("alice")
		    .issueTime(new Date())
		    .issuer("https://c2id.com")
		    .build();

		SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);

		// Apply the HMAC
		signedJWT.sign(signer);

		// Create JWE object with signed JWT as payload
		JWEObject jweObject = new JWEObject(
		    new JWEHeader.Builder(JWEAlgorithm.DIR, EncryptionMethod.A256GCM)
		        .contentType("JWT") // required to signal nested JWT
		        .build(),
		    new Payload(signedJWT));

		// Perform encryption
		jweObject.encrypt(new DirectEncrypter(secretKey.getEncoded()));

		// Serialise to JWE compact form
		String jweString = jweObject.serialize();
	
	}catch (Exception e)
		{
		e.printStackTrace();
		}
	}

	private void writeToFile(String path, byte[] encoded) throws IOException {
		File f = new File(path);
		f.getParentFile().mkdirs();

		FileOutputStream fos = new FileOutputStream(f);
		fos.write(encoded);
		fos.flush();
		fos.close();
	}

}
