package com.divya.graphs;

public class Cycle {

	private boolean marked[];
	private boolean hasCycle;
	private Graph g;

	public Cycle(Graph g) {
		this.g = g;
		this.marked = new boolean[g.vertices()];
	}

	public void cycleDetection() {
		for (int i = 0; i < g.vertices(); i++) {
			if (!marked[i]) {
				dfs(i, i);
			}
		}
	}

	private void dfs(int child, int parent) {
		marked[child] = true;
		for (int i : g.neighbours(child)) {
			if (!marked[i]) {
				dfs(i, child);
			} else if (i != parent) {
				hasCycle = true;
			}
		}
	}

	public boolean hasCycle() {
		return hasCycle;
	}

}
