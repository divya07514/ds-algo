package com.divya.union.find;

/**
 * O(log n) time complexity.
 * 
 * @author abc
 *
 */
public class WeightedQuickUnion extends UnionFind {

	private int[] size; // size of all connected components are this root.

	public WeightedQuickUnion(int n) {
		super(n);
		size = new int[n];
		for (int i = 0; i < n; i++) {
			size[i] = 1;
		}
	}

	@Override
	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	@Override
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) {
			return;
		}
		if (size[rootP] < size[rootQ]) {
			id[rootP] = rootQ;
			size[rootQ] = size[rootQ] + size[rootP];
		} else {
			id[rootQ] = rootP;
			size[rootP] = size[rootP] + size[rootQ];
		}
		count--;
	}

}
