package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCasePermutation {

	public static List<String> letterCasePermutation(String input) {
		if (input == null) {
			return null;
		}
		if (input.length() == 0) {
			return new ArrayList<String>();
		}
		int i = 0;
		List<String> result = new ArrayList<String>();
		char[] array = input.toCharArray();
		permute(i, array, input, result);
		return result;
	}

	private static void permute(int index, char[] array, String input, List<String> result) {
		result.add(new String(array));
		if (index > array.length - 1) {
			return;
		}
		for (int j = index; j < array.length; j++) {
			char ch = array[j];
			if (ch - 'A' >= 0 && ch - 'Z' <= 0) {
				array[j] = Character.toLowerCase(ch);
				permute(j + 1, array, input, result);
				array[j] = ch;
			}
			if (ch - 'a' >= 0 && ch - 'z' <= 0) {
				array[j] = Character.toUpperCase(ch);
				permute(j + 1, array, input, result);
				array[j] = ch;
			}
		}
	}

	public static void main(String[] args) {
		String input = "a1b2";
		System.out.println(letterCasePermutation(input));
	}

}
