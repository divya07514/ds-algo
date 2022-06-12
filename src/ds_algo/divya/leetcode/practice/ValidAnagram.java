package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		if(s.length()!=t.length()) {
			return false;
		}
		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		Map<Character, Integer> map2 = new HashMap<Character, Integer>();
		populateMap(s, map1);
		boolean ans = true;
		for (Character ch : map1.keySet()) {
			int c1 = 0;
			int c2 = 0;
			if(map1.containsKey(ch)) {
				c1=map1.get(ch);
				map1.remove(ch);
			}
			if(map2.containsKey(ch)) {
				c2=map2.get(ch);
				map2.remove(ch);
			}
			if (c1 != c2) {
				ans = false;
				break;
			}
		}
		return ans;
	}

	private static void populateMap(String s, Map<Character, Integer> map) {
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!map.containsKey(ch)) {
				map.put(s.charAt(i), 1);
			} else {
				map.put(ch, map.get(ch)+1);
			}
		}
	}

	public static void main(String[] args) {
		String s = "a";
		String t = "ab";
		System.out.println(isAnagram(s, t));
	}

}
