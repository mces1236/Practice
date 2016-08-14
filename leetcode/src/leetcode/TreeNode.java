package leetcode;

public class TreeNode {
	int val;
	TreeNode left, right;
	
	public TreeNode(int x) {
		this.val = x;
		this.left = this.right = null;
	}
	
	@Override
	public String toString() {
		return val+"";
	}
}
