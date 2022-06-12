package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PartitionLabels {

	/**
	 * Self implemented solution
	 * 
	 * @param s
	 * @return
	 */
	public static List<Integer> partitionLabels(String s) {
		if (s == null || s.length() == 0) {
			return new ArrayList<Integer>();
		}
		List<Integer> list = new ArrayList<Integer>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
		}
		Set<Character> set = new HashSet<Character>();
		int right = 0;
		int left = 0;
		while (right < s.length()) {
			char ch = s.charAt(right);
			if (!set.contains(ch)) {
				set.add(ch);
				map.put(ch, map.get(ch) - 1);
				left = addResult(list, map, set, right, left);
				right++;
			} else {
				map.put(ch, map.get(ch) - 1);
				left = addResult(list, map, set, right, left);
				right++;
			}
		}
		return list;
	}

	private static int addResult(List<Integer> list, Map<Character, Integer> map, Set<Character> set, int right,
			int left) {
		if (checkForAllZeroFreq(set, map)) {
			list.add(right - left + 1);
			left = right + 1;
			set.clear();
		}
		return left;
	}

	private static boolean checkForAllZeroFreq(Set<Character> set, Map<Character, Integer> map) {
		for (Character ch : set) {
			if (map.get(ch) != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * LeetCode solution
	 * 
	 * @param S
	 * @return
	 */
	public static List<Integer> partitionLabels_leetcode(String S) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			map.put(ch, i);
		}
		int j = 0;
		int index = 0;
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < S.length(); i++) {
			j = Math.max(j, map.get(S.charAt(i)));
			if (i == j) {
				result.add(i - index + 1);
				index = i + 1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String s = "ababcbacadefegdehijhklij";
		System.out.println(partitionLabels(s));
		System.out.println(partitionLabels_leetcode(s));
	}

}
