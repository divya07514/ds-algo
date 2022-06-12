package com.divya.graphs;

public class TwoColor {

	private boolean[] marked;
	private boolean[] color;
	private Graph g;
	private boolean isBipartite;

	public TwoColor(Graph g) {
		this.g = g;
		this.marked = new boolean[g.vertices()];
		this.color = new boolean[g.vertices()];
		this.isBipartite = true;
	}

	public void checkTwoColor() {
		for (int s = 0; s < g.vertices(); s++) {
			if (!marked[s]) {
				dfs(s);
			}
		}
	}

	private void dfs(int s) {
		marked[s] = true;
		for (int i : g.neighbours(s)) {
			if (!marked[i]) {
				color[i] = !color[s];
				dfs(i);
			} else if (color[i] == color[s]) {
				isBipartite = false;
			}
		}

	}

	public boolean isBiPartite() {
		return this.isBipartite;
	}

}
