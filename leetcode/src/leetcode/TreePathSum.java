package leetcode;

public class TreePathSum {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(-2);
		
		TreeNode l1l = new TreeNode(4);
		TreeNode l1r = new TreeNode(-3);

//		root.left = l1l;
		root.right = l1r;
		
		TreeNode l2fl = new TreeNode(11);
		
//		l1l.left = l2fl;
		
		TreeNode l2sl = new TreeNode(13);
		TreeNode l2sr = new TreeNode(4);
		
//		l1r.left = l2sl;
//		l1r.right = l2sr;
		
		TreeNode l3fl = new TreeNode(7);
		TreeNode l3fr = new TreeNode(2);
		
		l2fl.left = l3fl;
		l2fl.right = l3fr;
		
		TreeNode l3tr = new TreeNode(1);
		l2sr.right = l3tr;
		
		TreeNodeUtils.printTree(root);

		System.out.println(new TreePathSum().hasPathSum(root, -5));
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		
		if(root != null) {
			sum -= root.val;
			if(hasPathSum(root.left, sum)) return true;
			if(root.left == null && root.right == null && sum == 0) return true;
			if(hasPathSum(root.right, sum)) return true;
		}
		
		return false;
	}

}
