package medium;

import java.util.LinkedList;

/**
 * Count the number of mismatched braces.
 * (count+1)/2 is the answer. no need to do actual swaps
 * @author divya.thakur
 *
 */
public class MinimumNumberofSwapstoMaketheStringBalanced {

	public int minSwaps(String s) {
		if (s.length() == 0) {
			return 0;
		}

		LinkedList<Character> stack = new LinkedList();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[') {
				stack.push(c);
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					count++;
				}
			}
		}

		return (count + 1) / 2;
	}
}
