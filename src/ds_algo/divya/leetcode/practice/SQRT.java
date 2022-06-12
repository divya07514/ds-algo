package ds_algo.divya.leetcode.practice;

public class SQRT {

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
		int x = 101;
		System.out.println(mySqrt(x));

	}

}
