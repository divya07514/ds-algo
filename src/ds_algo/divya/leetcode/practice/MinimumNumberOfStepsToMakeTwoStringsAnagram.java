package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

	public  static int minSteps(String s, String t) {
		if (s.equals(t)) {
			return 0;
		}
		Map<Character, Integer> smap = getMap(s);
		Map<Character, Integer> tmap = getMap(t);
		int count = 0;
		Set<Character> set = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
			set.add(t.charAt(i));
		}

		for (char ch : set) {
			int one = 0;
			int two = 0;
			if (smap.containsKey(ch)) {
				one = smap.get(ch);
			}
			if (tmap.containsKey(ch)) {
				two = tmap.get(ch);
			}
			if (two < one) {
				count = count + Math.abs(two - one);
			}
		}
		return count;
	}

	public static Map<Character, Integer> getMap(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
		}
		return map;
	}

	public static void main(String[] args) {
		String s = "leetcode";
		String t = "practice";
		System.out.println(minSteps(s, t));

	}

}
