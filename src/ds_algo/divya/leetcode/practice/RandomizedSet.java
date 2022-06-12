package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	
	Map<Integer, Integer> map;
	List<Integer> list;
	Random random = new Random();

	/** Initialize your data structure here. */
	public RandomizedSet() {
		list = new ArrayList<>();
		map = new HashMap<>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}
		map.put(val, list.size());
		list.add(list.size(), val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}

		int last = list.get(list.size() - 1);
		int current = map.get(val);
		list.set(current, last);
		map.put(last, current);
		list.remove(list.size() - 1);
		map.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.get(random.nextInt(list.size()));
	}
}
