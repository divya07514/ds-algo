package medium;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrangement {

	static int result;

	public static int countArrangement(int n) {
		result = 0;
		boolean[] marked = new boolean[n + 1];
		List<List<Integer>> list = new ArrayList();
		List<Integer> temp = new ArrayList();
		permute(1, n, marked, list, temp);
		System.out.println(list);
		return result;
	}

	private static void permute(int pos, int n, boolean[] marked, List<List<Integer>> list, List<Integer> temp) {
		if (pos > n) {
			List<Integer> l = new ArrayList(temp);
			list.add(l);
			result++;
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (!marked[i] && (i % pos == 0 || pos % i == 0)) {
				marked[i] = true;
				temp.add(i);
				permute(pos + 1, n, marked, list, temp);
				marked[i] = false;
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(countArrangement(n));
	}

}
