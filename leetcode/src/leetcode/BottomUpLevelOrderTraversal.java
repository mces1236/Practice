package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BottomUpLevelOrderTraversal {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		
//		TreeNode l1l = new TreeNode(9);
		TreeNode l1r = new TreeNode(20);

//		root.left = l1l;
		root.right = l1r;
		
		TreeNode l2fl = new TreeNode(10);
		TreeNode l2fr = new TreeNode(11);
		
//		l1l.left = l2fl;
//		l1l.right = l2fr;
//		
		TreeNode l2sl = new TreeNode(15);
		TreeNode l2sr = new TreeNode(7);
		
		l1r.left = l2sl;
		l1r.right = l2sr;
		
		TreeNodeUtils.printTree(root);
		System.out.println(new BottomUpLevelOrderTraversal().levelOrderBottom(root));
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if(root == null) return null;
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.addLast(root);
		int count = 0;
		
		while(!queue.isEmpty()) {
			
			if(count == 0) {
				List<Integer> list = getListFromTreeNodes(queue);
				res.add(0, list);
				count = queue.size();
			}
			
			TreeNode cur = queue.removeFirst();
			count--;
			
			if(cur.left != null) queue.add(cur.left);
			if(cur.right != null) queue.add(cur.right);
		}
		
		return res;
    }

	private List<Integer> getListFromTreeNodes(LinkedList<TreeNode> queue) {
		List<Integer> list = new ArrayList<Integer>();
		for(TreeNode node : queue) {
			list.add(node.val);
		}
		return list;
	}
}
