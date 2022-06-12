package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceIII {

	public static int shortestWordDistance(String[] words, String word1, String word2) {

		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			String s = words[i];
			if (!map.containsKey(s)) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(s, list);
			} else {
				map.get(s).add(i);
			}
		}

		if (word1.equals(word2)) {
			List<Integer> list = map.get(word1);
			int min = Integer.MAX_VALUE;
			for (int i = 1; i < list.size(); i++) {
				min = Math.min(min, Math.abs(list.get(i) - list.get(i - 1)));
			}
			return min;
		}
		int min = Integer.MAX_VALUE;
		List<Integer> one = map.get(word1);
		List<Integer> two = map.get(word2);
		int i = 0;
		int j = 0;
		while (i < one.size() && j < two.size()) {
			min = Math.min(min, Math.abs(one.get(i) - two.get(j)));
			if (one.get(i) < two.get(j)) {
				i++;
			} else {
				j++;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "practice";
		String word2 = "makes";
		System.out.println(shortestWordDistance(words, word1, word2));

	}

}
