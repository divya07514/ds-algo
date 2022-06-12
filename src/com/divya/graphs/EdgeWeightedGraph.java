package com.divya.graphs;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {

	private int v;
	private int edge;
	private List<List<Edge>> adj;

	public EdgeWeightedGraph(int v) {
		this.v = v;
		this.edge = 0;
		adj = new ArrayList<>();
		for (int i = 0; i < this.v; i++) {
			adj.add(new ArrayList<Edge>());
		}
	}

	public int vertices() {
		return v;
	}

	public int edgeCount() {
		return this.edge;
	}

	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adj.get(v).add(e);
		adj.get(w).add(e);
		edge++;
	}

	public Iterable<Edge> neighbours(int v) {
		return adj.get(v);
	}

	public Iterable<Edge> edges() {
		List<Edge> b = new ArrayList<Edge>();
		for (int v = 0; v < this.v; v++) {
			for (Edge e : adj.get(v)) {
				if (e.other(v) > v) {
					b.add(e);
				}
			}
		}
		return b;
	}

}
