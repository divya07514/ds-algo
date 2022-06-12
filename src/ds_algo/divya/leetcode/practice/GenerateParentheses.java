package ds_algo.divya.leetcode.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParentheses {

	public static List<String> generateParenthesis_bruteForce(int n) {
		List<String> result = new ArrayList<String>();
		char[] array = new char[n * 2];
		boolean[] isVisited = new boolean[array.length];
		int i = 0;
		for (; i < n; i++) {
			array[i] = '(';
		}
		for (; i < n * 2; i++) {
			array[i] = ')';
		}
		List<Character> list = new ArrayList<Character>();
		Set<String> seen = new HashSet<String>();
		generate(result, array, isVisited, list, seen);
		return result;
	}

	private static void generate(List<String> result, char[] array, boolean[] isVisited, List<Character> list,
			Set<String> seen) {
		if (list.size() == array.length) {
			StringBuilder sb = new StringBuilder();
			for (char ch : list) {
				sb.append(ch);
			}
			if (!seen.contains(sb.toString())) {
				seen.add(sb.toString());
				if (isWellFormed(sb.toString())) {
					result.add(sb.toString());
				}
			}

		} else {
			for (int i = 0; i < array.length; i++) {
				isVisited[i] = true;
				list.add(array[i]);
				generate(result, array, isVisited, list, seen);
				list.remove(list.size() - 1);
				isVisited[i] = false;
			}
		}

	}

	private static boolean isWellFormed(String s) {
		Deque<Character> deque = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				deque.push(ch);
				continue;
			} else {
				if (deque.isEmpty()) {
					return false;
				}
				deque.pop();
			}
		}
		if (!deque.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		int open = 0;
		int close = 0;
		String temp = "";
		generate(result, open, close, n, temp);
		return result;
	}

	private static void generate(List<String> result, int open, int close, int n, String temp) {
		if (temp.length() == 2 * n) {
			result.add(temp);
			return;
		}
		if (open < n) {
			generate(result, open + 1, close, n, temp+"(");
		}
		if (close < open) {
			generate(result, open, close + 1, n, temp+")");
		}

	}

	public static void main(String[] args) {
		int n = 3;
		// System.out.println(generateParenthesis_bruteForce(n));
		System.out.println(generateParenthesis(n));

	}

}
