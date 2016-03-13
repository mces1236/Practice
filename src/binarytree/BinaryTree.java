package binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeUtils;

public class BinaryTree {

	Node root = null;
	
	public BinaryTree(int rootValue) {
		this.root = new Node(rootValue);
	}
	
	public BinaryTree() {
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
	
	public BinaryTree constructBinaryTreeFromInPreTraversals(int[] inorder, int[] preorder) {
		BinaryTree bt = new BinaryTree();
		int[] preIndex = new int[1];
		bt.root = constBTFromInPreTrav(inorder, preorder, preIndex, 0, inorder.length);
		return bt;
	}
	
	private Node constBTFromInPreTrav(int[] inorder, int[] preorder, int[] preIndex, int inStart, int inEnd) {
		if(inStart < inEnd) {
			int root = preorder[preIndex[0]++];
			int rootIndex = getIndexOfElement(root, inorder, inStart, inEnd);
			Node curNode = new Node(root);
			curNode.left = constBTFromInPreTrav(inorder, preorder, preIndex, inStart, rootIndex);
			curNode.right = constBTFromInPreTrav(inorder, preorder, preIndex, (rootIndex + 1), inEnd);
			return curNode;
		}
		return null;
	}

	private int getIndexOfElement(int cur, int[] inorder, int inStart, int inEnd) {
		for(int i = inStart; i < inEnd; i++) {
			if(cur == inorder[i]) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(1);
		
		for(int i = 2; i < 10; i++)
			bt.insert(i);
		
		LinkedList<Node> inorder = TreeUtils.inorder(bt.root);
		LinkedList<Node> preorder = TreeUtils.preorder(bt.root);
		
		System.out.println(inorder + "\n" + preorder);
		
		int[] in = new int[inorder.size()];
		int[] pre = new int[inorder.size()];
		
		int i = 0;
		for(Node node : inorder) in[i++] = node.value;
		i = 0;
		for(Node node : preorder) pre[i++] = node.value;
		
		BinaryTree cBt = bt.constructBinaryTreeFromInPreTraversals(in, pre);
		System.out.println(TreeUtils.inorder(cBt.root));
	}

}
