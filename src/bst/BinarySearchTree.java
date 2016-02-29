package bst;

import java.util.LinkedList;
import java.util.Stack;

import tree.TreeUtils;
import binarytree.Node;

public class BinarySearchTree {

	Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public Node insert(int ele) {
		if(root == null) {
			root = new Node(ele);
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
		return null;
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
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(10);
		bst.insert(6);
		bst.insert(15);
		bst.insert(4);
		bst.insert(8).right = new Node(2);
		bst.insert(13);
		bst.insert(18);
		bst.insert(3);
		bst.insert(5);
		bst.insert(11);
		bst.insert(14);
		bst.insert(17);
		bst.insert(19);
		
		System.out.println(bst.isBst());
		System.out.println(TreeUtils.inorder(bst.root));
	}

}
