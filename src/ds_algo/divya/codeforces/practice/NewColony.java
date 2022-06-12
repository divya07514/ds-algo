package ds_algo.divya.codeforces.practice;

import java.util.Scanner;

public class NewColony {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			int result = index(k, nums);
			System.out.println(result);
		}
	}

	private static int index(int k, int[] nums) {
		int index = 0;
		while (k-- > 0) {
			int i = 0;
			for (i = 0; i < nums.length - 1; i++) {
				if (nums[i] >= nums[i + 1]) {
					continue;
				} else {
					nums[i] = nums[i] + 1;
					break;
				}
			}
			index = i;
			if (i == nums.length-1) {
				return -1;
			}
		}
		return index + 1;
	}

}
