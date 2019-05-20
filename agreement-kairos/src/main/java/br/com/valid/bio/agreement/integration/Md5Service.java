package br.com.valid.bio.agreement.integration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;

@Component
public class Md5Service {

	public static final String MD5_DIGEST_NAME = "MD5";
	
	public Md5Service() {
	}

	public String generateMd5(String imageMessage) throws NoSuchAlgorithmException { 
		MessageDigest md = MessageDigest.getInstance(MD5_DIGEST_NAME);
		byte[] messageBytes = md.digest(Optional.ofNullable(imageMessage).orElse("").getBytes());
		return new StringBuilder().append(Hex.encodeHex(messageBytes)).toString();
	}
	
}
