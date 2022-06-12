package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTraversalOfBinaryTree {

	public static List<List<Integer>> verticalTraversal(TreeNode root) {
		if (root == null) {
			return null;
		}
		Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int hd = 0;
		getDistances(root, map, hd);
		for (int i : map.keySet()) {
			List<Integer> temp = map.get(i);
			Collections.sort(temp);
			result.add(temp);
		}
		return result;
	}

	private static void getDistances(TreeNode root, Map<Integer, List<Integer>> map, int hd) {
		if (root == null) {
			return;
		}
		List<Integer> list = map.get(hd);
		if (list == null) {
			list = new ArrayList<Integer>();
			list.add(root.val);
		} else {
			list.add(root.val);
		}
		map.put(hd, list);
		getDistances(root.left, map, hd - 1);
		getDistances(root.right, map, hd + 1);
	}

	public static List<List<Integer>> verticalTraversal_leetcode(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		Map<Integer, List<Point>> map = new TreeMap<>();
		List<List<Integer>> result = new ArrayList<>();
		int hd = 0;
		traversal(root, map, hd, 0, 0);
		Comparator<Point> c = (a, b) -> {
			if (a.x == b.x && a.y != b.y) {
				return b.y - a.y;
			}
			if (b.x == a.x && b.y == a.y) {
				return a.val - b.val;
			}
			return a.x - b.x;
		};
		for (int i : map.keySet()) {
			List<Point> value = map.get(i);
			Collections.sort(value, c);
			List<Integer> temp = new ArrayList<>();
			for (Point p : value) {
				temp.add(p.val);
			}
			result.add(temp);
		}
		return result;
	}

	public static void traversal(TreeNode root, Map<Integer, List<Point>> map, int hd, int x, int y) {
		if (root == null) {
			return;
		}
		if (!map.containsKey(hd)) {
			List<Point> temp = new ArrayList<>();
			Point p = new Point(x, y, root.val);
			temp.add(p);
			map.put(hd, temp);
		} else {
			map.get(hd).add(new Point(x, y, root.val));
		}
		traversal(root.left, map, hd - 1, x - 1, y - 1);
		traversal(root.right, map, hd + 1, x + 1, y - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);

		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println(verticalTraversal(root));
		System.out.println(verticalTraversal_leetcode(root));
	}

}

class Point {
	int x;
	int y;
	int val;

	public Point(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}

	public String toString() {
		return "(" + x + ", " + y + ", " + val + ")";
	}
}
