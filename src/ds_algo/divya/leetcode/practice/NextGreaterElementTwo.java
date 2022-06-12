package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class NextGreaterElementTwo {

	/**
	 * Self implemented solution
	 * 
	 * @param nums
	 * @return
	 */
	public static int[] nextGreaterElements(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		List<Integer> list = new ArrayList<>();
		LinkedList<Integer> temp = new LinkedList<>();
		int n = nums.length;
		boolean added = false;
		for (int i = n - 1; i > -1; i--) {
			if (temp.isEmpty()) {
				int current = i + 1;
				int mod = current % n;
				while (mod != i) {
					if (nums[mod] > nums[i] && !added) {
						list.add(nums[mod]);
						temp.add(nums[mod]);
						added = true;
					} else {
						temp.add(nums[mod]);
					}
					current = current + 1;
					mod = current % n;
				}
				if (!added && mod == i) {
					list.add(-1);
				}
			} else if (!temp.isEmpty() && temp.peek() > nums[i]) {
				list.add(temp.peek());
			} else if (!temp.isEmpty() && temp.peek() <= nums[i]) {
				while (!temp.isEmpty() && temp.peek() <= nums[i]) {
					temp.pop();
				}
				if (temp.isEmpty()) {
					list.add(-1);
				} else {
					list.add(temp.peek());
				}
			}
			temp.add(0, nums[i]);
		}
		Collections.reverse(list);
		int[] result = new int[n];
		int index = 0;
		for (int i = 0; i < n; i++) {
			result[i] = list.get(index++);
		}
		return result;
	}

	/**
	 * Leetcode solution
	 * 
	 * @param nums
	 * @return
	 */
	public int[] nextGreaterElements_leetcode(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		LinkedList<Integer> stack = new LinkedList<>();
		int i = 2 * nums.length - 1;
		int n = nums.length;
		int[] result = new int[n];
		for (; i >= 0; i--) {
			int mod = i % n;
			while (!stack.isEmpty() && nums[stack.peek()] <= nums[mod]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				result[mod] = -1;
			} else {
				result[mod] = nums[stack.peek()];
			}
			stack.push(mod);
		}
		return result;
	}

	
	public static void sortDesc(Integer[] nums) {
		Comparator<Integer> c = (a,b) -> b-a;
		Arrays.sort(nums, c);
		for(int i : nums) {
			System.out.print(i+" ");
		}
	}
	
	
	public static void main(String[] args) {
		Integer[] nums = { 1, 2, 1, 5, 7, 3, 2, -1, -6, 6, 7, -1, -7, -8, -5, 4, 6, 7 };
		//ArrayUtil.printArray(nextGreaterElements(nums));
		sortDesc(nums);
	}

}
