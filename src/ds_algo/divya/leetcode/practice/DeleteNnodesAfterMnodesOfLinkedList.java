package ds_algo.divya.leetcode.practice;

public class DeleteNnodesAfterMnodesOfLinkedList {
	
	/**
	 * Asuuming that values n and m are not 0
	 * @param head
	 * @param n
	 * @param m
	 */
	public static void delete(ListNode head, int n, int m) {
		ListNode current = head;
		ListNode next = head;
		while(current!=null) {
			for(int i=1;i<m && current!=null ;i++) {
				current = current.next;
			}
			if(current==null) {
				return;
			}
			next = current.next;
			for(int i=1;i<=n;i++) {
				next=next.next;
			}
			current.next = next;
			current = next;
		}
	}
	
	public static void printList(ListNode head) {
		ListNode temp = head;
		while(temp!=null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode dummy = head;
		for(int i=1;i<=10;i++) {
			ListNode temp = new ListNode(i);
			head.next = temp;
			head=head.next;
		}
		head =dummy.next;
		dummy = head;
		printList(head);
		int m=2;
		int n=1;
		delete(head, n, m);
		printList(dummy);
	}

}
