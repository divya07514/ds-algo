package com.divya.graphs;

import java.util.LinkedList;

public class DepthFirstSearch {

	private boolean[] marked;
	private int[] edgeTo;
	private int count;
	private Graph g;

	public DepthFirstSearch(Graph g) {
		this.g = g;
		this.marked = new boolean[g.vertices()];
		edgeTo = new int[g.vertices()];
	}

	public void dfs(int s) {
		marked[s] = true;
		System.out.print(s + " ");
		count++;
		for (int i : g.neighbours(s)) {
			if (!isMarked(i)) {
				edgeTo[i] = s;
				dfs(i);
			}
		}
	}

	public boolean isMarked(int v) {
		return marked[v];
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public int getCount() {
		return count;
	}
	
	public Iterable<Integer> pathTo(int source, int destination){
		if(!hasPathTo(destination)) {
			return null;
		}
		LinkedList<Integer> stack = new LinkedList<>();
		for(int v=destination;v!=source;v = edgeTo[v]) {
			stack.push(v);
		}
		stack.push(source);
		return stack;
	}

}
