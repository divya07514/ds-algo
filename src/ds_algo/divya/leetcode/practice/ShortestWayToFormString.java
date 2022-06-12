package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class ShortestWayToFormString {

	/**
	 * Self implemented solution.
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	public static int shortestWay_self(String source, String target) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < source.length(); i++) {
			char ch = source.charAt(i);
			map.put(ch, 1);
		}
		for (int i = 0; i < target.length(); i++) {
			char ch = target.charAt(i);
			if (!map.containsKey(ch)) {
				return -1;
			}
		}
		int result = 0;
		int j = 0;
		while (target.length() > j) {
			String temp = source;
			int i = 0;
			while (temp.length() > i) {
				if (j >= target.length()) {
					break;
				}
				char one = temp.charAt(i);
				char two = target.charAt(j);
				if (one == two) {
					i++;
					j++;
				} else {
					i++;
				}
			}
			result++;
		}
		return result;
	}

	/**
	 * Leetcode solution.
	 * @param source
	 * @param target
	 * @return
	 */
	public static int shortestWay_leetcode(String source, String target) {
		if (source.equals(target))
			return 1;
		int k = source.length();
		int n = target.length();
		int ans = 0;
		int i = 0;
		while (i < n) {
			int base = i;
			int j = 0;
			while (j < k) {
				if (i < n && source.charAt(j) == target.charAt(i)) {
					i++;
				}
				j++;
			}
			if (i == base)
				return -1;

			ans++;
		}
		return ans;
	}

	public static void main(String[] args) {
		String source = "abc";
		String target = "abcbc";
		System.out.println(shortestWay_self(source, target));

	}

}
