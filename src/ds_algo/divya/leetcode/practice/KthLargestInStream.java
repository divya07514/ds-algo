package ds_algo.divya.leetcode.practice;

import java.util.PriorityQueue;

public class KthLargestInStream {

	int k;
	PriorityQueue<Integer> pq;

	public KthLargestInStream(int k, int[] nums) {
		this.k = k;
		this.pq = new PriorityQueue<>();
		for (int i : nums) {
			pq.add(i);
			if (pq.size() > k) {
				pq.poll();
			}
		}
	}

	public int add(int val) {
		pq.add(val);
		if (pq.size() > k) {
			pq.poll();
		}

		return pq.peek();
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 8, 2 };
		KthLargestInStream kthLargest = new KthLargestInStream(3, nums);
		System.out.println(kthLargest.add(3)); // return 4
		System.out.println(kthLargest.add(5)); // return 5
		System.out.println(kthLargest.add(10)); // return 5
		System.out.println(kthLargest.add(9)); // return 8
		System.out.println(kthLargest.add(4)); // return 8

	}

}
