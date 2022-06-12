package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignHitCounter {
	
	int[] counter;
	Map<Integer, Integer> map;

	/** Initialize your data structure here. */
	public DesignHitCounter() {
		this.counter = new int[] { 0, 0 };
		this.map = new HashMap<>();
	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {
		if (!map.containsKey(timestamp)) {
			map.put(timestamp, 1);
		} else {
			map.put(timestamp, map.get(timestamp) + 1);
		}
		counter[0] = timestamp;
		counter[1] = counter[1] + 1;
	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {

		int result = 0;
		if (timestamp - 300 <= 0) {
			result = counter[1];
			counter[0] = timestamp;
		} else {
			int diff = timestamp - 300;
			int sum = 0;
			List<Integer> list = new ArrayList<>();
			for (int key : map.keySet()) {
				if (key <= diff) {
					sum = sum + map.get(key);
					list.add(key);
				}
			}
			for (int i : list) {
				map.remove(i);
			}
			result = counter[1] - sum;
			counter[0] = timestamp;
			counter[1] = result;
		}
		return result;
	}
}
