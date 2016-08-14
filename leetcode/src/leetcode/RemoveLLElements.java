package leetcode;

public class RemoveLLElements {

	public static void main(String[] args) {
		
	}

	public ListNode removeElements(ListNode head, int val) {

		while(head != null && head.val == val) head = head.next;

		if(head == null) return null;

		ListNode pre = head, cur = head.next;

		while(cur != null) {
			if(cur.val == val) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}

		return head;
	}
}
