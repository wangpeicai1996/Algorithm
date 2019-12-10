package com.pcwang.practice;

public class HuiwenNum {

	public static void main(String[] args) {
		method(-121);
	}
	
	
	public static boolean method(int x) {
		boolean result = false;
		int org = x;
		if (org < 0) {
			return false;
		}
		int yu = 0;
		int res = 0;
		while (x != 0) {
			yu = x % 10;
			res = res * 10 + yu;
			x /= 10;
		}
		System.out.println(res);
		
		if (org == res) {
			result = true;
		}
		System.out.println(result);
		return result;
	}
	
}
