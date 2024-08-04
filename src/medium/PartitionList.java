package medium;

public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return head;
		}
		ListNode small = new ListNode(0);
		ListNode smallptr = small;
		ListNode big = new ListNode(0);
		ListNode bigptr = big;

		while (head.next != null) {
			int val = head.val;
			if (val < x) {
				ListNode next = new ListNode(val);
				small.next = next;
				small = next;
			} else {
				ListNode next = new ListNode(val);
				big.next = next;
				big = next;
			}
			head = head.next;
		}
		int val = head.val;
		if (val < x) {
			ListNode next = new ListNode(val);
			small.next = next;
			small = next;
		} else {
			ListNode next = new ListNode(val);
			big.next = next;
			big = next;
		}

		small.next = bigptr.next;
		return smallptr.next;
	}
}

 class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
