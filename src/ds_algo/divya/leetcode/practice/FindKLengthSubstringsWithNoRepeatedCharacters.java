package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class FindKLengthSubstringsWithNoRepeatedCharacters {

	public static boolean allUnique(Map<Character, Integer> map) {
		System.out.println(map);
		for (char ch : map.keySet()) {
			if (map.get(ch) > 1) {
				return false;
			}
		}
		return true;
	}

	public static int numKLenSubstrNoRepeats(String s, int k) {
		if (k > s.length()) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		int count = 0;
		int left = 0;
		int right = 0;
		while (right < s.length()) {
			char ch = s.charAt(right);
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
			if (right - left + 1 == k) {
				if (allUnique(map)) {
					count++;
					System.out.println(count);
					if (map.get(s.charAt(left)) == 1) {
						map.remove(s.charAt(left));
					} else {
						map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
					}
					left++;
				} else {
					if (map.get(s.charAt(left)) == 1) {
						map.remove(s.charAt(left));
					} else {
						map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
					}
					left++;
				}
			}
			right++;
		}
		return count;
	}

	public static void main(String[] args) {
		String S = "havefunonleetcode";
		int K = 6;
		System.out.println(numKLenSubstrNoRepeats(S, K));

	}

}
