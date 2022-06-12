package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseScheludeTwo {
	
	static boolean  hasCycle = false;
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		if(prerequisites==null || prerequisites.length==0) {
			int[] temp = new int[numCourses];
			for(int i=0;i<numCourses;i++) {
				temp[i] = i;
			}
			return temp;
		}
		Map<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
		getneighbours(prerequisites, map);
		
		boolean[] marked =  new boolean[numCourses];
		LinkedList<Integer> topoSort = new LinkedList<>();
		boolean[] currentStack = new boolean[numCourses];
		for(int i=0;i<numCourses;i++) {
			if(!marked[i]) {
				dfs(i,map,topoSort,marked,currentStack);
			}
		}

		if(hasCycle) {
			hasCycle = false;
			return new int[1];
		}
		int[] result = new int[numCourses];
		int index = 0;
		while(!topoSort.isEmpty()) {
			result[index++] = topoSort.pop();
		}
		return result;
	}

	private static void dfs(int i, Map<Integer, List<Integer>> map, LinkedList<Integer> stack, boolean[] marked,boolean[] currentStack ) {
		marked[i] =true;
		currentStack[i] = true;
		if(map.containsKey(i)) {
			for(int j : map.get(i)) {
				if(!marked[j]) {
					dfs(j, map, stack, marked,currentStack);
				}else if(currentStack[j]) {
					hasCycle=true;
					return;
				}
			}
		}
		currentStack[i] = false;
		stack.push(i);
	}

	private static void getneighbours(int[][] prerequisites, Map<Integer, List<Integer>> map) {
		for(int i=0;i<prerequisites.length;i++) {
			int one = prerequisites[i][0];
			int two = prerequisites[i][1];
			if(!map.containsKey(two)) {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(one);
				map.put(two,temp);
			}else {
				map.get(two).add(one);
			}
		}
	}

	public static void main(String[] args) {
		int[][] prerequisites =  {{1,0},{2,0},{3,1},{3,2}};
		int numCourses = 4;
		ArrayUtil.printArray(findOrder(numCourses, prerequisites));
	}

}
