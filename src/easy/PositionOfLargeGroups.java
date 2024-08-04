package easy;

import java.util.ArrayList;
import java.util.List;

public class PositionOfLargeGroups {

	public List<List<Integer>> largeGroupPositions(String s) {
		if (s == null || s == "") {
			return new ArrayList();
		}
		List<List<Integer>> result = new ArrayList();
		int i = 0;
		int j = 1;
		while (j < s.length()) {
			if (s.charAt(i) == s.charAt(j)) {
				j++;
			} else {
				int diff = j - i;
				if (diff >= 3) {
					List<Integer> list = new ArrayList();
					list.add(i);
					list.add(j - 1);
					result.add(list);
				}
				i = j;
				j++;
			}
		}
		if (j >= s.length() && j - i >= 3) {
			List<Integer> list = new ArrayList();
			list.add(i);
			list.add(j - 1);
			result.add(list);
		}
		return result;
	}

}
