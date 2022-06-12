package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

	private Integer capacity;
	private LinkedList<Integer> linkedList;
	private Map<Integer, Integer> map;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.linkedList = new LinkedList<Integer>();
		this.map = new HashMap<Integer, Integer>();
	}

	public int get(Integer key) {
		if (map.containsKey(key)) {
			linkedList.remove(key);
			linkedList.addFirst(key);
			return map.get(key);
		} else {
			return -1;
		}
	}

	public void put(Integer key, Integer value) {
		if (map.containsKey(key)) {
			map.put(key, value);
			linkedList.remove(key);
			linkedList.addFirst(key);
		} else {
			if (linkedList.size() == capacity) {
				int mapKey = linkedList.removeLast();
				linkedList.addFirst(key);
				map.put(key, value);
				map.remove(mapKey);
			} else {
				linkedList.addFirst(key);
				map.put(key, value);
			}
		}
	}

	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1);
		lRUCache.put(2, 2);
		System.out.println(lRUCache.get(1));
		lRUCache.put(3, 3);
		System.out.println(lRUCache.get(2));
		lRUCache.put(4, 4);
		System.out.println(lRUCache.get(1));
		System.out.println(lRUCache.get(3));
		System.out.println(lRUCache.get(4));

	}

}
