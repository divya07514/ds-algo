package com.divya.graphs;

import java.util.ArrayList;
import java.util.List;

public class DiGraph {

	private int vertices;
	private int edges;
	private List<List<Integer>> adj;

	public DiGraph(int vertices) {
		this.vertices = vertices;
		this.adj = new ArrayList<List<Integer>>();
		for (int i = 0; i < this.vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}

	public int vertices() {
		return this.vertices;
	}

	public int edges() {
		return this.edges;
	}

	public void addEdge(int u, int v) {
		adj.get(u).add(v);
		edges++;
	}

	public Iterable<Integer> neighbours(int v) {
		return adj.get(v);
	}

	public DiGraph reverse() {
		DiGraph reverse = new DiGraph(this.vertices);
		for (int i = 0; i < vertices; i++) {
			for (int j : adj.get(i)) {
				reverse.addEdge(j, i);
			}
		}
		return reverse;
	}

}
