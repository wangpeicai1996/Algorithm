package com.pcwang.countsort;

import java.util.Arrays;

/**
 * 计数排序
 * @author wangpeicai
 *
 */
public class CountSort {

	public static void main(String[] args) {
		//计数排序基础版本-非稳定排序
		//basic();
		//offset();
		stable();
	}

	/**
	 * 计数排序，范围从0到9
	 * 非稳定
	 */
	public static void basic() {
		int [] orgArr = {5,2,1,2,8,9,3,6,0,4,7,5,4,9};
		int [] sortArr = new int [orgArr.length];
		//循环找原数组的最大值，确定计数数组长度
		int max = orgArr[0];
		for (int i = 0;i < orgArr.length;i++) {
			if (orgArr[i] > max) {
				max = orgArr[i];
			}
		}
		int [] countArr = new int [max+1];
		//循环原数组，计数
		for (int i = 0;i < orgArr.length;i++) {
			countArr[orgArr[i]]++;
		}
		//循环计数数组，将值放入新的数组
		int index = 0;
		for (int n = 0; n < countArr.length;n++) {
			for (int k = 0;k < countArr[n];k++) {
				sortArr[index++] = n;
			}
		}
		System.out.println("原数组="+Arrays.toString(orgArr));
		System.out.println("计数数组="+Arrays.toString(countArr));
		System.out.println("新数组="+Arrays.toString(sortArr));
	}
	
	/**
	 * 计数排序，范围从5到15，有偏移量，起始点以0为基准
	 * 非稳定
	 */
	public static void offset() {
		int [] orgArr = {5,7,9,10,12,14,13,15,13,12,8,5,6,9,10,15};
		int [] sortArr = new int[orgArr.length];
		//确定原数组中的最大值，最小值，计算数据范围，确定计数数组的长度
		int max = orgArr[0];
		int min = orgArr[0];
		for (int i = 0;i < orgArr.length;i++) {
			if (orgArr[i] > max) {
				max = orgArr[i];
			}
			if (orgArr[i] < min ) {
				min = orgArr[i];
			}
		}
		int offset = max - min;
		int [] countArr = new int[offset+1];
		//循环原数组，计数,减去偏移量
		for (int i = 0;i < orgArr.length;i++) {
			countArr[orgArr[i]-min]++;
		}
		//循环计数数组，插入新的数组，加上偏移量得到原始数据
		int index = 0;
		for (int j = 0;j < countArr.length;j++) {
			for (int k = 0;k < countArr[j];k++) {
				sortArr[index++] = j + min;
				
			}
		}
		System.out.println("原数组="+Arrays.toString(orgArr));
		System.out.println("计数数组="+Arrays.toString(countArr));
		System.out.println("新数组="+Arrays.toString(sortArr));
	}
	
	
	/**
	 * 计数排序稳定版(带偏移量)
	 * 对计数数组进行变形，第一次先记录每个值出现的个数，第二次对它进行变形，计算每个值出现的位置顺序
	 * 最后遍历的是原始数组，根据记录的位置输出到新数组
	 * 
	 * 比如学生成绩排序：
	 *	A		95
	 *	B		98
	 *	C		96
	 *	D		99
	 *	E		96
	 *	F 		98
	 */
	public static void stable() {
		int [] score = {95,98,90,99,96,98};
		System.out.println("原数组="+Arrays.toString(score));
		int [] newArr = new int [score.length];
		int max = score[0];
		int min = score[0];
		for (int i =0;i < score.length;i++) {
			if (score[i] > max) {
				max = score[i];
			}
			if (score[i] < min) {
				min = score[i];
			}
		}
		//第一次记录各个值出现的次数
		int offset = max - min;
		int [] countArr = new int [offset+1];
		for (int j = 0;j < score.length;j++) {
			countArr[score[j]-min]++;
		}
		System.out.println("计数数组统计元素的个数="+Arrays.toString(countArr));
		//再遍历循环计数数组，计算各个元素所处的位置
		//确定每个元素之前已经有多少个元素了，那这个元素就是下一个位置，以统计数组的个数去计算位置
		int sum = 0;
		for (int k = 0;k < countArr.length;k++) {
			sum += countArr[k];
			countArr[k] = sum;
		}
		System.out.println("计数数组记录元素的位置="+Arrays.toString(countArr));
		//倒序遍历原数组，用元素位置输出到新的数组，每次有元素找到位置输出之后，将位置的值-1，往前移
		for (int n = score.length - 1;n >= 0;n--) {
			//System.out.println(score[n]-min);
			//System.out.println(--countArr[score[n] - min]);
			newArr[(--countArr[score[n] - min])] = score[n];
		}
		System.out.println("排序后的数组="+Arrays.toString(newArr));
	}
	
}
