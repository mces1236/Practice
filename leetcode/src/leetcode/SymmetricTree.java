package leetcode;

import java.util.Iterator;
import java.util.LinkedList;

public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		
		TreeNode l1l = new TreeNode(9);
		TreeNode l1r = new TreeNode(9);

		root.left = l1l;
		root.right = l1r;
		
		TreeNode l2fl = new TreeNode(10);
		TreeNode l2fr = new TreeNode(11);
		
//		l1l.left = l2fl;
		l1l.right = l2fr;
		
		TreeNode l2sl = new TreeNode(11);
		TreeNode l2sr = new TreeNode(11);
		
//		l1r.left = l2sl;
		l1r.right = l2sr;
		
		TreeNodeUtils.printTree(root);
		
		System.out.println(new SymmetricTree().isSymmetric(root));
	}

	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int count = 0;

		while(!queue.isEmpty()) {
			if(count == 0) {
				count = queue.size();
				if(!isSymmetric(queue, count)) return false; 
			}

			TreeNode cur = queue.removeFirst();
			count--;

			if(cur != null) {
				queue.addLast(cur.left);
				queue.addLast(cur.right);
			}
		}
		
		return true;
	}


	private boolean isSymmetric(LinkedList<TreeNode> queue, int count) {
		count /= 2;
		Iterator<TreeNode> iterator = queue.iterator();
		Iterator<TreeNode> reviterator = queue.descendingIterator();
		
		int i = 0;
		while(i < count) {
			TreeNode f = iterator.next();
			TreeNode l = reviterator.next();
			
			if(f != null && l != null)
				if(f.val != l.val) return false;
			
			if(f == null && l != null) return false;
			if(f != null && l == null) return false;
			
			i++;
		}
		
		return true;
	}

}
