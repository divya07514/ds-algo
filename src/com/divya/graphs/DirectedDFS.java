package com.divya.graphs;

public class DirectedDFS {

	private DiGraph g;
	private boolean[] marked;

	public DirectedDFS(DiGraph g) {
		this.g = g;
		this.marked = new boolean[g.vertices()];
	}

	public boolean isMarked(int v) {
		return marked[v];
	}

	public void dfs(int s) {
		marked[s] = true;
		System.out.print(s + " ");
		for (int i : g.neighbours(s)) {
			if (!marked[i]) {
				dfs(i);
			}
		}
	}

}
