package ds_algo.divya.leetcode.practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares {

	public static int numSquares(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		int level = 1;
		int result = 0;
		boolean found = false;
		q.add(n);
		q.add(-1);
		Set<Integer> set = new HashSet<>();

		while (!q.isEmpty()) {
			while (q.peek()!=-1) {
				int temp = q.poll();
				if(!set.contains(temp)) {
					set.add(temp);
					for (int i = 1;; i++) {
						int square = i * i;
						if(temp - square < 0) {
							break;
						}
						if (temp - square > 0) {
							q.add(temp - square);
						}
						if (temp - square == 0) {
							result = level;
							found = true;
							break;
						}
					}	
				}
				if (found) {
					break;
				}
			}
			if (found) {
				break;
			}
			q.add(-1);
			level++;
			q.poll();
			
		}
		return result;
	}

	public static void main(String[] args) {
		int n = 13;
		System.out.println(numSquares(n));

	}

}
