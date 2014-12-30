package basic;

public class ChaiSingleNode<T> {
	public T data;
	public ChaiSingleNode<T> next;
	
	public ChaiSingleNode(T data) {
		this.data = data;
		next = null;
	}
	
	public String toString(){
		return (this.data + "");
	}
}
