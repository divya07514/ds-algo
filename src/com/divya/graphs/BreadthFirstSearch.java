package com.divya.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	private boolean[] marked;
	private Graph g;
	private int edgeTo[];

	public BreadthFirstSearch(Graph g) {
		this.g = g;
		this.marked = new boolean[g.vertices()];
		this.edgeTo = new int[g.vertices()];
	}

	public void bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		marked[s] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");
			for (int i : g.neighbours(temp)) {
				if (!marked[i]) {
					edgeTo[i] = temp;
					marked[i] = true;
					q.add(i);
				}
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int source, int destination) {
		if (!hasPathTo(destination)) {
			return null;
		}
		LinkedList<Integer> stack = new LinkedList<>();
		for (int i = destination; i != source; i = edgeTo[i]) {
			stack.push(i);
		}
		stack.push(source);
		return stack;
	}

}
