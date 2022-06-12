package ds_algo.divya.leetcode.practice;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

	public static int numPairsDivisibleBy60(int[] time) {
		int[] rem = new int[60];
		int result = 0;
		for (int i : time) {
			if (i % 60 == 0) {
				result = result + rem[0];
			} else {
				result = result + rem[60 - i % 60];
			}
			rem[i % 60]++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] time = { 30, 20, 150, 100, 40 };
		System.out.println(numPairsDivisibleBy60(time));
	}

}
