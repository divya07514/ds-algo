package com.divya.graphs;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDigraph {

	private int v;
	private int edge;
	private List<List<DirectedEdge>> adj;

	public EdgeWeightedDigraph(int v) {
		this.v = v;
		this.edge = 0;
		adj = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<DirectedEdge>());
		}
	}

	public int vertices() {
		return this.v;
	}

	public int edges() {
		return this.edge;
	}

	public void addEdge(DirectedEdge e) {
		adj.get(e.from()).add(e);
		edge++;
	}

	public Iterable<DirectedEdge> neighbours(int v) {
		return adj.get(v);
	}

	public Iterable<DirectedEdge> shortestPathEdges() {
		List<DirectedEdge> bag = new ArrayList<DirectedEdge>();
		for (int v = 0; v < v; v++)
			for (DirectedEdge e : adj.get(v))
				bag.add(e);
		return bag;
	}

}
