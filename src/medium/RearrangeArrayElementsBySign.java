package medium;

public class RearrangeArrayElementsBySign {

	public static int[] rearrangeArray(int[] nums) {

		if (nums == null || nums.length == 0) {
			return new int[0];
		}

		int n = nums.length;

		int[] odd = new int[n / 2];
		int[] even = new int[n / 2];

		int i = 0;
		int j = 0;

		for (int num : nums) {
			if (num < 0) {
				odd[i++] = num;
			} else {
				even[j++] = num;
			}
		}

		i = 0;
		j = 0;

		for (int k = 0; k < nums.length; k = k + 2) {
			nums[k] = even[j++];
		}
		for (int k = 1; k < nums.length; k = k + 2) {
			nums[k] = odd[i++];
		}

		return nums;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1, -2, -5, 2, -4 };
		System.out.println(rearrangeArray(nums));

	}

}
