package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * I was on the right track thinking that this needs a graph representation. Prepare a graph of nodes and their neighbors.
 * Neighbors can be calculated based on the blast distance. Here, I could not figure out the way to calculate the distance.
 * 
 * distance*distance = (ix-jx)*(ix-jx)  + (iy-jy)*(iy-jy)
 * 
 * Do dfs from every node and keep updating the max result.
 * 
 * @author divya.thakur
 *
 */
public class DetonateMaximumBombs {
	public int maximumDetonation(int[][] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		Map<Integer, List<Integer>> map = new HashMap();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				int ix = nums[i][0];
				int iy = nums[i][1];
				int ir = nums[i][2];
				int jx = nums[j][0];
				int jy = nums[j][1];

				long dist = (long) Math.pow(ir, 2);
				long xdist = (long) Math.pow(Math.abs(jx - ix), 2);
				long ydist = (long) Math.pow(Math.abs(jy - iy), 2);

				if (dist >= xdist + ydist) {
					if (!map.containsKey(i)) {
						List<Integer> list = new ArrayList();
						list.add(j);
						map.put(i, list);
					} else {
						map.get(i).add(j);
					}
				}
			}
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			Set<Integer> marked = new HashSet();
			int[] temp = new int[1];
			dfs(i, map, marked, temp);
			result = Math.max(result, temp[0]);
		}

		return result;
	}

	private void dfs(int s, Map<Integer, List<Integer>> map, Set<Integer> set, int[] temp) {
		set.add(s);
		temp[0] = temp[0] + 1;
		if (map.containsKey(s)) {
			for (int i : map.get(s)) {
				if (!set.contains(i)) {
					dfs(i, map, set, temp);
				}
			}
		}
	}
}
