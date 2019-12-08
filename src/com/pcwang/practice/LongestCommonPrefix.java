package com.pcwang.practice;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
	如果不存在公共前缀，返回空字符串 ""。
	示例 1:
	输入: ["flower","flow","flight"]
	输出: "fl"
	示例 2:
	输入: ["dog","racecar","car"]
	输出: ""
	解释: 输入不存在公共前缀。
	说明:
	所有输入只包含小写字母 a-z 。
 * @author wangpeicai
 *
 */
public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		String [] strs = {"flow","flower","flight"};
		System.out.println(solution(strs));
	}
	
	public static  String solution(String [] strs) {
		String prefix = "";
		if (strs.length == 0) return prefix;
		String minLengthStr = strs[0];
		for (int i = 0;i < strs.length;i++) {
			if (strs[i].length() < minLengthStr.length()) {
				minLengthStr = strs[i];
			}
		}
		String sub = "";
		String minSub = "";
		boolean flag = false;
		int index = -1;
		for (int n = 0;n < minLengthStr.length();n++) {
			minSub =  minLengthStr.substring(0,n+1);
			for (int j = 0;j < strs.length;j++) {
				sub = strs[j].substring(0,n+1);
				//一旦有不同，就跳出结束循环
				if (!minSub.equals(sub)) {
					flag = true;
				}
			}
			if (flag) {
				index = n;
				break;
			}
		}
		//最短循环完，没有不同的，说明最短就是公共前缀
		if (index == -1) {
			index = minLengthStr.length();
		}
		prefix = minLengthStr.substring(0,index);
		return prefix;
	}

}
