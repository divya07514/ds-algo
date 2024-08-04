package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {

	public static List<String> commonChars(String[] words) {
		if (words == null || words.length == 0) {
			return new ArrayList<>();
		}
		String one = words[0];
		Map<Character, Integer> a = getMap(words[0]);

		for (int i = 1; i < words.length; i++) {
			a = compare(a, getMap(words[i]));
		}
		List<String> list = new ArrayList<>();
		for (char c : a.keySet()) {
			int val = a.get(c);
			while (val > 0) {
				list.add(c + "");
				val--;
			}
		}
		return list;
	}

	private static  Map<Character, Integer> compare(Map<Character, Integer> a, Map<Character, Integer> b) {
		Map<Character, Integer> result = new HashMap();
		for (char c : a.keySet()) {
			if (b.containsKey(c)) {
				result.put(c, Math.min(a.get(c), b.get(c)));
			}
		}
		return result;
	}

	private static Map<Character, Integer> getMap(String one) {
		Map<Character, Integer> map = new HashMap();
		for (int i = 0; i < one.length(); i++) {
			char c = one.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		return map;
	}

	public static void main(String[] args) {
		String[] words = {"bella","label","roller"};
		System.out.println(commonChars(words));

	}

}
