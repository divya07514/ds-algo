package easy;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class FindSubsequenceofLengthKWiththeLargestSum {

	public static int[] maxSubsequence(int[] nums, int k) {
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

		for (int i = 0; i < nums.length; i++) {
			q.offer(new int[] { nums[i], i });
			if (q.size() > k) {
				q.poll();
			}
		}

		Set<Integer> index = new HashSet<>();

		while (!q.isEmpty()) {
			int[] top = q.poll();
			index.add(top[1]);
		}

		int[] result = new int[k];

		int p = 0;
		for (int i = 0; i < nums.length; i++) {
			if (index.contains(i)) {
				result[p] = nums[i];
				++p;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { -1, -2, 3, 4 };
		System.out.println(maxSubsequence(nums, 3));

	}
}
