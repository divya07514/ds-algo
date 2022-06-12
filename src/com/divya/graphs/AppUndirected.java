package com.divya.graphs;

public class AppUndirected {

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(0, 5);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(1, 2);
		g.addEdge(0, 1);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(0, 2);
		
		DepthFirstSearch dfs = new DepthFirstSearch(g);
		dfs.dfs(0);
		System.out.println();
		System.out.println(dfs.pathTo(0, 4));
		
		BreadthFirstSearch bfs = new BreadthFirstSearch(g);
		bfs.bfs(0);
		System.out.println();
		System.out.println(bfs.pathTo(0, 4));
		
		Graph cycle = new Graph(5);
		cycle.addEdge(0, 1);
		cycle.addEdge(0, 2);
		cycle.addEdge(2, 3);
		cycle.addEdge(1, 3);
		cycle.addEdge(1, 4);
		cycle.addEdge(3, 4);
		Cycle c = new Cycle(cycle);
		c.cycleDetection();
		System.out.println(c.hasCycle());
		TwoColor color = new TwoColor(cycle);
		color.checkTwoColor();
		System.out.println(color.isBiPartite());

	}

}
