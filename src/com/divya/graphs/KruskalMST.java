package com.divya.graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.divya.union.find.QuickUnion;
import com.divya.union.find.UnionFind;

/**
 * ElogE time complexity;
 * 
 * @author abc
 *
 */
public class KruskalMST {

	private Queue<Edge> mst;
	private int weight;

	public KruskalMST(EdgeWeightedGraph g) {
		this.mst = new LinkedList<Edge>();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		for (Edge e : g.edges()) {
			pq.add(e);
		}
		UnionFind uf = new QuickUnion(g.vertices());
		while (!pq.isEmpty() && mst.size() < g.vertices() - 1) {
			Edge e = pq.poll();
			int v = e.either();
			int w = e.other(v);
			if (uf.connected(v, w)) {
				continue;
			}
			uf.union(v, w);
			mst.add(e);
			weight = weight + e.weight();
		}
	}

	public Iterable<Edge> mstEdges() {
		return this.mst;
	}

}
