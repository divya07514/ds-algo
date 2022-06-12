package ds_algo.divya.leetcode.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrisonCellsAfterNDays {

	public static int[] prisonAfterNDays(int[] cells, int N) {
		Set<String> set = new HashSet<>();
		boolean cycle = false;
		int count = 0;
		for (int i = 0; i < N; i++) {
			int[] current = nextDay(cells);
			String state = Arrays.toString(current);
			if (!set.contains(state)) {
				set.add(state);
				count = count + 1;
			} else {
				cycle = true;
				break;
			}
			cells = current;
		}
		if(cycle) {
			if (N > count) {
				int left = N % count;
				for (int i = 0; i < left; i++) {
					cells = nextDay(cells);
				}
			}
		}
		return cells;
	}

	public static int[] nextDay(int[] nums) {
		int[] temp = new int[nums.length];
		int n = nums.length;
		temp[0] = 0;
		for (int i = 1; i < n - 1; i++) {
			temp[i] = (nums[i - 1] == nums[i + 1]) ? 1 : 0;
		}
		temp[n - 1] = 0;
		return temp;
	}

	public static void main(String[] args) {
		int[] cells = {0,1,0,1,1,0,0,1};
		int N = 7;
		System.out.println(prisonAfterNDays(cells, N));

	}

}
