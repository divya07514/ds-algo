package easy;

public class ClimbingStairs {

	public static int climbStairs(int n) {

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		}

		int[] steps = new int[n + 1];
		steps[0] = 0;
		steps[1] = 1;
		steps[2] = 2;

		int index = 3;
		while (index <= n) {
			steps[index] = steps[index - 1] + steps[index - 2];
			index ++;
		}

		return steps[steps.length - 1];
	}

	public static void main(String[] args) {
		int n = 6;
		System.out.println(climbStairs(n));

	}

}
