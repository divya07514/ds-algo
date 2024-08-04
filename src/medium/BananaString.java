package medium;

import java.util.HashMap;
import java.util.Map;

public class BananaString {

	// BANANA - B.1 A.3 N.2
	public static int solution(String s) {

		int A = 3;
		int B = 1;
		int N = 2;

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}

		int result = 0;

		if (map.containsKey('A') && map.containsKey('B') && map.containsKey('N')) {
			while (map.get('A') >= 3 && map.get('B') >= 1 && map.get('N') >= 2) {
				result++;
				map.put('A', map.get('A') - 3);
				map.put('B', map.get('B') - 1);
				map.put('N', map.get('N') - 2);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(solution("QABAAAWOBL"));

	}

}
