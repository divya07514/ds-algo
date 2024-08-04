package medium;

import java.util.HashMap;
import java.util.Map;

public class OptimalPartitionOfString {

	public static int partitionString(String s) {

		int count = 0;

		Map<Character, Integer> map = new HashMap();
		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				count++;
				map.clear();
				map.put(c, 1);
			}

		}

		return map.isEmpty() ? count : count + 1;

	}

	public static void main(String[] args) {
		String s = "abacaba";
		System.out.println(partitionString(s));

	}

}
