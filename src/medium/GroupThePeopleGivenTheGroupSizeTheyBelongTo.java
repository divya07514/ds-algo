package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {

	public static List<List<Integer>> groupThePeople(int[] gs) {

		if (gs == null || gs.length == 0) {
			return new ArrayList();
		}

		Map<Integer, List<Integer>> map = new HashMap();

		for (int i = 0; i < gs.length; i++) {
			int val = gs[i];
			if (!map.containsKey(val)) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(val, list);
			} else {
				map.get(val).add(i);
			}

		}

		List<List<Integer>> result = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for (int i : gs) {
			set.add(i);
		}

		for (int i : set) {
			if (map.get(i).size() > i) {
				int n = map.get(i).size();
				for (int j = 0; j < n; j = j + i) {
					result.add(map.get(i).subList(j, j + i));
				}
			} else {
				result.add(map.get(i));
			}

		}

		return result;

	}

	public static void main(String[] args) {
		int[] groupSizes = { 3, 3, 3, 3, 3, 1, 3 };
		System.out.println(groupThePeople(groupSizes));

	}

}
