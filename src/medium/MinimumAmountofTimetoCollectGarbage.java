package medium;

import java.util.HashMap;
import java.util.Map;

// 33 mins
public class MinimumAmountofTimetoCollectGarbage {

	Map<Character, Integer> pos;
	Map<Character, Integer> map;

	public int garbageCollection(String[] garbage, int[] travel) {
		if (garbage == null) {
			return 0;
		}
		map = new HashMap();
		for (String s : garbage) {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (!map.containsKey(c)) {
					map.put(c, 1);
				} else {
					map.put(c, map.get(c) + 1);
				}
			}
		}
		pos = new HashMap();
		getPos(garbage, 'P');
		getPos(garbage, 'G');
		getPos(garbage, 'M');

		int mTime = time('M', travel);
		int pTime = time('P', travel);
		int gTime = time('G', travel);

		return mTime + pTime + gTime;
	}

	private int time(char c, int[] travel) {
		int travelTime = 0;
		if (pos.containsKey(c) && map.containsKey(c)) {
			int index = pos.get(c);
			for (int i = 0; i < index; i++) {
				travelTime = travelTime + travel[i];
			}
			travelTime = travelTime + map.get(c);
		}
		return travelTime;
	}

	private void getPos(String[] garbage, char c) {
		int max = -1;
		for (int j = 0; j < garbage.length; j++) {
			for (int i = 0; i < garbage[j].length(); i++) {
				char ch = garbage[j].charAt(i);
				if (ch == c) {
					max = Math.max(max, j);
					break;
				}
			}
		}
		if (max != -1) {
			pos.put(c, max);
		}
	}
}
