package ds_algo.divya.leetcode.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder {

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> set = new HashSet<String>(wordList);
		if (!set.contains(endWord)) {
			return 0;
		}
		int result = 1;
		LinkedList<String> q = new LinkedList<>();
		q.add(beginWord);
		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs > 0) {
				String temp = q.poll();
				char[] array = temp.toCharArray();
				for (int i = 0; i < array.length; i++) {
					char ch = array[i];
					for (char c = 'a'; c <= 'z'; c++) {
						array[i] = c;
						String next = new String(array);
						if (set.contains(next)) {
							if (next.equals(endWord)) {
								return result + 1;
							}
							q.add(next);
							set.remove(next);
						}
					}
					array[i] = ch;
				}
				qs--;
			}
			result++;
		}

		return 0;
	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

		System.out.println(ladderLength(beginWord, endWord, wordList));
	}

}
