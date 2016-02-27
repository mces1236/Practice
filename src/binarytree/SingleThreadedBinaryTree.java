package binarytree;

import java.util.Stack;

public class SingleThreadedBinaryTree {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(1);
		
		for(int i = 2; i < 10; i++)
			bt.insert(i);
		
		SingleThreadedBinaryTree stbt = new SingleThreadedBinaryTree();
		stbt.threadedBinaryTree(bt.root);
		stbt.traverse(bt.root);
	}
	
	private void threadedBinaryTree(Node cur) {
		if (cur == null) return;
		
		Node pre = null;
		Stack<Node> stack = new Stack<Node>();
		stack.push(cur);
		
		while(!stack.isEmpty()) {
			while(cur.left != null) {
				stack.push(cur.left);
				cur = cur.left;
			}
			cur = stack.pop();
			if(pre != null && isLeafNode(pre)) pre.right = cur;
			pre = cur;
			if(cur.right != null) {
				stack.push(cur.right);
				cur = cur.right;
			}
		}
	}

	public void threadedBinaryTreeRecursive(Node cur, Node pre) {
		if(cur != null) {
			threadedBinaryTreeRecursive(cur.left, cur);
			if(cur.right == null) cur.right = pre;
			threadedBinaryTreeRecursive(cur.right, cur);
		}
	}
	
	public void traverse(Node cur) {
		cur = leftMost(cur);
		
		while(cur != null) {
			System.out.print(cur + " ");
			if(isThreaded(cur)) {
				cur = cur.right;
			} else {
				cur = leftMost(cur.right);
			}
		}
	}
	
	private boolean isLeafNode(Node cur) {
		if(cur.left == null && cur.right == null) return true;
		return false;
	}

	private boolean isThreaded(Node cur) {
		if(cur.left == null && cur.right != null) return true;
		return false;
	}

	private Node leftMost(Node cur) {
		
		if(cur != null)
		while(cur.left != null) {
			cur = cur.left;
		}
		
		return cur;
	}

}
