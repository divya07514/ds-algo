package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ajay_test_2 {

	public static void main(String[] args) {
		String s = "mmmerme";
		System.out.println(ArrayChallenge(s));
	}

	public static String ArrayChallenge(String s) {

		Map<Character, List<Integer>> map = new HashMap();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				List<Integer> l = new ArrayList();
				l.add(i);
				map.put(c, l);
			} else {
				map.get(c).add(i);
			}
		}

		int max = 0;

		for (char c : map.keySet()) {
			List<Integer> l = map.get(c);
			int len = l.size();
			for (int i = 0; i < len; i++) {
				for (int j = i + 1; j < len; j++) {
					String sub = s.substring(l.get(i)+1, l.get(j));
					int res = unique(sub);
					max = Math.max(max, res);
				}
			}
		}

		return String.valueOf(max);
	}

	private static int unique(String s) {
		Set<Character> set = new HashSet();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			set.add(c);
		}

		return set.size();
	}

}
