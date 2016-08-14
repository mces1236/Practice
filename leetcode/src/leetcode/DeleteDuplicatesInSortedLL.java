package leetcode;

public class DeleteDuplicatesInSortedLL {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		
		ListNode first = new ListNode(1);
		head.next = first;
		
		ListNode second = new ListNode(2);
		first.next = second;
		
		ListNode third = new ListNode(3);
		second.next = third;
		
		ListNode third2 = new ListNode(3);
		third2.next = third;
		
		third2.next = null;
		
		System.out.println(head);
		System.out.println(new DeleteDuplicatesInSortedLL().deleteDuplicates(head));
	}

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;
		
		ListNode cur = head.next;
		ListNode pre = head;
		
		while(cur != null) {
			if(pre.val == cur.val) {
				cur = cur.next;
				pre.next = cur;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		
		return head;
	}
}
