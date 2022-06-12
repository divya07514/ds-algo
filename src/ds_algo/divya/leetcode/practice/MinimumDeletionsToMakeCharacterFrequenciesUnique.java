package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

	public static int minDeletions(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
		}
		Set<Integer> used = new HashSet<>();
		int result = 0;
		for (char ch : map.keySet()) {
			int count = map.get(ch);
			while (count > 0) {
				if (!used.contains(count)) {
					used.add(count);
					break;
				}
				count--;
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "ccaaffddecee";
		System.out.println(minDeletions(s));
	}

}
