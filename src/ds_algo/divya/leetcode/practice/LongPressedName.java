package ds_algo.divya.leetcode.practice;

import java.util.HashSet;
import java.util.Set;

public class LongPressedName {

	/**
	 * Self implemented solution.
	 * @param name
	 * @param typed
	 * @return
	 */
	public static boolean isLongPressedName(String name, String typed) {
		if (name == null || typed == null) {
			return false;
		}
		if (name.equals(typed)) {
			return true;
		}

		Set<Character> nameSet = getSet(name);
		Set<Character> typedSet = getSet(typed);
		for (Character ch : nameSet) {
			if (!typedSet.contains(ch)) {
				return false;
			}
		}

		String nameCount = getCount(name);
		String typedCount = getCount(typed);
		if (nameCount.length() != typedCount.length()) {
			return false;
		}
		for (int i = 0; i < nameCount.length(); i++) {
			if (nameCount.charAt(i) > typedCount.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private static Set<Character> getSet(String name) {
		Set<Character> nameSet = new HashSet<Character>();
		for (int i = 0; i < name.length(); i++) {
			nameSet.add(name.charAt(i));
		}
		return nameSet;
	}

	private static String getCount(String name) {
		StringBuilder sb = new StringBuilder();
		int left = 0;
		int right = 0;
		int count = 0;
		while (right < name.length()) {
			if (name.charAt(left) == name.charAt(right)) {
				count++;
				right++;
				continue;
			} else {
				sb.append(count);
				count = 0;
				left = right;
			}
		}
		sb.append(right - left);
		return sb.toString();
	}

	/**
	 * Leetcode solution
	 * @param name
	 * @param typed
	 * @return
	 */
	public static boolean isLongPressedName_leetcode(String name, String typed) {
		if (typed.length() < name.length()) {
			return false;
		}
		int i = 0;
		int j = 0;
		while (i < name.length() && j < typed.length()) {
			if (name.charAt(i) == typed.charAt(j)) {
				i++;
				j++;
			} else if (i > 0 && name.charAt(i - 1) == typed.charAt(j)) {
				j++;
			} else {
				return false;
			}
		}
		while (j < typed.length()) {
			if (name.charAt(i - 1) != typed.charAt(j)) {
				return false;
			}
			j++;
		}
		return i < name.length() ? false : true;
	}

	public static void main(String[] args) {
		String name = "laidez";
		String typed = "laidezzzz";
		System.out.println(isLongPressedName(name, typed));
	}

}
