package ds_algo.divya.leetcode.practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WallsAndGates {
	
	/**
	 * Uses a bfs approach
	 * @param rooms
	 */
	public static void wallsAndGates_bfs(int[][] rooms) {
		if (rooms == null || rooms.length == 0) {
			return;
		}
		int r = rooms.length;
		int c = rooms[0].length;
		Set<RoomsPair> visited = new HashSet<>();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(rooms[i][j]==0) {
					RoomsPair start = new RoomsPair(i, j);
					taverse(start, rooms,visited);
				}
				visited.clear();
			}
		}
	}

	private static void taverse(RoomsPair start, int[][] rooms, Set<RoomsPair> visited) {
		LinkedList<RoomsPair> q = new LinkedList<>();
		q.add(start);
		int distance = 1;
		while(!q.isEmpty()) {
			int qs = q.size();
			while(qs > 0) {
				RoomsPair temp = q.poll();
				int x = temp.x-1;
				int y = temp.y;
		
				RoomsPair up = new RoomsPair(x, y);
				if(isValid(x, y, rooms) && rooms[x][y]!=-1 && !visited.contains(up)) {
					updateDistance(rooms, visited, q, distance, x, y, up);
				}
				x = temp.x+1;
				y= temp.y;
				RoomsPair down = new RoomsPair(x, y);
				if(isValid(x, y, rooms) && rooms[x][y]!=-1 && !visited.contains(down)) {
					updateDistance(rooms, visited, q, distance, x, y, down);
				}
				x = temp.x;
				y= temp.y+1;
				RoomsPair right = new RoomsPair(x, y);
				if(isValid(x, y, rooms) && rooms[x][y]!=-1 && !visited.contains(right)) {
					updateDistance(rooms, visited, q, distance, x, y, right);
				}
				x = temp.x;
				y= temp.y-1;
				RoomsPair left = new RoomsPair(x, y);
				if(isValid(x, y, rooms) && rooms[x][y]!=-1 && !visited.contains(left)) {
					updateDistance(rooms, visited, q, distance, x, y, left);
				}
				qs--;
			}
			distance++;
		}
	}

	private static void updateDistance(int[][] rooms, Set<RoomsPair> visited, LinkedList<RoomsPair> q, int distance, int x, int y, RoomsPair up) {
		q.add(up);
		visited.add(up);
		if(distance < rooms[x][y]) {
			rooms[x][y] =  distance;
		}
	}
	
	private static boolean isValid(int i, int j, int[][] copy) {
		if (i < 0 || i >= copy.length || j < 0 || j >= copy[0].length) {
			return false;
		}
		return true;
	}
	
	/**
	 * Uses a dfs approach
	 * @param rooms
	 */
	 public static void wallsAndGates_dfs(int[][] rooms) {
		 if (rooms == null || rooms.length == 0) {
				return;
			}
			int r = rooms.length;
			int c = rooms[0].length;
			
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					if(rooms[i][j]==0) {
						dfs(i,j,0,rooms);
					}
				}
			}
	    }

	private static void dfs(int i, int j, int distance, int[][] rooms) {
		if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < distance) {
			return ;
		}
		rooms[i][j]=distance;
		dfs(i+1,j,distance+1,rooms);
		dfs(i-1,j,distance+1,rooms);
		dfs(i,j+1,distance+1,rooms);
		dfs(i,j-1,distance+1,rooms);
	}

	public static void main(String[] args) {
		int[][] rooms = {
							{2147483647, -1, 0, 2147483647},
							{2147483647, 2147483647, 2147483647, -1},
							{2147483647, -1, 2147483647, -1},
							{0, -1 , 2147483647, 2147483647}
					};
		
		//wallsAndGates_bfs(rooms);
		wallsAndGates_dfs(rooms);
		ArrayUtil.print(rooms);
	}
}

class RoomsPair{
	 int x;
	 int y;
	public RoomsPair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "RoomsPair [x=" + x + ", y=" + y + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoomsPair other = (RoomsPair) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	 
}
