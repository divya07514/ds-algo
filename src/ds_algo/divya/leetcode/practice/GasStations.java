package ds_algo.divya.leetcode.practice;

public class GasStations {

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		for (int i = 0; i < gas.length; i++) {
			if (gas[i] >= cost[i]) {
				boolean result = circuit(i, gas, cost);
				if (result) {
					return i;
				}
			}
		}
		return -1;
	}

	private static boolean circuit(int start, int[] gas, int[] cost) {
		int i = start;
		int hops = 1;
		int fuel = gas[i];
		int n = gas.length;
		while (fuel >= cost[i]) {
			if (hops == gas.length) {
				return true;
			} else {
				fuel = fuel - cost[i % n] + gas[(i + 1) % n];
				i++;
				i = i % gas.length;
				hops++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };

		System.out.println(canCompleteCircuit(gas, cost));
	}

}
