package binarytree;

public class BinaryTreeWithRandomPointers {

	NodeWithRandomPointer root = null;
	
	public BinaryTreeWithRandomPointers(int value) {
		root = new NodeWithRandomPointer(value);
	}
	
	public BinaryTreeWithRandomPointers(NodeWithRandomPointer root) {
		this.root = root;
	}
	
	public static void main(String[] args) {
		BinaryTreeWithRandomPointers realTree = new BinaryTreeWithRandomPointers(1);
		
		NodeWithRandomPointer node1 = realTree.root;
		NodeWithRandomPointer node2 = new NodeWithRandomPointer(2);
		NodeWithRandomPointer node3 = new NodeWithRandomPointer(3);
		NodeWithRandomPointer node4 = new NodeWithRandomPointer(4);
		NodeWithRandomPointer node5 = new NodeWithRandomPointer(5);
		NodeWithRandomPointer node7 = new NodeWithRandomPointer(7);
		
		node1.random = node3;
		node3.random = node7;
		node4.random = node1;
		node5.random = node2;
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node5.right = node7;
		
		BinaryTreeWithRandomPointers clonedTree = realTree.clone();
		
		clonedTree.inorder(clonedTree.root);
	}
	
	private void inorder(NodeWithRandomPointer cur) {
		if (cur != null) {
			inorder(cur.left);
			System.out.print(cur + " ");
			inorder(cur.right);
		}
	}

	public BinaryTreeWithRandomPointers clone() {
		createRedundantNodes(root);
		assignRandomPointers(root);
		NodeWithRandomPointer cloneRootNode = seperateTrees();
		BinaryTreeWithRandomPointers randomBinTree = new BinaryTreeWithRandomPointers(cloneRootNode);
		return randomBinTree;
	}

	private NodeWithRandomPointer seperateTrees() {
		NodeWithRandomPointer clonedRoot = root.right;
		seperateTrees(root);
		return clonedRoot;
	}
	
	private void seperateTrees(NodeWithRandomPointer cur) {
		if (cur != null) {
			seperateTrees(cur.left);
			cur.right = cur.right.right;
			seperateTrees(cur.right);
		}
	}

	private void assignRandomPointers(NodeWithRandomPointer cur) {
		if (cur != null) {
			assignRandomPointers(cur.left);
			
			if (cur.random != null)
				cur.right.random = cur.random.right;
			
			if (cur.left != null)
				cur.right.left = cur.left.right;
			
			assignRandomPointers(cur.right.right);
		}
	}

	private void createRedundantNodes(NodeWithRandomPointer cur) {
		if (cur != null) {
			createRedundantNodes(cur.left);
			createRedundantNodes(cur.right);
			NodeWithRandomPointer temp = cur.right;
			cur.right = new NodeWithRandomPointer(cur.value);
			cur.right.right = temp;
		}
	}
	
}
