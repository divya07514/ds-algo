package ds_algo.divya.leetcode.practice;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame3 {

	public static boolean canReach(int[] array, int start) {
		if (array == null || array.length == 0) {
			return false;
		}
		boolean[] isVisited = new boolean[array.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		isVisited[start] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();
			if (array[temp] == 0) {
				return true;
			}
			int jumpForward = temp + array[temp];
			if (jumpForward < array.length && !isVisited[jumpForward]) {
				q.add(jumpForward);
				isVisited[jumpForward] = true;
			}
			int jumpBackward = temp - array[temp];
			if (jumpBackward >= 0 && !isVisited[jumpBackward]) {
				q.add(jumpBackward);
				isVisited[jumpBackward] = true;

			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] array = { 4, 2, 3, 0, 3, 1, 2 };
		int start = 5;
		System.out.println(canReach(array, start));

	}

}
