package binarytree;

public class SingleThreadedBinaryTree {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(1);
		
		for(int i = 2; i < 10; i++)
			bt.insert(i);
		
		SingleThreadedBinaryTree stbt = new SingleThreadedBinaryTree();
		stbt.threadedBinaryTree(bt.root, null);
		stbt.traverse(bt.root);
	}
	
	public void threadedBinaryTree(Node cur, Node pre) {
		if(cur != null) {
			threadedBinaryTree(cur.left, cur);
			if(cur.right == null) cur.right = pre;
			threadedBinaryTree(cur.right, cur);
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
