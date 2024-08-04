package medium;

import java.util.LinkedList;

/**
 * Simulate the push and pop actions to check for valid sequence
 * @author divya.thakur
 *
 */
public class ValidateStackSequences {

	public boolean validateStackSequences(int[] pushed, int[] popped) {

		if (pushed.length != popped.length) {
			return false;
		}

		LinkedList<Integer> stack = new LinkedList();
		int index = 0;
		for (int i = 0; i < pushed.length; i++) {
			stack.push(pushed[i]);
			while (!stack.isEmpty() && stack.peek() == popped[index]) {
				stack.pop();
				index++;
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}

}
