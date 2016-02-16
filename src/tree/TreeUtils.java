package tree;

import java.util.LinkedList;
import java.util.Queue;

import binarytree.Node;

public class TreeUtils {

	public static LinkedList<Node> bfs(Node root) {

		LinkedList<Node> bfsList = new LinkedList<Node>(); 

		if (root == null) return bfsList;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while(!queue.isEmpty()) {

			Node current = queue.remove();
//			System.out.print(current.value + " ");
			bfsList.add(current);

			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}

		return bfsList;
	}
	
	public static LinkedList<Node> inorder(Node root) {
		LinkedList<Node> inorderList = new LinkedList<Node>();
		
		if (root == null) return inorderList;
		
		inorderRecursive(root, inorderList);
		
		return inorderList;
	}
	
	private static void inorderRecursive(Node current, LinkedList<Node> list) {
		if(current != null) {
			inorderRecursive(current.left, list);
			list.add(current);
			inorderRecursive(current.right, list);
		}
	}
	
	public static LinkedList<Node> preorder(Node root) {
		LinkedList<Node> inorderList = new LinkedList<Node>();
		
		if (root == null) return inorderList;
		
		preorderRecursive(root, inorderList);
		
		return inorderList;
	}
	
	private static void preorderRecursive(Node current, LinkedList<Node> list) {
		if(current != null) {
			list.add(current);
			preorderRecursive(current.left, list);
			preorderRecursive(current.right, list);
		}
	}
	
	public static LinkedList<Node> postorder(Node root) {
		LinkedList<Node> inorderList = new LinkedList<Node>();
		
		if (root == null) return inorderList;
		
		postorderRecursive(root, inorderList);
		
		return inorderList;
	}
	
	private static void postorderRecursive(Node current, LinkedList<Node> list) {
		if(current != null) {
			postorderRecursive(current.left, list);
			postorderRecursive(current.right, list);
			list.add(current);
		}
	}
}
