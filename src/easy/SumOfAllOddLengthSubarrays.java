package easy;

public class SumOfAllOddLengthSubarrays {

	public static int sumOddLengthSubarrays(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			total = total + nums[i];
		}
		int[] pre = new int[nums.length];
		pre[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			pre[i] = pre[i - 1] + nums[i];
		}

		int odd = 3;
		while (odd <= nums.length) {
			total = total + getSum(pre, odd);
			odd = odd + 2;
		}

		return total;

	}

	private static int getSum(int[] pre, int index) {
		int i = index - 1;
		int sum = 0;
		for (; i < pre.length; i++) {
			if (i - index < 0) {
				sum = pre[i];
				continue;
			}
			sum = sum + pre[i] - pre[i - index];
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] arr = {1,4,2,5,3};
		System.out.println(sumOddLengthSubarrays(arr));
	}

}