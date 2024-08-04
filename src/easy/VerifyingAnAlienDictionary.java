package easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerifyingAnAlienDictionary {

	public static boolean isAlienSorted(String[] words, String order) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < order.length(); i++) {
			map.put(order.charAt(i), i);
		}
		Comparator<String> c = new Comparator<String>() {
			public int compare(String a, String b) {
				int i = 0;
				int j = 0;
				while (i < a.length() && j < b.length()) {
					char ac = a.charAt(i);
					char bc = b.charAt(j);
					if (ac == bc) {
						i++;
						j++;
						continue;
					} else if (map.get(ac) < map.get(bc)) {
						return -1;
					} else if (map.get(ac) > map.get(bc)) {
						return 1;
					}
				}
				if (i >= a.length() && j < b.length()) {
					return -1;
				}
				return 0;
			}
		};
		List<String> list = new ArrayList<>();
		for (String s : words) {
			list.add(s);
		}
		list.sort(c);
		int index = 0;
		while (index < list.size()) {
			if (!list.get(index).equals(words[index])) {
				return false;
			}
			index++;
		}
		return true;
	}

	public static boolean isAlienSorted_better(String[] words, String order) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < order.length(); i++) {
			map.put(order.charAt(i), i);
		}
		for (int i = 0; i < words.length - 1; i++) {
			String a = words[i];
			String b = words[i + 1];
			int ans = compare(a, b, map);
			if (ans == 1) {
				return false;
			}
		}
		return true;
	}

	public static int compare(String a, String b, Map<Character, Integer> map) {
		int i = 0;
		int j = 0;
		while (i < a.length() && j < b.length()) {
			char ac = a.charAt(i);
			char bc = b.charAt(j);
			if (ac == bc) {
				i++;
				j++;
				continue;
			} else if (map.get(ac) < map.get(bc)) {
				return -1;
			} else if (map.get(ac) > map.get(bc)) {
				return 1;
			}
		}
		if (i < a.length() && j >= b.length()) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		String[] words = { "hello", "leetcode" };
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		System.out.println(isAlienSorted(words, order));
		System.out.println(isAlienSorted_better(words, order));

	}

}
