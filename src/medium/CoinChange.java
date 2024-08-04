package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Can be done using DP too but I see used BFS here. Minimum was the trigger for me to think BFS solution
 * @author divya.thakur
 *
 */
public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		if (coins.length == 0 || amount == 0) {
			return 0;
		}
		LinkedList<Integer> q = new LinkedList();
		q.add(amount);
		int level = 0;
		boolean found = false;
		Set<Integer> set = new HashSet();
		while (!q.isEmpty()) {
			int qs = q.size();
			while (qs > 0) {
				int temp = q.poll();
				if (temp == 0) {
					found = true;
					break;
				}
				for (int i = 0; i < coins.length; i++) {
					int diff = temp - coins[i];
					if (set.contains(diff)) {
						continue;
					}
					if (diff >= 0) {
						q.add(temp - coins[i]);
						set.add(diff);
					}
				}
				qs--;
			}
			if (found) {
				break;
			}
			level++;
		}
		if (!found) {
			return -1;
		}
		return level;
	}

}
