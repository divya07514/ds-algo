package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BottomViewOfaBinaryTree {

	private static List<Integer> bottomView(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		Map<Integer, List<Point>> map = new TreeMap<>();
		List<Integer> result = new ArrayList<>();
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
			result.add(value.get(value.size() - 1).val);
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
		traversal(root.left, map, hd - 1, x + 1, y - 1);
		traversal(root.right, map, hd + 1, x + 1, y + 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);

		root.left = new TreeNode(8);
		root.right = new TreeNode(22);

		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(4);

		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);

		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(25);

		System.out.println(bottomView(root));

	}

}
