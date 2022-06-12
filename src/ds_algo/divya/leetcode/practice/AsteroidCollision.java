package ds_algo.divya.leetcode.practice;

import java.util.Stack;

public class AsteroidCollision {

	public static int[] asteroidCollision(int[] nums) {
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				stack.push(nums[i]);
				continue;
			}
			while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(nums[i])) {
				stack.pop();
			}
			if (stack.isEmpty() || stack.peek() < 0) {
				stack.push(nums[i]);
			} else if (stack.peek() == Math.abs(nums[i])) {
				stack.pop();
			}
		}
		int[] ans = new int[stack.size()];
		for (int i = stack.size() - 1; i >= 0; i--) {
			ans[i] = stack.pop();
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 1, -1, -2, -2 };
		asteroidCollision(nums);
	}

}
