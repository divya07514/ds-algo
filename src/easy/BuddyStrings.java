package easy;

import java.util.List;
import java.util.Map;

public class BuddyStrings {

	public boolean buddyStrings(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}
		if (s.equals(goal)) {// if strings are same and has one char with count more that 2, then these can
								// be swapped
			int[] array = new int[26];
			for (char c : s.toCharArray()) {
				array[c - 'a'] = array[c - 'a'] + 1;
				if (array[c - 'a'] >= 2) {
					return true;
				}
			}
		}
		int left = -1;
		int right = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != goal.charAt(i)) {
				if (left == -1) {
					left = i;
				} else if (right == -1) {
					right = i;
				} else {
					return false;
				}
			}
		}
		if (right == -1) {// char mismatch is at only one position
			return false;
		}
		if (s.charAt(left) == goal.charAt(right) && s.charAt(right) == goal.charAt(left)) {
			return true;
		}
		return false;

	}

}
