package leetcode;

public class MergeSortedLL {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);

		ListNode first = new ListNode(3);
		l1.next = first;
		first.next = null;

//		ListNode second = new ListNode(5);
//		first.next = second;
//		second.next = null;

		ListNode l2 = new ListNode(2);

		ListNode third = new ListNode(4);
		l2.next = third;
		third.next = null;

		System.out.println(l1 + "\t" + l2);
		System.out.println(new MergeSortedLL().mergeTwoLists(l1, l2));
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;

		if(l1.val > l2.val) {
			head = l2;
			l2 = l2.next;
		} else {
			head = l1;
			l1 = l1.next;
		}

		ListNode temp = head;

		while(l1 != null && l2 != null) {
			if(l1.val > l2.val) {
				temp.next = l2;
				temp = l2;
				l2 = l2.next;
			} else {
				temp.next = l1;
				temp = l1;
				l1 = l1.next;
			}
		}
		
		while(l1 != null) {
			temp.next = l1;
			temp = l1;
			l1 = l1.next;
		}
		
		while(l2 != null) {
			temp.next = l2;
			temp = l2;
			l2 = l2.next;
		}

		return head;
	}

}
