package com.pcwang.practice;

import java.lang.reflect.Method;

/**
 * 计算整数的各个数的乘积，减去各个数的和
 * @author wangpeicai
 *
 */
public class CalMultiSumSub {
	
	public static void main(String[] args) {
		System.out.println(method(223));
	}

	
	
	public static int method(int num) {
		//拆解数字
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
