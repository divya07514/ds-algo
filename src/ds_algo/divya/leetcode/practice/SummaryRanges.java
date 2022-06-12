package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		if (nums.length == 1) {
			result.add(nums[0]+"");
			return result;
		}
		int i = 0;
		int j = 1;
		int n = nums.length;
		String s = "";
		while (j < n) {
			if (nums[j] - nums[i] == 1) {
				if (s.isEmpty()) {
					s = s + nums[i];
				}
				j++;
				i++;
				continue;
			} else {
				if(s.isEmpty()) {
					s = String.valueOf(nums[i]);
				}else {
					s = s + "->" + String.valueOf(nums[i]);
				}
				result.add(s);
				s = "";
				i++;
				j++;
			}
		}
		if(i < n && !s.isEmpty()) {
			s = s + "->" + String.valueOf(nums[i]);
			result.add(s);
		}
		if(i < n && s.isEmpty()) {
			result.add(String.valueOf(nums[i]));
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {0,2,3,4,6,18,38,39};
		System.out.println(summaryRanges(nums));
	}

}
