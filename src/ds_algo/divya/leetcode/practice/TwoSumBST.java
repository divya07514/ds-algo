package ds_algo.divya.leetcode.practice;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBST {
	
	boolean result;

	public boolean twoSumBSTs(TreeNode one, TreeNode two, int target) {
		if (one == null || two == null) {
			return false;
		}
		Set<Integer> set = new HashSet<>();
		fillSet(set, two);
		result = false;
		check(set, one, target);
		return result;
	}

	public void check(Set<Integer> set, TreeNode one, int target) {
		if (one != null) {
			if (set.contains(target - one.val)) {
				result = true;
			}
			check(set, one.left, target);
			check(set, one.right, target);
		}
	}

	public void fillSet(Set<Integer> set, TreeNode two) {
		if (two != null) {
			set.add(two.val);
			fillSet(set, two.left);
			fillSet(set, two.right);
		}
	}
}
