package com.divya.graphs;

public class AppDirected {

	public static void main(String[] args) {
		DiGraph g = new DiGraph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 5);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(3, 4);
		
		DirectedDFS dfs = new DirectedDFS(g);
		dfs.dfs(0);
		
		DiGraph cyclic = new DiGraph(6);
		cyclic.addEdge(0, 5);
		cyclic.addEdge(5, 4);
		cyclic.addEdge(4, 3);
		cyclic.addEdge(3, 5);
		System.out.println();
		
		DirectedCycle cycle = new DirectedCycle(cyclic);
		System.out.println(cycle.printCycle());

	}

}
