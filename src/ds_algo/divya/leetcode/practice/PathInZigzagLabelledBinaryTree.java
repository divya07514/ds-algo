package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
	
	public static List<Integer> pathInZigZagTree(int label) {

		List<Integer> result = new ArrayList<>();

		int count = 0;
		int level = 0;

		while (label > count) {
			count = count + (int) Math.pow(2, level);
			level++;
		}
		level--;

		while (level >= 0) {
			result.add(0, label);

			int min = (int) Math.pow(2, level);
			int max = (int) Math.pow(2, level + 1) - 1;

			int parent = min + max - label;
			label = parent / 2;
			level--;
		}

		return result;
	}

	public static void main(String[] args) {
		int n= 14;
		System.out.println(pathInZigZagTree(n));

	}

}
