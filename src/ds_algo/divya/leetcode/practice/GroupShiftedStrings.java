package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

	public static List<List<String>> groupStrings(String[] strings) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (String str : strings) {
			String hashit = hashit(str);
			if (!map.containsKey(hashit)) {
				map.put(hashit, new ArrayList<String>());
			}
			map.get(hashit).add(str);
		}
		List<List<String>> fin = new ArrayList<List<String>>();
		for (List<String> lst : map.values()) {
			fin.add(lst);
		}
		return fin;
	}

	public static String hashit(String str) {
		int diff = str.charAt(0) - 'a';
		StringBuilder build = new StringBuilder();
		for (char c : str.toCharArray()) {
			int pos = c - 'a' - diff;
			if (pos < 0) {
				pos =pos+26;	
			}
			build.append('a' + pos);
		}
		return build.toString();
	}

	public static void main(String[] args) {
		String[] strings = { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		System.out.println(groupStrings(strings));

	}

}
