package ds_algo.divya.leetcode.practice;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {
	public static boolean isPathCrossing(String path) {
		Set<String> s = new HashSet<>();
		int x = 0, y = 0;
		s.add(x + "," + y);
		for (char c : path.toCharArray()) {
			if (c == 'N')
				y++;
			else if (c == 'S')
				y--;
			else if (c == 'E')
				x++;
			else
				x--;
			String point = x + "," + y;
			s.add(point);
		}
		return s.size() <= path.length();
	}

	public static void main(String[] args) {
		String path = "NESWW";
		System.out.println(isPathCrossing(path));

	}

}
