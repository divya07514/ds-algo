package com.divya.graphs;

public class DirectedEdge {

	private int v;
	private int w;
	private int weight;

	public DirectedEdge(int v, int w, int weight) {
		super();
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int from() {
		return this.v;
	}

	public int to() {
		return this.w;
	}

	public int weight() {
		return this.weight;
	}

	@Override
	public String toString() {
		return "DirectedEdge [v=" + v + ", w=" + w + ", weight=" + weight + "]";
	}

}
