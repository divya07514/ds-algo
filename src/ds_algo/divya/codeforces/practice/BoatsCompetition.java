package ds_algo.divya.codeforces.practice;

import java.util.Arrays;
import java.util.Scanner;

public class BoatsCompetition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int i = 0; i < count; i++) {
			int size = sc.nextInt();
			int[] nums = new int[size];
			int index = 0;
			for (int j = 0; j < size; j++) {
				nums[index++] = sc.nextInt();
			}
			int result = teamCount(nums);
			System.out.println(result);
		}
	}

	private static int teamCount(int[] nums) {
		Arrays.sort(nums);
		int maxCount = 0;
		for (int i = 2; i <= 2 * nums.length; i++) {
			int count = 0;
			int left = 0;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[left] + nums[right];
				if (sum == i) {
					count++;
					left++;
					right--;
				} else if (sum < i) {
					left++;
				} else {
					right--;
				}
			}
			maxCount = Math.max(maxCount, count);
		}

		return maxCount;
	}

}
