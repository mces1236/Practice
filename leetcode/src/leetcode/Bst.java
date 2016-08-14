package leetcode;

public class Bst {
	public TreeNode root = null;
	
	public TreeNode insert(int value) {
		if(root == null) {
			root = new TreeNode(value);
		} else {
			TreeNode temp = root, pre = null;
			
			while(temp != null) {
				pre = temp;
				if(value < temp.val) temp = temp.left;
				else temp = temp.right;
			}
			
			if(pre != null) {
				TreeNode cur = new TreeNode(value);
				if(value < pre.val) {
					pre.left = cur;
				} else {
					pre.right = cur;
				}
				return cur;
			}
		}
		
		return null;
	}
}
