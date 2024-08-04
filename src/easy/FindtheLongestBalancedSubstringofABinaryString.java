package easy;

public class FindtheLongestBalancedSubstringofABinaryString {

	public int findTheLongestBalancedSubstring(String s) {

		int zerocount = 0;
		int onecount = 0;
		int max = Integer.MIN_VALUE;
		int i = 0;

		while (i < s.length()) {
			while (i < s.length() && s.charAt(i) == '0') {
				i++;
				zerocount++;
			}

			while (i < s.length() && s.charAt(i) == '1') {
				i++;
				onecount++;
			}
			max = Math.max(max, 2 * Math.min(onecount, zerocount));
			onecount = 0;
			zerocount = 0;

		}

		return max;

	}

}
