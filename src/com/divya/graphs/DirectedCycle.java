package com.divya.graphs;

import java.util.LinkedList;

public class DirectedCycle {

	private boolean[] marked;
	private int[] edgeTo;
	private LinkedList<Integer> stack;
	private boolean[] onStack;

	public DirectedCycle(DiGraph g) {
		this.marked = new boolean[g.vertices()];
		this.edgeTo = new int[g.vertices()];
		this.onStack = new boolean[g.vertices()];
		for (int i = 0; i < g.vertices(); i++) {
			if (!marked[i]) {
				dfs(g, i);
			}
		}
	}

	private void dfs(DiGraph g, int s) {
		marked[s] = true;
		onStack[s] = true;
		for (int i : g.neighbours(s)) {
			if (hasCycle()) {
				return;
			} else if (!marked[i]) {
				edgeTo[i] = s;
				dfs(g, i);
			} else if (onStack[i]) {
				stack = new LinkedList<Integer>();
				for (int j = s; j != i; j = edgeTo[j]) {
					stack.push(j);
				}
				stack.push(i);
				stack.push(s);
			}
		}
		onStack[s] = false;

	}

	public boolean hasCycle() {
		return stack != null;
	}

	public Iterable<Integer> printCycle() {
		return stack;
	}

}
