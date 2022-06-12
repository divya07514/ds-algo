package ds_algo.divya.leetcode.practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGame2 {

	public static int jump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 0;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		q.add(0);
		q.add(-1);
		int jumps = 0;
		boolean isFound = false;
		while (!q.isEmpty()) {
			while (q.peek() != -1) {
				int temp = q.poll();
				int nextIndex = nums[temp];
				while (nextIndex > 0) {
					if (nextIndex + temp == nums.length - 1) {
						jumps++;
						isFound = true;
						break;
					} else {
						if (!set.contains(nextIndex + temp)) {
							q.add(nextIndex + temp);
							set.add(nextIndex + temp);
						}
					}
					nextIndex--;
				}
				if (isFound) {
					break;
				}
			}
			if (isFound) {
				break;
			}
			if (q.size() == 1 && q.peek() == -1) {
				break;
			}
			q.add(-1);
			q.poll();
			jumps++;

		}
		return jumps;
	}


	public static void main(String[] args) {
		int[] nums = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0 };
		System.out.println(jump(nums));

	}

}
