package org.zerock.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtChecker {
	static final  String allowPattern = ".+\\.(jpg|gif|png|)$";
	public static boolean check(String fileName) {
		boolean result=false;
		
		   Pattern p = Pattern.compile(allowPattern);
	        Matcher m = p.matcher(fileName);
	        result = m.matches();
	  
		return result;
		
	}
	
//	public static void main(String[] args) {
//		String name="asdsad123.jpg";
//		System.out.println(check(name));
//	}
}
