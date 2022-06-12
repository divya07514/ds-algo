package ds_algo.divya.leetcode.practice;

public class HammingDistance {

	public static int hammingDistance(int x, int y) {
		int count = 0;

		for (int i = 0; i < 32; i++) {
			if (((x >> i) & 1) != ((y >> i) & 1)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));

	}

}
