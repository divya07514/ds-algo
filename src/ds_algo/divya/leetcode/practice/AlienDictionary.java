package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlienDictionary {

	static boolean hasCycle;
	static StringBuilder sb;

	public static String alienOrder(String[] words) {

		Map<Character, List<Character>> map = new HashMap<>();
		Map<Character, Boolean> marked = new HashMap<>();
		sb = new StringBuilder();

		for (String s : words) {
			for (char c : s.toCharArray()) {
				if (!map.containsKey(c)) {
					map.put(c, new ArrayList<>());
				}
			}
		}

		for (int i = 1; i < words.length; i++) {
			String one = words[i - 1];
			String two = words[i];

			if (one.length() > two.length() && one.startsWith(two)) {
				return "";
			}

			for (int j = 0; j < Math.min(one.length(), two.length()); j++) {
				if (one.charAt(j) != two.charAt(j)) {
					map.get(one.charAt(j)).add(two.charAt(j));
					break;
				}
			}
		}
		hasCycle = false;
		Map<Character, Boolean> onStack = new HashMap<>();
		for (char c : map.keySet()) {
			if (map.containsKey(c) && !marked.containsKey(c)) {
				dfs(c, marked, onStack, map);
			}
			if (hasCycle) {
				return "";
			}
		}

		return sb.reverse().toString();
	}

	private static void dfs(char c, Map<Character, Boolean> marked, Map<Character, Boolean> onStack,
			Map<Character, List<Character>> map) {

		marked.put(c, true);
		onStack.put(c, true);

		for (char ch : map.get(c)) {
			if (!marked.containsKey(ch)) {
				dfs(ch, marked, onStack, map);
			} else if (onStack.get(ch)) {
				hasCycle = true;
			}
		}
		onStack.put(c, false);
		sb.append(c);
	}

	public static void main(String[] args) {
		String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
		System.out.println(alienOrder(words));
	}

}
