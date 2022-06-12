package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberOfUniqueIntegersAfterKRemovals {

	public static int findLeastNumOfUniqueInts(int[] arr, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}
		pq.addAll(map.values());
		while (k > 0) {
			int temp = pq.poll();
			if (--temp > 0) {
				pq.add(temp);
			}
			k--;
		}
		return pq.size();
	}

	public static void main(String[] args) {
		int[] arr = {4,3,1,1,3,3,2};
		int k =3;
		System.out.println(findLeastNumOfUniqueInts(arr, k));
 	}

}
