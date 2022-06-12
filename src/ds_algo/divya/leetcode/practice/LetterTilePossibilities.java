package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterTilePossibilities {

	static int count;

	public static int numTilePossibilities(String tiles) {
		count = 0;
		if (tiles.isEmpty()) {
			return count;
		}
		Set<String> set = new HashSet<String>();
		boolean[] marked = new boolean[tiles.length()];
		List<Character> list = new ArrayList<>();
		permute(tiles, set, list, marked);
		return count;
	}

	private static void permute(String tiles, Set<String> set, List<Character> list, boolean[] marked) {
		if (!list.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (char ch : list) {
				sb.append(ch);
			}
			String s = sb.toString();
			if (!set.contains(s)) {
				count++;
				set.add(s);
			}
		}
		for (int i = 0; i < tiles.length(); i++) {
			if (!marked[i]) {
				marked[i] = true;
				list.add(tiles.charAt(i));
				permute(tiles, set, list, marked);
				marked[i] = false;
				list.remove(list.size() - 1);
			}
		}

	}

	public static void main(String[] args) {
		String tiles = "AAB";
		System.out.println(numTilePossibilities(tiles));
	}

}
