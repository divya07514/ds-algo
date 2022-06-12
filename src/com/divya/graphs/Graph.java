package com.divya.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private int vertices;
	private int edges;
	private List<List<Integer>> adj;

	public Graph(int vertices) {
		this.vertices = vertices;
		this.edges = 0;
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

	public void addEdge(int v, int u) {
		adj.get(v).add(u);
		adj.get(u).add(v);
		edges++;
	}

	public Iterable<Integer> neighbours(int v) {
		return adj.get(v);
	}

}
