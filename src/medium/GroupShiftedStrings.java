package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The idea is related to hashing. Strings with same hash value needs to be grouped together. Hence, the challenges reduces
 * to finding this hash value.
 * Take difference between chars and convert it into a string. All the similar strings will have the exact difference 
 * between their chars. Use this as a key in map to store shifted strings together.
 * @author divya.thakur
 *
 */
public class GroupShiftedStrings {

	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> result = new ArrayList();
		Map<String, List<String>> map = new HashMap();
		for (String s : strings) {
			String hash = getHash(s);
			if (!map.containsKey(hash)) {
				List<String> list = new ArrayList();
				list.add(s);
				map.put(hash, list);
			} else {
				map.get(hash).add(s);
			}
		}
		for (String s : map.keySet()) {
			result.add(map.get(s));
		}
		return result;
	}

	private String getHash(String s) {
		StringBuilder sb = new StringBuilder();
		char[] temp = s.toCharArray();
		for (int i = 1; i < temp.length; i++) {
			char c = (char) ((temp[i] - temp[i - 1] + 26) % 26 + 'a');
			sb.append(c);
		}
		return sb.toString();
	}

}
