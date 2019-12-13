package com.pcwang.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
下一个数是对上一个数的描述
如：
1211下一个数就是 一个1 ：11，一个2：12 两个1：21  合起来就是121221
 * @author wangpeicai
 *
 */
public class CountAndSay {
	
	public static void main(String[] args) {
		System.out.println("结果=="+create(4));
	}
	
	/**
	 * 生成序列
	 * @return
	 */
	public static String create(int n ) {
		Map<Integer,String>map = new HashMap<>();
		map.put(1, "1");
		map.put(2, "11");
		if (n == 1) return map.get(1);
		if (n == 2) return map.get(2);
		for (int i = 3;i <= 30;i++) {
			StringBuffer buf = new StringBuffer();
			String prev = map.get(i-1);
			int len = 1;
			//每次默认从第一个开始比较
			char p = prev.charAt(0);
			for (int j = 1;j < prev.length();j++) {
				char s = prev.charAt(j);
				if (p == s) {
					len ++;
				} else {
					buf = buf.append(len).append(p);
					len = 1;
					p = prev.charAt(j);
				}
			}
			buf = buf.append(len).append(p);
			map.put(i,buf.toString());
		}
		return map.get(n);
		
	}
	
	
	/**
	 * 标准题解
	 * @param n
	 * @return
	 */
	public String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n ; i++) {
            result = countAndSay(result);
        }
        return result;
    }

    public String countAndSay(String str) {
        int count = 1;
        char say = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == say) {
                count++;
                continue;
            } else {
                sb.append(count);
                sb.append(say);
                count = 1;
                say = str.charAt(i);
            }
        }
        sb.append(count);
        sb.append(say);
        return sb.toString();
    }

}
