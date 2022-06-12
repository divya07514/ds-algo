package ds_algo.divya.leetcode.practice;

import java.util.Map;
import java.util.TreeMap;

public class CarFleet {

	public static int carFleet(int target, int[] position, int[] speed) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < position.length; i++) {
			int current = position[i];
			int diff = target - current;
			map.put(diff, speed[i]);
		}
		int result = 0;
		double time = -1.0d;
		for (int key : map.keySet()) {
			int value = map.get(key);
			double temp = 1.0d * key / value;
			if (temp > time) {
				result++;
				time = temp;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int target = 12;
		int[] position = {10,8,0,5,3};
		int[] speed = {2,4,1,1,3};
		System.out.println(carFleet(target, position, speed));
	}

}
