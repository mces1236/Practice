package leetcode;

public class IntersectionOfLinkedLists {

	public static void main(String[] args) {
		
		ListNode headA = new ListNode(0);
		ListNode headB = new ListNode(0);
		
		ListNode fA = new ListNode(1);
		ListNode fB = new ListNode(1);
		
		headA.next = fA;
		headB.next = fB;
		
		ListNode s = new ListNode(2);
		fA.next = s;
		ListNode t = new ListNode(3);
		fB.next = t;
		
		System.out.println(headA);
		System.out.println(headB);
		
		System.out.println(new IntersectionOfLinkedLists().getIntersectionNode(headA, headA));
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		if(headA == null || headB == null) return null;
		
		int alen = getLength(headA);
		int blen = getLength(headB);
		
		int diff = alen - blen;
		
		if(diff < 0){
			diff = -diff;
			headB = movePointerByCount(headB, diff);
		} else {
			headA = movePointerByCount(headA, diff);
		}
		
		while(headA != null) {
			if(headA == headB) return headA;
			
			headA = headA.next;
			headB = headB.next;
		}
		
		return null;
	}

	private ListNode movePointerByCount(ListNode head, int diff) {
		while(diff > 0) {
			head = head.next;
			diff--;
		}
		return head;
	}

	private int getLength(ListNode head) {
		if(head == null) return 0;
		
		int len = 0;
		
		while(head != null) {
			head = head.next;
			len++;
		}
		
		return len;
	}
}
