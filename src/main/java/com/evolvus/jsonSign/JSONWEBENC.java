/**
 * 
 */
package com.evolvus.jsonSign;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;

/**
 * @author EVOLVUS\nagendrappae
 *
 */
public class JSONWEBENC {

	public String encryptJsonData(String data) {

		String jwtString = null;
		try {
			Date now = new Date();

			JWTClaimsSet jwtClaims = new JWTClaimsSet.Builder().issuer("https://www.evolvussolutions.com/")
					.subject(data)
					.audience(Arrays.asList("https://192.168.1.177:8443/FLUX/CDACRESPONSE", "https://app-two.com"))
					.expirationTime(new Date(now.getTime() + 1000 * 60 * 10)) // expires
																				// in
																				// 10
																				// minutes
					.notBeforeTime(now).issueTime(now)

					.jwtID(UUID.randomUUID().toString()).build();

			System.out.println(jwtClaims.toJSONObject());

			// Request JWT encrypted with RSA-OAEP-256 and 128-bit AES/GCM
			JWEHeader header = new JWEHeader(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A256GCM);

			// Create the encrypted JWT object
			EncryptedJWT jwt = new EncryptedJWT(header, jwtClaims);

			KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
			keyGenerator.initialize(1024);

			KeyPair kp = keyGenerator.genKeyPair();
			RSAPublicKey publicKey11 = (RSAPublicKey) kp.getPublic();
			RSAPrivateKey privateKey11 = (RSAPrivateKey) kp.getPrivate();

			RSAPublicKey publicKey = (RSAPublicKey) this.getPublicKey("/data/RSA-KEY-PAIR/publicKey");


			// Create an encrypter with the specified public RSA key
			RSAEncrypter encrypter = new RSAEncrypter(publicKey);

			// Do the actual encryption
			jwt.encrypt(encrypter);

			ObjectMapper mapper = new ObjectMapper();
			String	input = mapper.writeValueAsString(jwt);
System.out.println("json enc::::"+input);

			// Serialise to JWT compact form
			jwtString = jwt.serialize();
			Base64URL[] vvvv=jwt.split(".");
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(jwtString);
		return jwtString;
	}

	public String decryptJsonData(String data) {
		String originaldata=null;
		try{
		EncryptedJWT jwt = EncryptedJWT.parse(data);

		RSAPrivateKey privateKey = (RSAPrivateKey) this.getPrivateKey("/data/RSA-KEY-PAIR/privateKey");

		// Create a decrypter with the specified private RSA key
		RSADecrypter decrypter = new RSADecrypter(privateKey);

		// Decrypt
		jwt.decrypt(decrypter);
		
		originaldata=jwt.getJWTClaimsSet().getSubject();
		
		
		System.out.println(jwt.getJWTClaimsSet().getIssuer());
		;
		System.out.println(jwt.getJWTClaimsSet().getSubject());
		System.out.println(jwt.getJWTClaimsSet().getAudience().size());
		System.out.println(jwt.getJWTClaimsSet().getExpirationTime());
		System.out.println(jwt.getJWTClaimsSet().getNotBeforeTime());
		System.out.println(jwt.getJWTClaimsSet().getIssueTime());
		System.out.println(jwt.getJWTClaimsSet().getJWTID());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return originaldata;
	}

	private PrivateKey getPrivateKey(String filename) throws Exception {
		byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(spec);
	}

	private PublicKey getPublicKey(String filename) throws Exception {

		byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}

}
