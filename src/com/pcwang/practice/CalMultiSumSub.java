package com.pcwang.practice;

import java.lang.reflect.Method;

/**
 * ���������ĸ������ĳ˻�����ȥ�������ĺ�
 * @author wangpeicai
 *
 */
public class CalMultiSumSub {
	
	public static void main(String[] args) {
		System.out.println(method(223));
	}

	
	
	public static int method(int num) {
		//�������
		int multi = 1;
		int sum = 0;
		int yu = 0;
		while (num != 0) {
			yu = num % 10;
			multi *= yu;
			sum += yu;
			num /= 10;
		}
		return multi - sum;
	}
}
