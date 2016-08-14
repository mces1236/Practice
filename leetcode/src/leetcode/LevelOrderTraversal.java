package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		Bst bst = new Bst();
		bst.insert(10);
		
		bst.insert(5);
		bst.insert(15);
		
		bst.insert(7);
		
		bst.insert(17);
		
		TreeNodeUtils.printTree(bst.root);
		System.out.println(new LevelOrderTraversal().levelOrder(bst.root));
	}

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> op = new ArrayList<List<Integer>>();
		if(root == null) return op;

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int count = 0;

		while(!queue.isEmpty()) {
			if(count == 0) {
				op.add(getIntList(queue));
				count = queue.size();
			}

			TreeNode cur = queue.removeFirst();
			count--;

			if(cur.left != null) queue.addLast(cur.left);
			if(cur.right != null) queue.addLast(cur.right);
		}

		return op;
	}

	private List<Integer> getIntList(LinkedList<TreeNode> queue) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		Iterator<TreeNode> i = queue.iterator();
		
		while (i.hasNext()) {
			TreeNode treeNode = i.next();
			list.add(treeNode.val);
		}
		
		return list;
	}

}
