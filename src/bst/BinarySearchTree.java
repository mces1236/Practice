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
			
			do {
				while (cur != null) {
					stack.push(cur);
					cur = cur.left;
				}
				
				cur = stack.pop();

				if(pre != null && pre.value > cur.value) return false;
				
				pre = cur;
				
				if (cur != null) {
					cur = cur.right;
				}
			} while (!stack.isEmpty());
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
	
	public boolean isPairPresent(int target) {
		Stack<Node> st1 = new Stack<Node>();
		Stack<Node> st2 = new Stack<Node>();
		
		Node cur1 = this.root, cur2 = this.root;
		int var1 = 0, var2 = 0;
		boolean done1 = true, done2 = true;
		
		while(true) {
			while(done1) {
				if(cur1 != null) {
					st1.push(cur1);
					cur1 = cur1.left;
				}
				else {
					if(st1.isEmpty()) {
						done1 = false;
					}
					else {
						cur1 = st1.pop();
						var1 = cur1.value;
						cur1 = cur1.right;
						done1 = false;
					}
				}
			}

			while(done2) {
				if(cur2 != null) {
					st2.push(cur2);
					cur2 = cur2.right;
				}
				else {
					if(st2.isEmpty()) {
						done2 = false;
					}
					else {
						cur2 = st2.pop();
						var2 = cur2.value;
						cur2 = cur2.left;
						done2 = false;
					}
				}
			}
			
			if(var1 != var2 && var1 + var2 == target) {
				System.out.println("sum of no.s " + var1 + " " + var2 + " = " + target);
				return true;
			}
			else if(var1 + var2 < target) done1 = true;
			else done2 = true;
			
			if(var1 >= var2) return false;
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(10);
		bst.insert(6);
		bst.insert(8);
		bst.insert(4);
		bst.insert(3);
		bst.insert(5);
		bst.insert(7);
		bst.insert(9);
		bst.insert(15);
		bst.insert(13);
		bst.insert(12);
		bst.insert(14);
		bst.insert(17);
		bst.insert(18);
		bst.insert(19);
		
		System.out.println(TreeUtils.inorder(bst.root));
		Node head = TreeUtils.createTreetoDllInorder(bst.root);
		
		while(head != null) {
			System.out.println(head + "\t" + head.left + "\t" + head.right);
			head = head.right;
		}
	}

}
