package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RemoveAllAdjacentDuplicatesInStringTwo {

	/**
	 * Self implemented code
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public static String removeDuplicates_tle(String s, int k) {
		LinkedList<Character> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!stack.isEmpty() && stack.peek() == ch) {
				List<Character> list = new ArrayList<>();
				int counter = 0;
				while (counter < k - 1) {
					if (!stack.isEmpty() && stack.peek() == ch) {
						char c = stack.pop();
						list.add(c);
					} else {
						break;
					}
					counter++;
				}
				if (list.size() != k - 1) {
					for (int j = list.size() - 1; j >= 0; j--) {
						stack.push(list.get(j));
					}
					stack.push(ch);
				}
			} else {
				stack.push(ch);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}

	/**
	 * Optimal Solution.
	 * @param s
	 * @param k
	 * @return
	 */
	public static String removeDuplicates(String s, int k) {
		LinkedList<DupPairs> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!stack.isEmpty() && stack.peek().ch==ch) {
				if(stack.peek().ch==ch) {
					stack.peek().count = stack.peek().count + 1;
				}
				if(stack.peek().count==k) {
					stack.pop();
				}
			} else {
				DupPairs dp = new DupPairs(ch, 1);
				stack.push(dp);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			DupPairs dp = stack.pop();
			while(dp.count > 0) {
				sb.append(dp.ch);
				dp.count--;
			}
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String s = "deeedbbcccbdaa";
		int k = 3;
		System.out.println(removeDuplicates_tle(s, k));
		System.out.println(removeDuplicates(s, k));
	}

}

class DupPairs {
	char ch;
	int count;
	public DupPairs(char ch, int count) {
		super();
		this.ch = ch;
		this.count = count;
	}
	@Override
	public String toString() {
		return "DupParis [ch=" + ch + ", count=" + count + "]";
	}
}
