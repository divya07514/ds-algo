package easy;

import java.util.LinkedList;

public class Test {

	LinkedList<Integer> stack;
	LinkedList<Integer> minStack;
	LinkedList<Integer> maxStack;

	public Test() {
		this.maxStack = new LinkedList();
		this.minStack = new LinkedList();
		this.stack = new LinkedList();
	}

	public int pop() {

		if (stack.isEmpty()) {
			return -1;
		}

		int top = stack.pop();
		minStack.pop();
		maxStack.pop();
		return top;

	}

	public void push(int val) {
		stack.push(val);
		if (val < minStack.peek()) {
			minStack.push(val);
		} else {
			minStack.push(minStack.peek());
		}

		if (val > maxStack.peek()) {
			maxStack.push(val);
		} else {
			maxStack.push(maxStack.peek());
		}

	}

	public int min() {

		if (minStack.isEmpty()) {
			return -1;
		}

		return minStack.peek();

	}

	public int max() {

		if (maxStack.isEmpty()) {
			return -1;
		}

		return maxStack.peek();

	}

	public static void main(String[] args) {

	}

}
