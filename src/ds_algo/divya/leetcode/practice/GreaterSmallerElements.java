package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GreaterSmallerElements {

	/**
	 * Find Next greater element to current element in the right side.
	 * 
	 * @param nums
	 * @return
	 */
	public static List<Integer> nextGreaterElement(int[] nums) {

		List<Integer> right = new ArrayList<>();
		LinkedList<Integer> stack = new LinkedList<Integer>();

		for (int i = nums.length - 1; i > -1; i--) {
			if (stack.isEmpty()) {
				right.add(-1);
			} else if (!stack.isEmpty() && stack.peek() > nums[i]) {
				right.add(stack.peek());
			} else if (!stack.isEmpty() && stack.peek() <= nums[i]) {
				while (!stack.isEmpty() && stack.peek() <= nums[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					right.add(-1);
				} else {
					right.add(stack.peek());
				}
			}
			stack.push(nums[i]);
		}

		Collections.reverse(right);
		return right;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 2, 4 };
		System.out.println(nextGreaterElement(nums));
	}

}
