package ds_algo.divya.leetcode.practice;

public class ValidWordSquare {

	public static boolean validWordSquare(String[] words) {
		int n = words.length;
		for (int i = 0; i < words.length; i++) {
			String rowStr = words[i];
			for (int j = 0; j < rowStr.length(); j++) {
				String colStr = words[j];
				int current = colStr.length();
				char col = colStr.charAt(i);
				char row = rowStr.charAt(j);
				if (j >= n || current <= i || row != col) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] words = { "abcd", "bnrt", "crm", "dt" };
		System.out.println(validWordSquare(words));
	}

}
