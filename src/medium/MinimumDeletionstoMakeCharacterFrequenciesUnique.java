package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Count frequency of each char. Keep decrementing till it becomes unique.
 * @author divya.thakur
 *
 */
public class MinimumDeletionstoMakeCharacterFrequenciesUnique {

	public int minDeletions(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return 1;
		}
		Map<Character, Integer> map = new HashMap();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}

		Set<Integer> set = new HashSet();
		int result = 0;
		System.out.println(map);
		for (char c : map.keySet()) {
			int val = map.get(c);
			if (!set.contains(val)) {
				set.add(val);
			} else {
				int count = 0;
				while (set.contains(val)) {
					count++;
					val--;
					if (val == 0) {
						break;
					}
				}
				set.add(val);
				result = result + count;
			}
		}
		return result;
	}

}
