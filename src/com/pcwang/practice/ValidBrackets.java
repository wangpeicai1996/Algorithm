package com.pcwang.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBrackets {
	
	
	
	public static void main(String[] args) {
		String s = "([])";
		//System.out.println("結果="+isValid(s));
		System.out.println(right(s));
	}
	
	
	/**
	 * 栈方法
	 * 思路：
	 * 由内到外，将所有左括号压入栈,当遇到第一个右括号的时候，拿出栈顶的左括号与它比较，如果匹配，则将元素弹出，继续下一个符号比较
	 * 当所有的符号都比较完毕之后，栈内的所有元素弹出，则字符串为true
	 * 如果字符串为空，栈对象弹出会报空指针异常，所以如果栈为空，即第一个元素就不是左括号时，压入一个默认值
	 * @return
	 */
	public static boolean right(String s) {
		char [] ch = s.toCharArray();
		Stack<String> str = new Stack<String>();
		Map<String,String> map = new HashMap<>();
		map.put(")", "(");
		map.put("}", "{");
		map.put("]", "[");
		for (int i = 0;i < ch.length;i++) {
			String e = String.valueOf(ch[i]);
			if (map.containsKey(e)) {
				if (")".equals(e) || "}".equals(e) || "]".equals(e)) {
					String top = "";
					if (str.empty()) {
						str.push("1");
					} else {
						top = str.pop();
					}
					if (!top.equals(map.get(e))) {
						return false;
					}
					
				}else {
					str.push(e);
				}
			}
			
		}
		if (str.empty()) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 适用于(){},()],(,),({[]}),""
	 * 不适用于(([]){})
	 * @param s
	 * @return
	 */
   public static boolean isValid(String s) {
        boolean result = false;
        s = s.trim();
        if (s.length() == 0) return true;
        Map<String,Integer> map = new HashMap<>();
        map.put("(",1);
        map.put("{",2);
        map.put("[",3);
        map.put(" ",0);
        map.put(")",-1);
        map.put("}",-2);
        map.put("]",-3);
        char [] ch = s.toCharArray();
        int tail = 0;
        int index = 0;
        for (int i = 0;i < ch.length;i++) {
        	String s1 = String.valueOf(ch[i]);
        	if ("(".equals(s1)) tail = s.indexOf(")");
        	if ("{".equals(s1)) tail = s.indexOf("}");
        	if ("[".equals(s1)) tail = s.indexOf("]");
        	if (")".equals(s1)) index = s.indexOf("(");
        	if ("]".equals(s1)) index = s.indexOf("[");
        	if ("}".equals(s1)) index = s.indexOf("}");
        	if (tail < 0) return false;
        	if (index < 0) return false;
    		for (int j = i; j <= tail ;j++,tail--) {
    			String s2 = String.valueOf(ch[j]);
    			String s3 = String.valueOf(ch[tail]);
    			if (map.containsKey(s2) && map.containsKey(s3)) {
    				if (map.get(s2)+map.get(s3) == 0) {
    					result = true;
    				} else {
    					return false;
    				}
    			}else {
    				return false;
    			}
    		}
        }
	   return result ;
    }
}
