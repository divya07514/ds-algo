package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargestNumbers {

	public static String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		List<String> list = new ArrayList<String>();
		for (int i : nums) {
			list.add(String.valueOf(i));
		}
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String one = o1 + o2;
				String two = o2 + o1;
				return two.compareTo(one);
			}
		};
		list.sort(c);
		if (list.get(0).contentEquals("0")) {
			return "0";
		}
		String result = "";
		for (String s : list) {
			result = result + s;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 91, 101, 5, 9, 34 };
		System.out.println(largestNumber(nums));
		
		System.out.println(7/2);
	}

}
