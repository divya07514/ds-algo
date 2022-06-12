package ds_algo.divya.leetcode.practice;

public class SumOfSquareNumbers {

	public static boolean judgeSquareSum(int c) {
		if(c==1||c==2) {
			return true;
		}
		int sqrt = mySqrt(c);
		int left = 0;
		int right = sqrt;
		while (left <= right) {
			int leftPow = left*left;
			int rightPow = right*right;
			int sum = leftPow + rightPow;
			if (sum == c) {
				return true;
			} else if (sum > c) {
				right--;
			} else {
				left++;
			}
		}
		return false;
	}

	public static int mySqrt(int x) {
		if (x == 1 || x == 0) {
			return x;
		}
		int lo = 0;
		int hi = x / 2;
		int ans = 0;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (Math.pow(mid, 2) == x) {
				return mid;
			}
			if (Math.pow(mid, 2) < x) {
				lo = mid + 1;
				ans = mid;
			} else {
				hi = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(judgeSquareSum(1000));

	}

}
