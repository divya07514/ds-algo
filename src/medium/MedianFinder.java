package medium;

import java.util.PriorityQueue;

public class MedianFinder {

	PriorityQueue<Integer> max;
	PriorityQueue<Integer> min;

	public MedianFinder() {
		this.min = new PriorityQueue<>();// right part
		this.max = new PriorityQueue<>((a, b) -> b - a);// left part
	}

	public void addNum(int num) {
		this.max.add(num);
		// values check
		if (!this.min.isEmpty() && this.max.peek() > this.min.peek()) {
			this.min.add(this.max.poll());
		}
		// size check
		if (this.max.size() > this.min.size() + 1) {
			this.min.add(this.max.poll());
		} else if (this.min.size() > this.max.size() + 1) {
			this.max.add(this.min.poll());
		}
	}

	public double findMedian() {
		if (this.max.size() > this.min.size()) {
			return this.max.peek() * 1.0d;
		} else if (this.min.size() > this.max.size()) {
			return this.min.peek() * 1.0d;
		} else {
			double result = (this.max.peek() * 1.0d + this.min.peek() * 1.0d) / 2;
			return result;
		}
	}

	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(3);
		System.out.println(mf.findMedian());

	}

}
