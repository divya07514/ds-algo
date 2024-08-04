package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Two pointer approach does not have to always start from extreme ends of the array.
 * @author divya.thakur
 *
 */
public class KdiffPairsinanArray {

	public int findPairs(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = 0;
		Arrays.sort(nums);
		Set<String> set = new HashSet();
		int left = 0;
		int right = 1;

		while (left < nums.length && right < nums.length) {
			int diff = nums[right] - nums[left];
			if (diff < k) {
				right++;
			} else if (diff > k) {
				left++;
				if (left == right) {
					right++;
				}
			} else {
				String temp = nums[left] + "," + nums[right];
				if (!set.contains(temp)) {
					set.add(temp);
					result++;
				}
				right++;
			}
		}
		return result;
	}

}
