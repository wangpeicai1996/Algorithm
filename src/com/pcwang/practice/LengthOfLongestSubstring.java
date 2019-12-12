package com.pcwang.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 无重复字符的最长子串
 * @author wangpeicai
 *
 */
public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		method("aab");
	}
	
	
	public  static int method(String s) {
		if (s.length() == 1) return 1; 
		String sub = "";
		int maxCount = 0;
		int count = 0;
		int index = 0;
		int cc = 0;
		boolean flag = false;
		for (int i = 1;i < s.length();i++) {
			sub = s.substring(index,i);
			String ch = String.valueOf(s.charAt(i));
			if (sub.indexOf(ch) >= 0) {
				cc = count;
				index = i;
				flag = true;
			}
			count = sub.length();
			if (count > cc) {
				maxCount = count;
			}
			if (!flag) {
				maxCount = s.length();
			}
		}
		System.out.println("max="+maxCount);
		return maxCount;
	}
	
	
}
