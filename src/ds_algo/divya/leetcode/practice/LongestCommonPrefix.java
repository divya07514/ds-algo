package ds_algo.divya.leetcode.practice;

public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String sub = "";
		String temp = strs[0];
		boolean exit = false;
		for (int i = 0; i < temp.length(); i++) {
			sub = temp.substring(0, i+1);
			for (String s : strs) {
				if (!s.startsWith(sub)) {
					exit=true;
					sub = sub.substring(0,sub.length()-1);
					break;
				}
			}
			if(exit) {
				break;
			}
		}
		return sub;
	}

	public static void main(String[] args) {
		String[] strs = { "dog","racecar","car"};
		System.out.println(longestCommonPrefix(strs));
	}

}
