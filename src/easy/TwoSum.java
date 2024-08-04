package easy;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		if (nums == null && nums.length < 2) {
			return new int[0];
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			}
		}
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (map.containsKey(diff)) {
				if (map.get(diff) != i) {
					result[0] = i;
					result[1] = map.get(diff);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] result = twoSum(nums, target);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
