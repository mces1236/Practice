package leetcode;

public class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; this.next = null;}
	 
	 @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(val);
		
		ListNode temp = next;
		
		while(temp != null) {
			sb.append(' ');
			sb.append(temp.val);
			temp = temp.next;
		}
		
		return sb.toString();
	}
}
