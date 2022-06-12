package com.divya.union.find;

public abstract class UnionFind {

	int[] id;
	int count;

	public UnionFind(int n) {
		this.count = n;
		this.id = new int[n];
		for (int i = 0; i < n; i++) {
			this.id[i] = i;
		}
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	abstract public int find(int p);

	abstract public void union(int p, int q);

}
