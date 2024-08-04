package medium;

import java.util.LinkedList;

/**
 * Keep matching open and closed till you can. Also store positions of open and
 * star in a stack, as these will used if the string is unbalanced. When you see
 * open position greater than star position, this mean that string is
 * unbalanced.
 * 
 * @author divya.thakur
 *
 */
public class ValidParenthesisString {

	public boolean checkValidString(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		if (s.length() == 1) {
			if (s.charAt(0) == '*') {
				return true;
			} else {
				return false;
			}
		}

		LinkedList<Integer> open = new LinkedList();
		LinkedList<Integer> star = new LinkedList();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				open.push(i);
			} else if (c == '*') {
				star.push(i);
			} else {
				if (!open.isEmpty()) {
					open.pop();
				} else if (!star.isEmpty()) {
					star.pop();
				} else {
					return false;
				}
			}
		}

		while (!open.isEmpty()) {
			if (star.isEmpty()) {
				return false;
			} else if (open.peek() < star.peek()) {
				open.pop();
				star.pop();
			} else {
				return false;
			}
		}

		return true;

	}

}
