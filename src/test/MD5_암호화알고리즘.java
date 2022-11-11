package test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5_암호화알고리즘 {
	
	public static void main(String[] args) {
		
		/* 암호화할 텍스트 */
		String text = "1234";
		
		/* MD5 암호화  */
		String encrypt = testMD5(text);
		
		/* MD5 암호화 결과  */
		System.out.println("MD5 암호화 요청 텍스트 : " + text);
		System.out.println("MD5 암호화 완료 텍스트 : " + encrypt);
		
		return;
	}
	
	public static String testMD5(String pwd) {
	    String MD5 = "";
	    try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(pwd.getBytes());
	        byte byteData[] = md.digest();
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        MD5 = sb.toString();
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	        MD5 = null;
	    }
	    return MD5;
	}
}