package com.pcwang.practice;

import java.util.HashMap;
import java.util.Map;

public class RomanReverse {
	
	public static void main(String[] args) {
		System.out.println(Roma("MMCCCLXVIII"));
		
	}
	
	public static  int Roma (String romaStr) {
		Map<String,Integer> map = new HashMap<>();
		map.put("I",1);
		map.put("V",5);
		map.put("X",10);
		map.put("L",50);
		map.put("C",100);
		map.put("D",500);
		map.put("M",1000);
		map.put("IV",4);
		map.put("IX",9);
		map.put("XL",40);
		map.put("XC",90);
		map.put("CD",400);
		map.put("CM",900);
		char [] ch = romaStr.toCharArray();
		
		int res = 0;
		for (int i = 0;i < ch.length;i++) {
			if (i != ch.length - 1) {
				Integer cur = map.get(String.valueOf(ch[i]));
				Integer right = map.get(String.valueOf(ch[i+1]));
				if (cur < right) {
					res = res + map.get(String.valueOf(ch[i])+String.valueOf(ch[i+1]));
					i = i + 1;
				} else {
					res = res + map.get(String.valueOf(ch[i]));
				}
			} else {
				res = res +  map.get(String.valueOf(ch[i]));
			}
		}
		return res;
	}

}
