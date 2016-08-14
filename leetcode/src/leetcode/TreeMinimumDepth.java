package leetcode;

public class TreeMinimumDepth {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);

		TreeNode l1l = new TreeNode(9);
		TreeNode l1r = new TreeNode(20);

//		root.left = l1l;
//		root.right = l1r;

		TreeNode l2fl = new TreeNode(10);
		TreeNode l2fr = new TreeNode(11);

		l1l.left = l2fl;
		l1l.right = l2fr;

		TreeNode l2sl = new TreeNode(15);
		TreeNode l2sr = new TreeNode(7);

//		l1r.left = l2sl;
//		l1r.right = l2sr;

		TreeNodeUtils.printTree(root);
		System.out.println(new TreeMinimumDepth().minDepth(root));
	}

	
	public int minDepth(TreeNode root) {
		if(root != null) {
			if(root.left == null && root.right == null) return 1;
			int left = minDepth(root.left);
			int right = minDepth(root.right);
			if(left == 0) return right + 1;
			if(right == 0) return left + 1;
			return (1 + Math.min(left, right));
		}
		return 0;
	}
}
