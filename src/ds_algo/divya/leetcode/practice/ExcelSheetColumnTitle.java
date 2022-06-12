package ds_algo.divya.leetcode.practice;

public class ExcelSheetColumnTitle {

	public static String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int rem = n % 26;
			if (rem == 0) {
				sb.append("Z");
				n = (n / 26) - 1;
			} else {
				sb.append((char) ((rem - 1) + 'A'));
				n = n / 26;
			}
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		int n = 703;
		System.out.println(convertToTitle(n));
		System.out.println('B'-'A');

	}

}
