package easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	public boolean wordPattern(String p, String str) {
		Map<Character, String> chars = new HashMap();
		Map<String, Character> strings = new HashMap();
		String[] temp = str.split(" ");
		if (p.length() != temp.length) {
			return false;
		}
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			String s = temp[i];
			if (!chars.containsKey(c)) {
				if (strings.containsKey(s)) {
					return false;
				} else {
					chars.put(c, s);
					strings.put(s, c);
				}
			} else {
				String st = chars.get(c);
				if (!s.equals(st)) {
					return false;
				}
			}
		}
		return true;
	}
}
