package medium;

import java.util.LinkedList;

/**
 * needs revision
 * @author divya.thakur
 *
 */
public class ScoreofParentheses {

	public static int scoreOfParentheses(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int score = 0;
		LinkedList<Integer> stack = new LinkedList();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(score);
				score = 0;
			} else {
				score = stack.pop() + Math.max(2 * score, 1);
			}
		}
		return score;
	}

	public static void main(String[] args) {
		String s ="(())";
		System.out.println(scoreOfParentheses(s));
	}

}
