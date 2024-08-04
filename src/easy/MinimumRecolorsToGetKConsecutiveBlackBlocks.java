package easy;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

	public int minimumRecolors(String blocks, int k) {

		int left = 0;
		int right = 0;

		int W = 0;
		int B = 0;
		int min = Integer.MAX_VALUE;
		int i = 0;
		while (right < blocks.length()) {
			char c = blocks.charAt(i++);
			if (c == 'W') {
				W++;
			}
			if (c == 'B') {
				B++;
			}
			if (right - left + 1 == k) {
				min = Math.min(min, W);
				if (blocks.charAt(left) == 'W') {
					W--;
				} else {
					B--;
				}
				left++;
			}
			right++;
		}

		return min;

	}

}
