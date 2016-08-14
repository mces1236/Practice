package leetcode;

public class NthNodeFromEndOfLL {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);

		ListNode first = new ListNode(2);
		head.next = first;

		ListNode second = new ListNode(3);
		first.next = second;

		ListNode third = new ListNode(4);
		second.next = third;

		ListNode third2 = new ListNode(5);
		third.next = third2;

		third2.next = null;

		System.out.println(head);
		System.out.println(new NthNodeFromEndOfLL().removeNthFromEnd(head, 0));
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null) return head;

		ListNode tempHead = head;
		while(n > 1 && tempHead != null) {
			tempHead = tempHead.next;
			n--;
		}
		
		if(tempHead == null) return head;
		
		if(tempHead.next == null) {
			tempHead = head;
			head = head.next;
			tempHead = null;
			return head;
		}

		ListNode toRemove = head;
		tempHead = tempHead.next;

		while(tempHead.next != null) {
			tempHead = tempHead.next;
			toRemove = toRemove.next;
		}
		
		tempHead = toRemove.next;
		toRemove.next = tempHead.next;
		tempHead = null;


		return head;
	}

}
