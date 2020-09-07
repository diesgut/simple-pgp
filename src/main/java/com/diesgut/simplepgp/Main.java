package com.diesgut.simplepgp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.diesgut.simplepgp.core.IMessageEncryptor;
import com.diesgut.simplepgp.crypt.PGPFactory;

public class Main {

	IMessageEncryptor messageEncryptor;

	public static void main(String[] args) {
		Main main=new Main();
		main.test();
	}
	
	public Main() {
		messageEncryptor = PGPFactory.getEncyptor();
		
	}
	
	public void test() {
		String passPhrase="passPhrase";
		
		String base="C:"+File.separator+"CORE";
		String publicKey=base+File.separator+"key.pub.asc";
		String privateKey=base+File.separator+"key.sec.asc";
		String fileInput=base+File.separator+"246.TXT";
		String fileOutput=base+File.separator+"246.TXT.pgp";;

		try {
			
			FileInputStream publicKeyIS = new FileInputStream(publicKey);
			FileInputStream privateKeyIS = new FileInputStream(privateKey);
			
			FileInputStream file = new FileInputStream(fileInput);
			FileOutputStream out = new FileOutputStream(fileOutput);
			
			messageEncryptor.encrypt( publicKeyIS, "test-message.txt", file, out);
			
			 file = new FileInputStream(fileOutput);
			out = new FileOutputStream(fileInput+"_");
			 
			 ByteArrayOutputStream plainResult = new ByteArrayOutputStream();
			 messageEncryptor.decrypt(passPhrase, privateKeyIS, file, plainResult);
			 System.out.println(new String(plainResult.toByteArray()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
