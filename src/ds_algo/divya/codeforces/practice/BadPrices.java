package ds_algo.divya.codeforces.practice;

import java.util.LinkedList;
import java.util.Scanner;

public class BadPrices {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			int result = getBadDays(nums);
			System.out.println(result);
		}
	}

	private static int getBadDays(int[] nums) {
		LinkedList<Integer> stack = new LinkedList<>();
		int count = 0;
		int n = nums.length;
		for (int i = n - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				stack.push(nums[i]);
			} else {
				if (nums[i] > stack.peek()) {
					count++;
				} else {
					while (!stack.isEmpty() && nums[i] < stack.peek()) {
						stack.pop();
					}
					stack.push(nums[i]);
				}
			}
		}
		return count;
	}

}
