package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganiseStrings {

	public static String reorganizeString(String s) {
		if(s==null || s.length()==0) {
			return "";
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		PriorityQueue<Character> heap = new PriorityQueue<Character>((a,b)->map.get(b)-map.get(a));
		heap.addAll(map.keySet());
		StringBuilder sb = new StringBuilder();
		while (heap.size() > 1) {
			char one = heap.remove();
			char two = heap.remove();
			sb.append(one);
			sb.append(two);
			map.put(one, map.get(one) - 1);
			map.put(two, map.get(two) - 1);
			if (map.get(one) > 0) {
				heap.add(one);
			}
			if (map.get(two) > 0) {
				heap.add(two);
			}
		}
		if (heap.size() == 1) {
			if (map.get(heap.peek()) > 1) {
				return "";
			} else {
				sb.append(heap.remove());
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "aab";
		System.out.println(reorganizeString(s));
	}

}
