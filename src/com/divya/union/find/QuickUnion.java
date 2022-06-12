package com.divya.union.find;

/**
 * Worst case time complexity is O(N^2).
 * This happens when components are connected in a serial order.
 * 
 * @author abc
 *
 */
public class QuickUnion extends UnionFind {

	public QuickUnion(int n) {
		super(n);
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
		id[rootP] = rootQ;
		count--;
	}
}
