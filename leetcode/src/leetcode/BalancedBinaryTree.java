package leetcode;

public class BalancedBinaryTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);

		TreeNode l1l = new TreeNode(9);
		TreeNode l1r = new TreeNode(20);
//
		root.left = l1l;
		root.right = l1r;
//
//		TreeNode l2fl = new TreeNode(10);
//		TreeNode l2fr = new TreeNode(11);
//
//		l1l.left = l2fl;
//		l1l.right = l2fr;

		TreeNode l2sl = new TreeNode(15);
		TreeNode l2sr = new TreeNode(7);

		l1r.left = l2sl;
		l1r.right = l2sr;

		TreeNodeUtils.printTree(root);

		System.out.println(new BalancedBinaryTree().isBalanced(null));
	}

	public boolean isBalanced(TreeNode root) {
		if(isBalancedBT(root) == -1) return false;
		return true;
	}

	public int isBalancedBT(TreeNode root) {
		if(root != null) {
			int left = isBalancedBT(root.left);
			int right = isBalancedBT(root.right);

			if(left == -1 || right == -1) return -1;
			if(Math.abs((left - right)) <= 1) return (1 + Math.max(left, right));

			return -1;
		}

		return 0;
	}
}
