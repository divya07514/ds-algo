package com.divya.graphs;

public class Edge implements Comparable<Edge> {

	private int v;
	private int w;
	private Integer weight;

	public Edge(int v, int w, int weight) {
		super();
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int weight() {
		return this.weight;
	}

	public int either() {
		return this.v;
	}

	public int other(int vertex) {
		if (vertex == v) {
			return w;
		} else {
			return v;
		}
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight.compareTo(o.weight);
	}

	@Override
	public String toString() {
		return "Edge [v=" + v + ", w=" + w + ", weight=" + weight + "]";
	}

}
