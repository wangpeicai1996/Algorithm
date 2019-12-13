package com.pcwang.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * ����������һ���������У��������е�������˳����б������õ���һ��������ǰ�������£�

1.     1
2.     11
3.     21
4.     1211
5.     111221
��һ�����Ƕ���һ����������
�磺
1211��һ�������� һ��1 ��11��һ��2��12 ����1��21  ����������121221
 * @author wangpeicai
 *
 */
public class CountAndSay {
	
	public static void main(String[] args) {
		System.out.println("���=="+create(4));
	}
	
	/**
	 * ��������
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
			//ÿ��Ĭ�ϴӵ�һ����ʼ�Ƚ�
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
	 * ��׼���
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
