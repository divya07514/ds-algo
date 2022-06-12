package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class BuildingsWithAnOceanView {
	
	public static int[] findBuildings(int[] nums) {

		List<Integer> list = new ArrayList<>();
		int n = nums.length;
		list.add(n - 1);
		int max = nums[n - 1];

		for (int i = nums.length - 2; i >=0; i--) {
			if (nums[i] > max) {
				list.add(i);
				max = nums[i];
			}
			System.out.println(max + ", " + i);
		}

		int[] result = new int[list.size()];
		int index = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			result[index++] = list.get(i);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 2, 3, 1 };
		System.out.println(findBuildings(nums));
	}

}
