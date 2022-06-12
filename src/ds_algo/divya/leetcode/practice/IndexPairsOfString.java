package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IndexPairsOfString {

	public static int[][] indexPairs(String text, String[] words) {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			List<Integer> list = findIndices(word, text);
			for (int j : list) {
				int start = j;
				int end = start + word.length() - 1;
				if (!map.containsKey(j)) {
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(end);
					map.put(start, temp);
				} else {
					map.get(start).add(end);
				}
			}
		}
		List<int[]> points = new ArrayList<int[]>();
		for (int key : map.keySet()) {
			List<Integer> temp = map.get(key);
			Collections.sort(temp);
			for (int end : temp) {
				points.add(new int[] { key, end });
			}
		}
		return points.toArray(new int[points.size()][2]);
	}

	private static List<Integer> findIndices(String word, String text) {
		List<Integer> list = new ArrayList<Integer>();
		int index = 0;
		while (index != -1) {
			index = text.indexOf(word, index);
			if (index != -1) {
				list.add(index);
				index++;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		String text = "thestoryofleetcodeandme";
		String[] words = { "story", "fleet", "leetcode" };
		ArrayUtil.print(indexPairs(text, words));
	}

}
