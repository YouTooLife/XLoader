package net.youtoolife.test.xloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class XAAA {
	
	private String fileName;
	private String fileOutName;
	//private byte[] a;
	private byte[] b;
	
	public XAAA(String fileName, String fileOutName) {
		this.fileName = fileName;
		this.fileOutName = fileOutName;
	}
	
	private void printBytes(byte[] bytes) {
		System.out.println("startBytes: "+(new String(bytes)));
		for (int i = 0; i < bytes.length; i++)
			System.out.println(bytes[i]);
		System.out.println("end");
	}
	
	private byte[] getBytesFromFile(String fileName) throws Exception {
		//String fileName = "";
		FileInputStream fin = new FileInputStream(fileName);            
        byte[] bbuf = new byte[(int)(new File(fileName).length())];
        fin.read(bbuf);
        fin.close();
        return bbuf;
	}
	
	private void writeToFile(byte[] bbuf, String fileName) throws Exception {
		//String fileEnc= fileName+".enc";
		FileOutputStream fout = new FileOutputStream(fileName);            
        //byte[] bbuf0 = new byte[(int)(new File(fileName).length())];
        fout.write(bbuf);
        fout.close();
	}
	
	public byte[] b() {
		
		try {
		byte[] salt = "saltysalt".getBytes();
		char[] password = "peanuts".toCharArray();
		char[] iv = new char[16];
		Arrays.fill(iv, ' ');
		int keyLength = 16;

		int iterations = 1003;

		PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength * 8);
		SecretKeyFactory pbkdf2 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		
		byte[] aesKey = pbkdf2.generateSecret(spec).getEncoded();
		
		SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

		
		byte[] encryptedBytes = getBytesFromFile(fileName);//encryptBytes0;
		if (new String(encryptedBytes).startsWith("v10")) {
			encryptedBytes = Arrays.copyOfRange(encryptedBytes, 3, encryptedBytes.length);
		}
		
		cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(new String(iv).getBytes()));
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		//printBytes(decryptedBytes);
		b = decryptedBytes;
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return b;
	}
	
	public void a() {
		try {
			
			byte[] salt = "saltysalt".getBytes();
			char[] password = "peanuts".toCharArray();
			char[] iv = new char[16];
			Arrays.fill(iv, ' ');
			int keyLength = 16;

			int iterations = 1003;

			PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength * 8);
			SecretKeyFactory pbkdf2 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			
			byte[] aesKey = pbkdf2.generateSecret(spec).getEncoded();
			
			SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
			
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(new String(iv).getBytes()));

		    byte[] encryptBytes0 = cipher.doFinal(getBytesFromFile(fileName));
		    //System.out.println(new String(encryptBytes0));
		    //printBytes(encryptBytes0); 
		    //writeToFile(encryptBytes0, fileOutName);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
