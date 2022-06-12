package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinimumDeletionCostToAvoidRepeatingLetters {
	
	public static int minCost(String s, int[] cost) {
		List<Cost> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Cost temp = new Cost(c, cost[i]);
			list.add(temp);
		}
		LinkedList<Cost> stack = new LinkedList<>();
		int min = 0;
		for (Cost c : list) {
			if (stack.isEmpty()) {
				stack.push(c);
			} else {
				Cost top = stack.peek();
				if (top.ch != c.ch) {
					stack.push(c);
				} else {
					if (!stack.isEmpty()) {
						if (top.cost < c.cost) {
							min = min + top.cost;
							stack.pop();
							stack.push(c);
						} else {
							min = min + c.cost;
						}
					}
				}
			}
		}
		return min;
	}
	public static void main(String[] args) {
		String s = "aaabbbabbbb";
		int[] cost = {3,5,10,7,5,3,5,5,4,8,1};
		System.out.println(minCost(s, cost));
	}

}

class Cost {

	char ch;
	int cost;

	public Cost(char ch, int cost) {
		this.ch = ch;
		this.cost = cost;
	}

	public String toString() {
		return ch + ", " + cost;
	}
}
