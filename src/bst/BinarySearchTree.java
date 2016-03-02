package bst;

import java.util.Stack;

import tree.TreeUtils;
import binarytree.Node;
import binarytree.NodePointer;

public class BinarySearchTree {

	Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public Node insert(int ele) {
		if(root == null) {
			root = new Node(ele);
			return root;
		}
		else {
			Node cur = root, par = null;
			
			while(cur != null) {
				par = cur;
				if(cur.value == ele) return null;
				else if(cur.value > ele) cur = cur.left;
				else cur = cur.right;
			}
			
			Node insertedNode = new Node(ele);
			if (par.value < ele) par.right = insertedNode;
			else par.left = insertedNode;
			
			return insertedNode;
		}
	}
	
	public boolean isBst() {
		if(root == null) return true;
		else {
			Node cur = root, pre = null;
			
			Stack<Node> stack = new Stack<Node>();
			stack.push(cur);
			
			while (!stack.isEmpty()) {
				while (cur.left != null) {
					stack.push(cur.left);
					cur = cur.left;
				}
				
				cur = stack.pop();

				if(pre != null && pre.value > cur.value) return false;
				
				pre = cur;
				
				if (cur.right != null) {
					stack.push(cur.right);
					cur = cur.right;
				}
			}
		}
		
		return true;
	}
	
	public void correctSwappedNodes(Node cur, NodePointer pre, NodePointer node1, NodePointer node2) {
		if(cur != null) {
			correctSwappedNodes(cur.left, pre, node1, node2);
			
			if(pre.node != null && pre.node.value > cur.value) {
				if(node1.node == null) {
					node1.node = pre.node;
					node2.node = cur;
				}
				else {
					node2.node = cur;
				}
			}
			pre.node = cur;
				
			correctSwappedNodes(cur.right, pre, node1, node2);
		}
	}
	
	public void correctSwappedNodes(Node cur) {
		NodePointer n1 = new NodePointer();
		NodePointer n2 = new NodePointer();
		NodePointer pre = new NodePointer();
		correctSwappedNodes(cur, pre, n1, n2);
		int temp = n1.node.value;
		n1.node.value = n2.node.value;
		n2.node.value = temp;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(10).right = new Node(8);
		bst.insert(5).right = new Node(20);
		bst.insert(2);
		
//		bst.insert(8).right = new Node(2);
//		bst.insert(5);
//		bst.insert(18);
//		bst.insert(3);
//		bst.insert(5);
//		bst.insert(11);
//		bst.insert(14);
//		bst.insert(17);
//		bst.insert(19);
		
		System.out.println(bst.isBst());
		System.out.println(TreeUtils.inorder(bst.root));
		bst.correctSwappedNodes(bst.root);
		System.out.println(TreeUtils.inorder(bst.root));
	}

}
