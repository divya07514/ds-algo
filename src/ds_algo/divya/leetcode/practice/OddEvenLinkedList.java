package ds_algo.divya.leetcode.practice;

public class OddEvenLinkedList {
	
	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode odd = head;
		ListNode oddDum = odd;
		ListNode even = head.next;
		ListNode evenDum = even;
		while (odd.next != null && even.next != null) {
			odd.next = odd.next.next;
			odd = odd.next;
			even.next = even.next.next;
			even = even.next;
		}
		head = oddDum;
		while (oddDum != null) {
			oddDum = oddDum.next;
		}
		odd.next = evenDum;
		return head;
	}
}
