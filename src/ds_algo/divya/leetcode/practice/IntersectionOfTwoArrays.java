package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {

	public static int[] intersect(int[] nums1, int[] nums2) {
		if(nums1==null || nums2==null) {
			return new int[0];
		}
		if(nums1.length==0 || nums2.length==0) {
			return new int[0];
		}
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums1.length; i++) {
			int temp = nums1[i];
			if (!map.containsKey(temp)) {
				map.put(temp, 1);
			} else {
				map.put(temp, map.get(temp) + 1);
			}
		}
		for (int i = 0; i < nums2.length; i++) {
			int temp = nums2[i];
			if (map.containsKey(temp)) {
				list.add(temp);
				map.put(temp, map.get(temp) - 1);
				if (map.get(temp) == 0) {
					map.remove(temp);
				}
			}
		}
		int[] res = new int[list.size()];
		int index = 0;
		for (int i : list) {
			res[index] = i;
			index++;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = { 4,9,5};
		int[] nums2 = { 9,4,9,8,4};
		ArrayUtil.printArray(intersect(nums1, nums2));

	}

}
