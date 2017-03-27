package com.epam.osmachko.password_hash_algorithm;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHash {

	public static String md5Apache(String st) {
	    String md5Hex = DigestUtils.md5Hex(st);
	    return md5Hex;
	}
	
}
