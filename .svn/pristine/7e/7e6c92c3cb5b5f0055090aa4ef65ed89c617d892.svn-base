package com.evolvus.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class GenerateKeys {

	private KeyPairGenerator keyGen;
	
	private KeyPair pair;
	
	private PrivateKey privateKey;
	
	private PublicKey publicKey;
	
	
	public GenerateKeys(int keyLength)
	{
		try {
			this.keyGen=KeyPairGenerator.getInstance("RSA");
			
			this.keyGen.initialize(keyLength);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	

	public PublicKey getPublicKey() {
		return publicKey;
	}

	
	public  void createKeys()
	{
		this.pair=this.keyGen.generateKeyPair();
		this.privateKey=pair.getPrivate();
		this.publicKey=pair.getPublic();
	}
	
	
	/*public static void main(String[] args) {
		GenerateKeys generateKeys;
		try
		{
		
			generateKeys=new GenerateKeys(1024);
			generateKeys.createKeys();
			generateKeys.writeToFiles("KeyPair/publicKey", generateKeys.getPublicKey().getEncoded());
			generateKeys.writeToFiles("KeyPair/privateKey", generateKeys.getPrivateKey().getEncoded());
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
*/
	void writeToFiles(String path, byte[] key) {
		// TODO Auto-generated method stub
		
		File file=new File(path);
		file.getParentFile().mkdirs();
		
		try {
			FileOutputStream fos=new FileOutputStream(file);
			fos.write(key);
			fos.flush();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
}
