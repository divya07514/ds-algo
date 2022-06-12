package ds_algo.divya.leetcode.practice;

public class CanPlaceFlowers {
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int len = flowerbed.length;

		for (int i = 0; i < len; i++) {
			if (n == 0) {
				return true;
			}
			if (flowerbed[i] == 1) {
				continue;
			}
			if (i == 0 && flowerbed[i] != 1 && len == 1) {
				flowerbed[i]=1;
				n--;
			}
			if (i == 0 && i + 1 < len && flowerbed[i + 1] != 1) {
				flowerbed[i]=1;
				n--;
			}
			if (i - 1 >= 0 && i + 1 < len && flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1) {
				flowerbed[i]=1;
				n--;
			}
			if (i == len - 1 && i - 1 >= 0 && flowerbed[i - 1] != 1) {
				flowerbed[i]=1;
				n--;
			}
		}
		if (n == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 1,0,0,0,0,1 };
		int n = 2;

		System.out.println(canPlaceFlowers(nums, n));

	}

}
