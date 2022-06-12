package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		List<Integer> list = new ArrayList<>();
		int index = 0;
		while (head != null) {
			if (head.val < x) {
				list.add(index++, head.val);
			} else {
				list.add(head.val);
			}
			head = head.next;
		}
		// System.out.println(list);
		ListNode dummy = new ListNode(0);
		head = dummy;
		for (int i = 0; i < list.size(); i++) {
			ListNode temp = new ListNode(list.get(i));
			dummy.next = temp;
			dummy = dummy.next;
		}
		head = head.next;
		return head;
	}
}
