package easy;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RelativeRanks {

	public static String[] findRelativeRanks(int[] nums) {

		if (nums == null || nums.length == 0) {
			return new String[0];
		}

		Map<Integer, String> map = new LinkedHashMap<>();
		PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);

		for (int i : nums) {
			map.put(i, "");
			q.add(i);
		}

		int index = 1;
		while (!q.isEmpty()) {
			int n = q.poll();
			if (index == 1) {
				map.put(n, "Gold Medal");
			} else if (index == 2) {
				map.put(n, "Silver Medal");
				;
			} else if (index == 3) {
				map.put(n, "Bronze Medal");
			} else {
				map.put(n, String.valueOf(index));
			}
			index++;
		}

		String[] result = new String[nums.length];
		index = 0;
		for (int i : map.keySet()) {
			result[index++] = map.get(i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {10,3,8,9,4};
		System.out.println(findRelativeRanks(nums));

	}

}
