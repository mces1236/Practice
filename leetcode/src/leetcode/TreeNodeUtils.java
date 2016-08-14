package leetcode;

import java.util.LinkedList;

public class TreeNodeUtils {

	public static void printTree(TreeNode root) {
		if(root == null) return;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int count = 0;
		
		while(!queue.isEmpty()) {
			if(count == 0) {
				System.out.println(queue);
				count = queue.size();
			}
			
			TreeNode cur = queue.removeFirst();
			count--;
			
			if(cur.left != null) queue.addLast(cur.left);
			if(cur.right != null) queue.addLast(cur.right);
		}
	}
}
