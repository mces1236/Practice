package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import binarytree.Node;
import binarytree.NodePointer;

public class TreeUtils {

	public static LinkedList<Node> bfs(Node root) {

		LinkedList<Node> bfsList = new LinkedList<Node>(); 

		if (root == null) return bfsList;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while(!queue.isEmpty()) {

			Node current = queue.remove();
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
	
	public static void bfsLevelWise(Node root) {

		if (root == null) return;
		
		int elementsInThisLevel = 0;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		elementsInThisLevel++;

		while(!queue.isEmpty()) {

			Node current = queue.remove();
			System.out.print(current.value + " ");
			
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
			
			elementsInThisLevel--;
			if (elementsInThisLevel == 0) {
				System.out.println();
				elementsInThisLevel = queue.size();
			}
		}
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
	
	public static LinkedList<Node> inorderWithoutRecursion(Node node) {
		LinkedList<Node> list = new LinkedList<Node>();
		
		if (node == null) return list;
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		
		while (!stack.isEmpty()) {
			while (node != null && node.left != null) {
				stack.push(node.left);
				node = node.left;
			}
			
			node = stack.pop();
			list.add(node);
			
			if (node != null && node.right != null) {
				stack.push(node.right);
				node = node.right;
			}
		}
		
		return list;
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
	
	public static int size(Node cur) {
		if(cur != null) return (1 + size(cur.left) + size(cur.right));
		else return 0;
	}
	
	public static int height(Node cur) {
		if(cur != null) {
			int lh = height(cur.left);
			int rh = height(cur.right);
			
			if(lh > rh) return (lh + 1);
			return (rh + 1);
		}
		
		return 0;
	}
	
	public static boolean identicalTrees(Node n1, Node n2) {
		if(n1 == null && n2 == null) return true;
		if(n1 == null || n2 == null) return false;
		return ((n1.value == n2.value) && (identicalTrees(n1.left, n2.left)) && (identicalTrees(n1.right, n2.right)));
	}
	
	public static Boolean inorderPredecessorAndSuccessor(Node cur, NodePointer pre, NodePointer suc, int ele) {
		if(cur != null) {
			boolean found = inorderPredecessorAndSuccessor(cur.left, pre, suc, ele);
			if(found) return found;
			if (cur.value == ele) {
				suc.node = getLeftMostNode(cur.right);
				return true;
			} else {
				pre.node = cur;
			}
			
			return inorderPredecessorAndSuccessor(cur.right, pre, suc, ele);
		}else {
			return false;
		}
	}

	private static Node getLeftMostNode(Node cur) {
		while(cur != null) cur = cur.left;
		return cur;
	}
}
