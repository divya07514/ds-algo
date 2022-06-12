package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary {

	/**
	 * Self implemented solution
	 * 
	 * @param words
	 * @param order
	 * @return
	 */
	public static boolean isAlienSorted(String[] words, String order) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < order.length(); i++) {
			map.put(order.charAt(i), i);
		}

		int left = 0;
		int right = 1;

		while (right < words.length) {
			String one = words[left++];
			String two = words[right++];
			int min = Math.min(one.length(), two.length());
			boolean allCharMatch = true;
			int i = 0;
			for (; i < min; i++) {
				char c1 = one.charAt(i);
				char c2 = two.charAt(i);
				if (map.get(c1) > map.get(c2)) {
					return false;
				} else if (map.get(c1) < map.get(c2)) {
					break;
				} else {
					continue;
				}
			}
			if (allCharMatch && i == min) {
				if (one.length() > two.length()) {
					return false;
				}
			}

		}
		return true;
	}

	public static void main(String[] args) {
		String[] words = { "hello", "leetcode" };
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		System.out.println(isAlienSorted(words, order));
	}

}
