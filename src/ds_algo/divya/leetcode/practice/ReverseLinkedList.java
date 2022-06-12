package ds_algo.divya.leetcode.practice;

import com.divya.linked.list.ListNode;

public class ReverseLinkedList {

	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode current = head;
		ListNode prev = null;
		ListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + "->");
			current = current.next;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		printList(head);
		System.out.println();
		ListNode reversed = reverseList(head);
		printList(reversed);

	}

}
