package medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfStepsToMakeTwoStringsAnagramTwo {

	public static int minSteps(String s, String t) {

		Map<Character, Integer> smap = getCount(s);
		Map<Character, Integer> tmap = getCount(t);
		int count = 0;
		for (char c : tmap.keySet()) {
			if (!smap.containsKey(c)) {
				count = count + tmap.get(c);
			} else {
				int diff = tmap.get(c) - smap.get(c);
				if (diff > 0) {
					count = count + diff;
				}
			}
		}
		return count;
	}

	private static Map<Character, Integer> getCount(String s) {
		Map<Character, Integer> map = new HashMap();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
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
