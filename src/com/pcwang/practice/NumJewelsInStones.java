package com.pcwang.practice;

import java.lang.reflect.Method;

/**
 * ��ʯ��ʯͷ
 * @author wangpeicai
 *
 */
public class NumJewelsInStones {

	public static void main(String[] args) {
		String J = "z";
		String S = "ZZ";
		method(J,S);
	}
	
	 public static int method(String J, String S) {
		 int count = 0;
		 for (int i = 0;i < S.length();i++) {
			 if (J.indexOf(S.charAt(i)) >= 0) {
				 count ++;
			 }
		 }
		 System.out.println("���="+count);
		 return count;
	 }
}
