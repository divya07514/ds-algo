package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KillProcess {

	public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

		Map<Integer, List<Integer>> map = new HashMap<>();

		int index = 0;
		for (int i : ppid) {
			if (!map.containsKey(i)) {
				List<Integer> list = new ArrayList<>();
				list.add(pid.get(index++));
				map.put(i, list);
			} else {
				map.get(i).add(pid.get(index++));
			}
		}

		List<Integer> result = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(kill);
		while (!q.isEmpty()) {
			int temp = q.poll();
			result.add(temp);
			if (map.containsKey(temp)) {
				List<Integer> list = map.get(temp);
				for (int i : list) {
					q.add(i);
				}
			}
		}
		return result;
	}

}
