package medium;

// Take one position and expand to left and right to check for palindrome.
// For odd length consider left=right=i and for
// even take left=i and right=i+1;
public class PalindromicSubstrings {
	public int countSubstrings(String s) {
		int n = s.length();
		if (n == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			count = count + palin(s, i, i);
		}
		for (int i = 0; i < n - 1; i++) {
			count = count + palin(s, i, i + 1);
		}
		return count;
	}

	private int palin(String s, int left, int right) {
		int ans = 0;

		while (left >= 0 && right < s.length()) {
			if (s.charAt(left) != s.charAt(right)) {
				break;
			}
			left--;
			right++;
			ans++;
		}
		return ans;
	}
}
