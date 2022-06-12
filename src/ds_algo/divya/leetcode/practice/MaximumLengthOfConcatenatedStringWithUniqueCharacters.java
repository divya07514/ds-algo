package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthOfConcatenatedStringWithUniqueCharacters {

	public static int maxLength(List<String> arr) {
		int[] result = new int[1];
		max(arr, result, "", 0);
		return result[0];
	}

	private static void max(List<String> arr, int[] result, String current, int index) {
		if (index == arr.size() && uniqueChar(current) > result[0]) {
			result[0] = current.length();
			return;
		}
		if (index == arr.size()) {
			return;
		}
		max(arr, result, current, index+1);
		max(arr, result, current+arr.get(index), index+1);
	}

	private static int uniqueChar(String current) {
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < current.length(); i++) {
			char ch = current.charAt(i);
			if (!set.contains(ch)) {
				set.add(ch);
			} else {
				return -1;
			}
		}
		return set.size();
	}

	public static void main(String[] args) {
		List<String> arr = new ArrayList<String>();
		arr.add("un");
		arr.add("iq");
		arr.add("qe");
		System.out.println(maxLength(arr));
	}

}
