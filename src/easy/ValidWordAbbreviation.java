package easy;

public class ValidWordAbbreviation {

	public boolean validWordAbbreviation(String word, String abbr) {
		int i = 0;// tracks word
		int j = 0; // tracks abbr

		while (i < word.length() && j < abbr.length()) {
			if (word.charAt(i) == abbr.charAt(j)) {
				i++;
				j++;
				continue;
			}
			if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
				return false;
			}
			int current = j;
			while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
				j++;
			}
			int len = Integer.parseInt(abbr.substring(current, j));
			i = i + len;
		}

		return i == word.length() && j == abbr.length();

	}
}
