package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {

	Map<String, Integer> map;

	public int longestCommonSubsequence(String one, String two) {

		if (one.equals(two)) {
			return one.length();
		}
		map = new HashMap();
		return lcs(0, 0, one, two);
	}

	private int lcs(int i, int j, String one, String two) {
		if (i == one.length() || j == two.length()) {
			return 0;
		}
		String key = i + ", " + j;
		if (map.containsKey(key)) {
			return map.get(key);
		}
		int max = 0;
		if (one.charAt(i) == two.charAt(j)) {
			max = 1 + lcs(i + 1, j + 1, one, two);
		} else {
			max = Math.max(lcs(i + 1, j, one, two), lcs(i, j + 1, one, two));
		}
		map.put(key, max);
		return map.get(key);
	}

}
