package leetcode;

public class IsPowerOfThree {

	public static void main(String[] args) {
		Bst bst = new Bst();
		bst.insert(6);
		TreeNode q = bst.insert(2);
		TreeNode p = bst.insert(8);
		bst.insert(0);
		bst.insert(4);
		bst.insert(7);
		bst.insert(9);
		bst.insert(3);
		bst.insert(5);
		
		System.out.println(new IsPowerOfThree().lowestCommonAncestor(bst.root, p, q));
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while(root != null) {
			if(p.val < root.val && q.val < root.val) {
				root = root.left;
			} else if(p.val > root.val && q.val > root.val) {
				root = root.right;
			} else {
				break;
			}
		}
		
		return root;
    }
}
