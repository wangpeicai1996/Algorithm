package com.pcwang.practice;

public class TwoSum {
	
	public static void main(String[] args) {
		System.out.println(test());
	}
	
	public static int test() {
		int num = -123;
		int rev = 0;
		int yu = 0;
		while (num != 0) {
			yu = num % 10;
			if (rev > Integer.MAX_VALUE/10 || (rev < Integer.MIN_VALUE/10 && yu > 7)) return 0;
			if (rev < Integer.MIN_VALUE/10 || (rev < Integer.MIN_VALUE/10 && yu < -8)) return 0;
			rev = rev * 10 + yu;
			num /= 10;
		}
		return rev;
		
	}
	
	
	
   

}
