package binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeUtils;

public class BinaryTree {

	Node root = null;
	
	public BinaryTree(int rootValue) {
		this.root = new Node(rootValue);
	}
	
	public void insert(int value) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node current = queue.remove();
			
			if (current.left == null) {
				current.left = new Node(value);
				queue.clear();
			}
			else if (current.right == null) {
				current.right = new Node(value);
				queue.clear();
			}
			else {
				queue.add(current.left);
				queue.add(current.right);
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(1);
		
		for(int i = 2; i < 10; i++)
			bt.insert(i);
		
		System.out.println(TreeUtils.bfs(bt.root));
		System.out.println(TreeUtils.inorder(bt.root));
		System.out.println(TreeUtils.preorder(bt.root));
		System.out.println(TreeUtils.postorder(bt.root));
	}

}
