package ds_algo.divya.leetcode.practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MinimumKnightMoves {

	public static int minKnightMoves(int x, int y) {
		if (x == 0 && y == 0) {
			return 0;
		}
		if (Math.abs(x) == 1 && Math.abs(y) == 1) {
			return 2;
		}
		return bfs(Math.abs(x), Math.abs(y));
	}

	public static int bfs(int x, int y) {
		int[] rows = { 2, 2, 1, -1, -2, -2, -1, 1 };
		int[] cols = { 1, -1, -2, -2, -1, 1, 2, 2 };
		Set<String> marked = new HashSet<>();
		Cell start = new Cell(0, 0, 0);
		LinkedList<Cell> q = new LinkedList<>();
		q.add(start);
		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs > 0) {
				Cell temp = q.poll();
				if (temp.x == x && temp.y == y) {
					return temp.dist;
				}
				String point = "(" + temp.x + "," + temp.y + ")";
				if (!marked.contains(point)) {
					marked.add(point);
					for (int i = 0; i < rows.length; i++) {
						if (safe(temp.x + rows[i], temp.y + cols[i])) {
							Cell next = new Cell(temp.x + rows[i], temp.y + cols[i], temp.dist + 1);
							q.add(next);
						}
					}
				}
				qs--;
			}
		}
		return -1;
	}

	public static boolean safe(int x, int y) {
		if (x >= 0 && x < 301 && y >= 0 && y < 301) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int x =-1;
		int y = -1;
		System.out.println(minKnightMoves(x, y));
	}

}

class Cell {

	int x;
	int y;
	int dist;

	public Cell(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	public String toString() {
		return "(" + x + "," + y + ")" + "->" + dist;
	}
}
