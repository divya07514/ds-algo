package easy;
import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

	public static int findLHS(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}

		int count = 0;

		for (int i : nums) {
			if (map.containsKey(i + 1)) {
				int one = map.get(i + 1);
				int two = map.get(i);
				count = Math.max(count, one + two);
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int [] nums = {1,3,2,2,5,2,3,7};
		System.out.println(findLHS(nums));

	}

}
