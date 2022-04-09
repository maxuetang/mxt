package com.mxt.sign;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Util {
    public static String createSHA256Str(String s) {
    	if(s==null)return null;
    	try {
			MessageDigest d = MessageDigest.getInstance("SHA-256");
			d.update(s.getBytes("UTF-8"));
			return hexSHA256(d.digest());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    private static String hexSHA256(byte[] b) {
    	StringBuffer sub = new StringBuffer();
    	for(int i = 0; i < b.length; ++i) {
    		String t = Integer.toHexString(b[i] & 0xFF);
    		sub.append(t.length() == 1? "0"+t:t);
    	}
    	return sub.toString();
    }
} 
