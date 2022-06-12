package com.divya.fenwick.tree;

import ds_algo.divya.leetcode.practice.ArrayUtil;

/**
 * Fenwick Tree
 * @author abc
 *
 */
public class FenwickTree {

	private int[] fenwickTree;

	public FenwickTree(int[] nums) {
		this.fenwickTree = new int[nums.length + 1];
		buildTree(nums);
	}

	/**
	 * Sum of all integers in the range [0:index]
	 * 
	 * @param index
	 * @return
	 */
	public int sum(int index) {
		int sum = 0;
		while (index > 0) {
			sum = sum + this.fenwickTree[index];
			index = parent(index);
		}
		return sum;
	}

	/**
	 * Sum between a given range of indices.
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public int rangeSum(int start, int end) {
		return sum(end) - sum(start - 1);
	}

	/**
	 * Update an existing item in tree with index and given value. O(NlogN) TC
	 * 
	 * @param i
	 * @param j
	 */
	public void update(int index, int num) {
		while (index < this.fenwickTree.length) {
			this.fenwickTree[index] = this.fenwickTree[index] + num;
			index = next(index);
		}  

	}

	/**
	 * Next higher index on the right
	 * 
	 * @param index
	 * @return
	 */
	private int next(int index) {
		return index + (index & -index);
	}

	/**
	 * Index of parent on the left;
	 * 
	 * @param index
	 * @return
	 */
	public int parent(int index) {
		return index - (index & -index);
	}

	/**
	 * Build Fenwick Tree from given array O(NlogN) TC
	 * 
	 * @param nums
	 */
	private void buildTree(int[] nums) {
		for (int i = 1; i <= nums.length; i++) {
			update(i, nums[i - 1]);
		}
	}

	public static void main(String[] args) {
		int[] nums = {3,2,-1,6,5,4,-3,3,7,2,3};
		FenwickTree ft = new FenwickTree(nums);
		System.out.println(ft.sum(9));
		ArrayUtil.printArray(ft.fenwickTree);
		
	}

}
