package easy;

import java.util.LinkedList;

public class Msft_2 {

	public static int solution(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		LinkedList<Integer> q = new LinkedList<>();
		for (int i : nums) {
			q.add(i);
		}
		int current = 0;
		int result = 0;
		long modulo = 1000000000;

		while (!q.isEmpty()) {
			int temp = q.poll();
			current = current + 1;
			temp = temp - 1;
			if (temp == 0) {
				result = (int) ((result + current) % modulo);
			} else
				q.add(temp);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] array = { 10000, 1000, 1233, 12233, 11223 };
		System.out.println(solution(array));

	}

}
