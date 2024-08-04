package medium;

import java.util.LinkedList;

public class DailyTemperatures {

	public int[] dailyTemperatures(int[] temp) {

		LinkedList<Pair> stack = new LinkedList();
		int[] result = new int[temp.length];
		int n = temp.length - 1;
		result[n] = 0;
		stack.push(new Pair(temp[n], n));

		for (int i = n - 1; i >= 0; i--) {
			int num = temp[i];
			while (!stack.isEmpty() && num >= stack.peek().num) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				result[i] = 0;
				stack.push(new Pair(num, i));
			} else {
				result[i] = stack.peek().pos - i;
				stack.push(new Pair(num, i));
			}
		}

		return result;

	}

	class Pair {
		int num;
		int pos;

		public Pair(int num, int pos) {
			this.num = num;
			this.pos = pos;
		}
	}

}
