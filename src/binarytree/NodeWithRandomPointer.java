package binarytree;

public class NodeWithRandomPointer {
	int value;
	NodeWithRandomPointer left,right,random;
	
	public NodeWithRandomPointer(int value) {
		this.value = value;
		left = right = random = null;
	}
	
	public String toString() {
		String toReturn = new String(Integer.toString(this.value));
		
		if(this.random != null)
			toReturn += " " + this.random.value;
		
		return toReturn;
	}
}
