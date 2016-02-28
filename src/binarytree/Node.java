package binarytree;

public class Node {
	public Integer value;
	public Node left, right;
	
	public Node(Integer value) {
		this.value = value;
		left = right = null;
	}
	
	@Override
	public String toString() {
		if(value != null)
			return Integer.toString(value);
		return null;
	}
}
