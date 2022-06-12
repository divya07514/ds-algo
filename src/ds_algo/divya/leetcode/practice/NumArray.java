package ds_algo.divya.leetcode.practice;

/**
 * Range Sum Query - Mutable Fenwick tree based implementation.
 * 
 * @author abc
 *
 */
public class NumArray {
	int[] ftree;
	int[] nums;

	public NumArray(int[] nums) {
		ftree = new int[nums.length + 1];
		this.nums = nums;
		for (int i = 1; i <= nums.length; i++) {
			updateSum(i, nums[i - 1]);
		}
	}

	public void update(int i, int val) {
		int diff = val - nums[i];
		nums[i]=val;
		updateSum(i+1, diff);
	}

	public void updateSum(int i, int val) {
		while (i < ftree.length) {
			ftree[i] = ftree[i] + val;
			i = i + (i & -i);
		}
	}

	public int sumRange(int i, int j) {
		return sum(j) - sum(i - 1);
	}


	public int sum(int index) {
		int sum = 0;
		index++;
		while (index > 0) {
			sum = sum + ftree[index];
			index = index - (index & -index);
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5 };
		NumArray array = new NumArray(nums);
		System.out.println(array.sumRange(0, 2));
		array.update(1, 2);
		System.out.println(array.sumRange(0, 2));

	}
}
