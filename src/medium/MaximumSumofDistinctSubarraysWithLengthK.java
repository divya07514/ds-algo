package medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumofDistinctSubarraysWithLengthK {

	public long maximumSubarraySum(int[] nums, int k) {

		int n = nums.length;
		if (nums == null || n == 0) {
			return 0;
		}

		int left = 0;
		int right = 0;
		Map<Integer, Integer> map = new HashMap();
		long max = 0L;
		long sum = 0L;

		while (right < n) {
			int i = nums[right];
			sum = sum + i;
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
			if (right - left + 1 == k) {
				if (map.size() == k) {
					max = Math.max(max, sum);
					sum = sum - nums[left];
					map.remove(nums[left]);
				} else {
					int j = nums[left];
					sum = sum - nums[left];
					if (map.get(j) == 0) {
						map.remove(j);
					}
				}
				left++;
			}
			right++;
		}

		return max;
	}

}
