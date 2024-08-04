package easy;

public class LongestPressedName {

	public static boolean isLongPressedName(String n, String t) {

		int i = 0;
		int j = 0;

		int ncount = 0;
		int tcount = 0;

		while (i < n.length() && j < t.length()) {

			char nchar = n.charAt(i);
			char tchar = t.charAt(j);

			if (nchar != tchar) {
				return false;
			} else {
				while (j + 1 < t.length() && t.charAt(j + 1) == nchar) {
					j++;
					tcount++;
				}
			}
			while (i + 1 < n.length() && n.charAt(i + 1) == nchar) {
				i++;
				ncount++;
			}

			if (tcount < ncount) {
				return false;
			}

			i++;
			j++;
			ncount = 0;
			tcount = 0;
		}

		if (n.charAt(n.length() - 1) != t.charAt(t.length() - 1)) {
			return false;
		}
		if ((i >= n.length() && j < t.length()) || i < n.length() && j >= t.length()) {
			return false;
		}

		return true;

	}

	public static void main(String[] args) {
		String name = "alex";
		String typed = "aaleex";
		System.out.println(isLongPressedName(name, typed));

	}

}
