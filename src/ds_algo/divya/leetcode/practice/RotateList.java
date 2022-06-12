package ds_algo.divya.leetcode.practice;

public class RotateList {

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		if (k == 0) {
			return head;
		}
		int len = 0;
		ListNode dummy = head;
		while (dummy != null) {
			len++;
			dummy = dummy.next;
		}
		if (k % len == 0) {
			return head;
		}
		int rotate = k % len;
		ListNode newHead = head;
		dummy = head;
		while (len - 1 >= rotate) {
			head = dummy;
			dummy = dummy.next;
			len--;
		}
		head.next = null;
		ListNode result = dummy;
		while (dummy.next != null) {
			dummy = dummy.next;
		}
		dummy.next = newHead;

		return result;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next= new ListNode(2);
		
		int k =4;
		rotateRight(head, k);
	}

}
