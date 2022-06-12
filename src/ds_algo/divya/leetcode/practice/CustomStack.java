package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class CustomStack {
	int max;
	List<Integer> list;

	public CustomStack(int maxSize) {
		this.max = maxSize;
		this.list = new ArrayList<>();
	}

	public void push(int x) {
		if (list.size() == max) {
			return;
		}
		list.add(x);

	}

	public int pop() {
		if (!list.isEmpty()) {
			return list.remove(list.size() - 1);
		}
		return -1;
	}

	public void increment(int k, int val) {
		// System.out.println(list);
		if (max <= k && !list.isEmpty()) {
			for (int i = 0; i < max && i < list.size(); i++) {
				list.set(i, list.get(i) + val);
			}
		} else if (!list.isEmpty()) {
			for (int i = 0; i < k && i < list.size(); i++) {
				list.set(i, list.get(i) + val);
			}
		}

	}

}
