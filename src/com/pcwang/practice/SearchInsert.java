package com.pcwang.practice;
/**
 * ËÑË÷²åÈëÎ»ÖÃ
 * @author wangpeicai
 *
 */
public class SearchInsert {

	
	public static void main(String[] args) {
		int [] nums = {1,3,5,6};
		int target = 0;
		System.out.println(searchInsert(nums,target));
	}
	
	
	public static int searchInsert(int [] nums,int target) {
		int i = 0;
		if (target > nums[nums.length-1]) return nums.length; 
		while (target > nums[i]) {
			if (target == nums[i]) {
				return i;
			}
			i++;
		}
		return i;
	}
	
}
