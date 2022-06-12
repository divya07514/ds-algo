package ds_algo.divya.leetcode.practice;

import java.util.Comparator;

public class AddBinary {

	public static String addBinary(String a, String b) {
		if (a == null || a.length() == 0 || b == null || b.length() == 0) {
			return "";
		}
		String result = "";
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int one = 0;
			int two = 0;
			if (i >= 0) {
				one = Integer.parseInt(String.valueOf(a.charAt(i)));
			}
			if (j >= 0) {
				two = Integer.parseInt(String.valueOf(b.charAt(j)));
			}
			if (one + two + carry == 3) {
				carry = 1;
				result = 1 + result;
			} else if (one + two + carry == 2) {
				carry = 1;
				result = 0 + result;
			} else if (one + two + carry == 1) {
				carry = 0;
				result = 1 + result;
			} else if (one + two + carry == 0) {
				carry = 0;
				result = 0 + result;
			}
			i--;
			j--;
		}
		if (carry == 1) {
			result = 1 + result;
		}
		return result;
	}

	public static void main(String[] args) {
		String a = "1010";
		String b = "1011";
		System.out.println(addBinary(a, b));
		System.out.println(13%10);

		 int x =10;
       
        
		
	}

}
