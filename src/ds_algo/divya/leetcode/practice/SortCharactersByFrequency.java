package ds_algo.divya.leetcode.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharactersByFrequency {

	public static String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		Queue<CharCombo> q = new PriorityQueue<CharCombo>((a,b) -> b.count - a.count);
		for (Character ch : map.keySet()) {
			q.add(new CharCombo(ch, map.get(ch)));
		}

		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			CharCombo temp = q.poll();
			while (temp.count > 0) {
				sb.append(temp.c);
				temp.count--;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "cacaaaccaaa";
		System.out.println(frequencySort(s));
	}

}

class CharCombo {
	Character c;
	Integer count;
	public CharCombo(Character c, int count) {
		super();
		this.c = c;
		this.count = count;
	}
	@Override
	public String toString() {
		return "CharCombo [c=" + c + ", count=" + count + "]";
	}
}
