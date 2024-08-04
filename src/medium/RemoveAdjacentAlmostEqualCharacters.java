package medium;

public class RemoveAdjacentAlmostEqualCharacters {
	public int removeAlmostEqualCharacters(String word) {
		int n = word.length();
		if (n == 0 || n == 1) {
			return 0;
		}

		int res = 0;

		for (int i = 1; i < n; i++) {
			char right = word.charAt(i);
			char left = word.charAt(i - 1);
			if (adj(right, left)) {
				res++;
				i++;
			}
		}

		return res;
	}

	public boolean adj(char a, char b) {
		int diff = (a - 'a') - (b - 'a');
		return (a == b) || Math.abs(diff) == 1;
	}
}
