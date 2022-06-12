package ds_algo.divya.leetcode.practice;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

	/**
	 * 
	 * Time Limit Exceed error.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static int[] maxSlidingWindow_tle(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];
		int index = 0;
		int left = 0;
		int right = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
		while (right < k) {
			pq.add(new Integer(nums[right]));
			right++;
		}
		result[index++] = pq.peek();
		pq.remove(nums[left]);
		left++;
		for (; right < nums.length; right++) {
			pq.add(new Integer(nums[right]));
			if (pq.size() == k) {
				result[index++] = pq.peek();
				pq.remove(nums[left]);
				left++;
			}
		}
		return result;
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k > nums.length) {
			return new int[0];
		}
		int[] result = new int[nums.length - k + 1];
		ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
		int i = 0;
		while (i < nums.length) {
			if (!ad.isEmpty() && ad.peekFirst() == i - k) {
				ad.pollFirst();
			}
			;
			while (!ad.isEmpty() && nums[ad.peekLast()] < nums[i]) {
				ad.pollLast();
			}
			ad.offerLast(i);
			if (i >= k - 1) {
				result[i - k + 1] = nums[ad.peekFirst()];
			}
			i++;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		ArrayUtil.printArray(maxSlidingWindow_tle(nums, k));
		System.out.println();
		ArrayUtil.printArray(maxSlidingWindow(nums, k));
	}

}
