package com.example.demo.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static String getMD5(String input) {
		try {
			String password = input;

			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());

			byte byteData[] = md.digest();

			// convert the byte to hex format method 1
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static String convertToMD5(String input) {
		String md5 = null;
		if (null == input)
			return null;
		try {
			// Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");
			// Update input string in message digest
			digest.update(input.getBytes(), 0, input.length());
			// Converts message digest value in base 16 (hex)
			md5 = new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {

		}
		return md5;
	}

	public static boolean matching(String orig, String compare) {
		String md5 = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(compare.getBytes());
			@SuppressWarnings("unused")
			byte[] digest = md.digest();
			md5 = new BigInteger(1, md.digest()).toString(16);

			return md5.equals(orig);

		} catch (NoSuchAlgorithmException e) {
			return false;
		}
	}

	public static String getMD5Hex(String input) {
		try {
			String password = input;

			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());

			byte byteData[] = md.digest();

			// convert the byte to hex format method 2
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
