package easy;

import java.util.HashMap;
import java.util.Map;

public class XofAKindInADeckOfCards {
	
	public static boolean hasGroupsSizeX(int[] nums) {

		if (nums == null || nums.length == 0) {
			return false;
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}

		int val = 0;
		for (int i : map.keySet()) {
			val = gcd(val, map.get(i));
		}

		if (val < 2) {
			return false;
		}
		return true;

	}

	public static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		if (b == 0) {
			return a;
		}

		if (a == b) {
			return a;
		}

		if (a > b) {
			return gcd(a - b, b);
		}
		return gcd(a, b - a);
	}

	public static void main(String[] args) {
	  int[]	nums = {1,2,3,4,4,3,2,1};
	  System.out.println(hasGroupsSizeX(nums));

	}

}
