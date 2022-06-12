package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class GenerateStrings {
	
	//K is count of words
	// N is length of those words.

	public static String[] solution(int N, int K) {
		if (N == 0 || K == 0) {
			return new String[] { "" };
		}
		ArrayList<String> result = new ArrayList<String>();
		for (String p : solution(N-1, K)) {
			for (char l : new char[] { 'a', 'b', 'c' }) {
				int pLen = p.length();
				if (pLen == 0 || p.charAt(pLen - 1) != l) {
					result.add(p + l);
				}
			}
		}
		int prefSize = Math.min(result.size(), K);
		return result.subList(0, prefSize).toArray(new String[prefSize]);
	}

	public static void main(String[] args) {
		Arrays.stream(solution(5,3)).forEach(System.out::println);
	}

}
