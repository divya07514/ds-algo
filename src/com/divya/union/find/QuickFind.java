package com.divya.union.find;

/**
 * O(N^2) in worst case ( when all individual components connect to make a whole connected components.)
 * @author abc
 *
 */
public class QuickFind extends UnionFind {

	public QuickFind(int n) {
		super(n);
	}

	@Override
	public int find(int p) {
		return id[p];
	}

	@Override
	public void union(int p, int q) {
		int pid = find(p);
		int qid = find(q);
		if (pid == qid) {
			return;
		}
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) {
				id[i] = qid;
			}
		}
		count--;
	}
}
