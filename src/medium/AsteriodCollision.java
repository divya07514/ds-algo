package medium;

import java.util.LinkedList;

public class AsteriodCollision {

	public static int[] asteroidCollision(int[] nums) {
		int n = nums.length;

		if (n == 0) {
			return new int[0];
		}
		LinkedList<Integer> stack = new LinkedList();

		for (int i : nums) {
			if (stack.isEmpty()) {
				stack.push(i);
			} else if (stack.peek() > 0 && i > 0) {
				stack.push(i);
			} else if (stack.peek() < 0 && i < 0) {
				stack.push(i);
			} else if (stack.peek() < 0 && i > 0) {
				stack.push(i);
			} else {
				if (stack.peek() < Math.abs(i)) {
					while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(i)) {
						stack.pop();
					}
					if (stack.isEmpty()) {
						stack.push(i);
					} else if (stack.peek() > 0 && stack.peek() > Math.abs(i)) {
						continue;
					}else if(stack.peek()==Math.abs(i)) {
						stack.pop();
					} 
					else if (stack.peek() < 0) {
						stack.push(i);
					}

				} else if (stack.peek() == Math.abs(i)) {
					stack.pop();
				} else {
					continue;
				}
			}
		}

		int[] res = new int[stack.size()];

		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = stack.pop();
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { -2,2,1,-2 };
		System.out.println(asteroidCollision(nums));

	}

}
