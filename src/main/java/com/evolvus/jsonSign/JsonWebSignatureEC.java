package com.evolvus.jsonSign;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;

public class JsonWebSignatureEC {

	public void signData(String jsondata) {
		try {
			KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
			keyGenerator.initialize(1024);

			KeyPair kp = keyGenerator.genKeyPair();
			RSAPublicKey publicKey = (RSAPublicKey) kp.getPublic();
			RSAPrivateKey privateKey = (RSAPrivateKey) kp.getPrivate();

			// Create RSA-signer with the private key
			JWSSigner signer = new RSASSASigner(privateKey);

			// Prepare JWS object with simple string as payload
			JWSObject jwsObject = new JWSObject(new JWSHeader.Builder(JWSAlgorithm.RS256).keyID("123").build(),
					new Payload("In RSA we trust!"));

			// Compute the RSA signature
			jwsObject.sign(signer);

			// To serialize to compact form, produces something like
			// eyJhbGciOiJSUzI1NiJ9.SW4gUlNBIHdlIHRydXN0IQ.IRMQENi4nJyp4er2L
			// mZq3ivwoAjqa1uUkSBKFIX7ATndFF5ivnt-m8uApHO4kfIFOrW7w2Ezmlg3Qd
			// maXlS9DhN0nUk_hGI3amEjkKd0BWYCB8vfUbUv0XGjQip78AI4z1PrFRNidm7
			// -jPDm5Iq0SZnjKjCNS5Q15fokXZc8u0A
			String s = jwsObject.serialize();

			// To parse the JWS and verify it, e.g. on client-side
			jwsObject = JWSObject.parse(s);

			JWSVerifier verifier = new RSASSAVerifier(publicKey);

			jwsObject.verify(verifier);

			// assertEquals("In RSA we trust!",
			String dec = jwsObject.getPayload().toString();
			System.out.println("the plain data" + dec);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void aA128CBC_HS256(String val) {
		try {
			Date now = new Date();

			JWTClaimsSet jwtClaims = new JWTClaimsSet.Builder().issuer("https://openid.net").subject(val)
					.audience(Arrays.asList("https://app-one.com", "https://app-two.com"))
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

			RSAPublicKey publicKey = (RSAPublicKey) this.getPublic("/data/RSA-KEY-PAIR/publicKey");

			RSAPrivateKey privateKey = (RSAPrivateKey) this.getPrivate("/data/RSA-KEY-PAIR/privateKey");

			// Create an encrypter with the specified public RSA key
			RSAEncrypter encrypter = new RSAEncrypter(publicKey);

			// Do the actual encryption
			jwt.encrypt(encrypter);

			// Serialise to JWT compact form
			String jwtString = jwt.serialize();

			System.out.println(jwtString);

			jwt = EncryptedJWT.parse(jwtString);

			// Create a decrypter with the specified private RSA key
			RSADecrypter decrypter = new RSADecrypter(privateKey);

			// Decrypt
			jwt.decrypt(decrypter);

			// Retrieve JWT claims
			System.out.println(jwt.getJWTClaimsSet().getIssuer());
			;
			System.out.println(jwt.getJWTClaimsSet().getSubject());
			System.out.println(jwt.getJWTClaimsSet().getAudience().size());
			System.out.println(jwt.getJWTClaimsSet().getExpirationTime());
			System.out.println(jwt.getJWTClaimsSet().getNotBeforeTime());
			System.out.println(jwt.getJWTClaimsSet().getIssueTime());
			System.out.println(jwt.getJWTClaimsSet().getJWTID());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private PrivateKey getPrivate(String filename) throws IOException, NoSuchAlgorithmException,
			InvalidKeySpecException {
		byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(spec);
	}

	private PublicKey getPublic(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}

}
