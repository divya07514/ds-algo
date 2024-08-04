package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Wordbreak {

	public static boolean wordBreak(String s, List<String> wordDict) {
		if (s.length() == 0) {
			return false;
		}
		Set<String> set = new HashSet();
		for (String str : wordDict) {
			set.add(str);
		}
		Map<String, Boolean> map = new HashMap();

		boolean result = breakString(s, map, set);
		System.out.println(map);
		return result;
	}

	private static boolean breakString(String s, Map<String, Boolean> map, Set<String> set) {
		if (s.length() == 0) {
			return true;
		}
		if (map.containsKey(s)) {
			return map.get(s);
		}
		for (int i = 1; i <= s.length(); i++) {
			String temp = s.substring(0, i);
			if (set.contains(temp)) {
				map.put(temp, true);
				String sub = s.substring(i);
				System.out.println(temp + ", " + sub);
				if (breakString(sub, map, set)) {
					return true;
				}
			}
		}
		map.put(s, false);
		return map.get(s);
	}

	public static void main(String[] args) {
		String s = "catsandog";
		List<String> list = new ArrayList();
		list.add("cats");
		list.add("dog");
		list.add("sand");
		list.add("and");
		list.add("cat");
		System.out.println(wordBreak(s, list));

	}

}
