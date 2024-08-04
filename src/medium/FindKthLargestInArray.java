package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Only challenge is to write Comparator
 * @author divya.thakur
 *
 */
public class FindKthLargestInArray {

	public String kthLargestNumber(String[] nums, int k) {

		if (nums == null || nums.length == 0) {
			return "";
		}

		Comparator<String> c = (a, b) -> {
			if (a.length() == b.length()) {
				return a.compareTo(b);
			}
			return Integer.compare(a.length(), b.length());
		};

		PriorityQueue<String> pq = new PriorityQueue<String>(c);

		for (String s : nums) {
			pq.add(s);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		System.out.println(pq);
		return pq.poll();
	}

}
