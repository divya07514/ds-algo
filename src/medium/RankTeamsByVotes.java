package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Just keep count of votes at each position for each char. Use custom sort to
 * sort the map entries first on count (reverse) and then on char
 * (alphabetically)
 * 
 * @author divya.thakur
 *
 */
public class RankTeamsByVotes {
	public String rankTeams(String[] votes) {
		if (votes.length == 0) {
			return "";
		}
		if (votes.length == 1) {
			return votes[0];
		}
		Map<Character, Pair> map = new HashMap();
		for (String s : votes) {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (!map.containsKey(c)) {
					map.put(c, new Pair(c));
				}
				Pair p = map.get(c);
				p.count[i]++;
			}
		}
		List<Pair> list = new ArrayList();
		for (char c : map.keySet()) {
			list.add(map.get(c));
		}
		Comparator<Pair> c = new Comparator<Pair>() {
			public int compare(Pair one, Pair two) {
				for (int i = 0; i < 26; i++) {
					if (one.count[i] == two.count[i]) {
						continue;
					}
					return Integer.compare(two.count[i], one.count[i]);
				}
				return Character.compare(one.c, two.c);
			}
		};
		Collections.sort(list, c);
		String result = "";

		for (Pair p : list) {
			result = result + p.c;
		}
		return result;
	}

	class Pair {
		char c;
		int[] count;

		public Pair(char c) {
			this.c = c;
			this.count = new int[26];
		}
	}
}
