package com.pcwang.practice;

import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 * @author wangpeicai
 *
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		int [] nums = {3,2,2,3};
		//removeDuplicates(nums);
		removeElement(nums,3);
	}
	
	public static int removeElement(int[] nums,int val) {
		 int pos = 0;
		 int count = 0;
	        for (int i = 0;i < nums.length;i++) {
	            if (nums[i] != val) {
	                nums[pos] = nums[i];
	                pos++;
	            } else {
	            	count ++;
	            }
	        }
	        System.out.println(Arrays.toString(nums));
	        System.out.println(pos);
	        return nums.length-count;
	}
	/**
	 * 双指针，快慢指针
	 * @param nums
	 * @return
	 */
	public  static int removeDuplicates(int[] nums) {
        int pos = 0;
		for (int i = 1;i < nums.length;i++) {
			if (nums[i] != nums[pos]) {
				pos++;
				nums[pos] = nums[i];
			}
		}
		return pos+1;
    }
	
	
	
}
