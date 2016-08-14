package leetcode;

public class SwapNodeInPair {

	public static void main(String[] args) {
		//		1 -> 2 -> 3 -> 4

		ListNode head = new ListNode(1);

		ListNode first = new ListNode(2);
		head.next = first;
		
		ListNode second = new ListNode(3);
		first.next = second;
//
//		ListNode third = new ListNode(4);
//		second.next = third;
//		
////		third.next = null;
//
//		ListNode fourth = new ListNode(5);
//		third.next = fourth;
//
//		fourth.next = null;
		
		System.out.println(head);
		System.out.println(new SwapNodeInPair().swapPairs(head));
	}

	public ListNode swapPairs(ListNode head) {

		if(head == null || head.next == null) return head;

		ListNode cur = head, pre = null, newHead = head.next;

		while(cur != null && cur.next != null) {
			if(pre != null) pre.next = cur.next;
			ListNode save = cur.next.next;
			cur.next.next = cur;
			cur.next = save;
			pre = cur;
			cur = save;
		}

		return newHead;
	}
}
