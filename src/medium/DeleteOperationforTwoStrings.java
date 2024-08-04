package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Variation of LCS
 * @author divya.thakur
 *
 */
public class DeleteOperationforTwoStrings {

	public int minDistance(String one, String two) {
		if (one.equals(two)) {
			return 0;
		}
		if (one.length() == 0) {
			return two.length();
		}
		if (two.length() == 0) {
			return one.length();
		}

		Map<String, Integer> map = new HashMap();
		int m = one.length();
		int n = two.length();
		int result = lcs(m, one, n, two, map);
		int a = one.length() - result;
		int b = two.length() - result;

		return a + b;
	}

	private int lcs(int m, String one, int n, String two, Map<String, Integer> map) {
		if (m == 0 || n == 0) {
			return 0;
		}
		String key = m + ", " + n;
		if (map.containsKey(key)) {
			return map.get(key);
		}
		if (one.charAt(m - 1) == two.charAt(n - 1)) {
			int ans = 1 + lcs(m - 1, one, n - 1, two, map);
			map.put(key, ans);
		} else {
			int left = lcs(m - 1, one, n, two, map);
			int right = lcs(m, one, n - 1, two, map);
			map.put(key, Math.max(left, right));
		}

		return map.get(key);
	}

}
