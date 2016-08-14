package leetcode;

import java.util.HashSet;

public class LinkedListCycle {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);

		ListNode first = new ListNode(1);
		head.next = first;

		ListNode second = new ListNode(2);
		first.next = second;

		ListNode third = new ListNode(3);
		second.next = third;

		ListNode third2 = new ListNode(3);
		third.next = third2;

		third2.next = first;

//		System.out.println(head);
		System.out.println(new LinkedListCycle().hasCycle(head));
	}

	public boolean hasCycle(ListNode head) {
		
		HashSet<ListNode> set = new HashSet<ListNode>();
		
		while(head != null) {
			if(set.contains(head)) return true;
			set.add(head);
			head = head.next;
		}
		
		return false;
//		ListNode twice = head;
//		
//		while(twice != null) {
//			head = head.next;
//			if(twice != null) twice = twice.next;
//			if(twice != null) twice = twice.next;
//			
//			if(head == twice) break;
//		}
//		
//		if(twice == null) return false;
//		
//		return true;
	}
}
