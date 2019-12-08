package com.pcwang.practice;

import java.util.Stack;

public class IntReverse {
	public static void main(String[] args) {
		System.out.println(reverse(-123));
		stackWay(45627141);
	}

	    public static int reverse(int x) {
	        int rev = 0;
			int yu = 0;
			while (x != 0) {
				yu = x % 10;
				//闃叉鏁存暟婧㈠嚭
				if (rev > Integer.MAX_VALUE/10 || (rev < Integer.MIN_VALUE/10 && yu > 7)) return 0;
				if (rev < Integer.MIN_VALUE/10 || (rev < Integer.MIN_VALUE/10 && yu < -8)) return 0;
				rev = rev * 10 + yu;
				x /= 10;
			}
			return rev;
	    }
	    
	    
	    public static int stackWay (Integer x) {
	    	if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return 0; 
	    	int result = 0;
	    	int flag = 1;
	    	if (x < 0) {
	    		flag = -1;
	    	}
	    	Stack stack = new Stack<Integer>();
	    	int yu = 0;
	    	while (x != 0) {
	    		yu = Math.abs(x) % 10;
	    		stack.push(yu);
	    		x/=10;
	    	}
	    	for (int i = 0,n = stack.size();i < stack.size();i++,n--) {
	    		int num = (int) stack.get(i);
	    		result += num * Math.pow(10, n-1);
	    	}
	    	if (flag == -1) {
	    		result = result * -1;
	    	}
	    	System.out.println("翻转的结果="+result);
	    	return result;
	    }
}
