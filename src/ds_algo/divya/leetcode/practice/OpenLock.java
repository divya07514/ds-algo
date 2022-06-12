package ds_algo.divya.leetcode.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class OpenLock {

	public static int openLock(String[] deadends, String target) {

		String start = "0000";
		if (target.equals(start)) {
			return 0;
		}

		Set<String> dead = new HashSet<String>(Arrays.asList(deadends));
		Set<String> marked = new HashSet<String>();

		if (dead.contains(start)) {
			return -1;
		}

		LinkedList<String> q = new LinkedList<>();
		q.add(start);

		int count = 0;

		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs > 0) {
				String temp = q.poll();
				for (int i = 0; i < temp.length(); i++) {
					char[] array = temp.toCharArray();
					int val = Character.getNumericValue(array[i]);
					int next = Math.floorMod(val + 1, 10);
					int prev = Math.floorMod(val - 1, 10);

					array[i] = (char) ('0' + next);
					String forward = new String(array);
					array[i] = (char) ('0' + prev);
					String backward = new String(array);

					if (forward.equals(target) || backward.equals(target)) {
						return count + 1;
					}

					if (!dead.contains(forward) && !marked.contains(forward)) {
						marked.add(forward);
						q.add(forward);
					}

					if (!dead.contains(backward) && !marked.contains(backward)) {
						marked.add(backward);
						q.add(backward);
					}
				}
				qs--;
			}
			count++;
		}

		return -1;
	}

	public static void main(String[] args) {
		String[] deadends = { "8887","8889","8878","8898","8788","8988","7888","9888" };
		String target = "8888";
		System.out.println(openLock(deadends, target));

	}

}
