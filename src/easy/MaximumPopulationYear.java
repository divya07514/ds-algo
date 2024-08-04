package easy;

public class MaximumPopulationYear {

	public int maximumPopulation(int[][] logs) {

		int[] nums = new int[2051];

		for (int[] i : logs) {
			nums[i[0]] = nums[i[0]] + 1;
			nums[i[1]] = nums[i[1]] - 1;
		}

		int result = 1950;
		int max = nums[1950];

		for (int i = 1951; i < nums.length; i++) {
			nums[i] = nums[i - 1] + nums[i];
			if (nums[i] > max) {
				result = i;
				max = nums[i];
			}
		}

		return result;

	}

}
