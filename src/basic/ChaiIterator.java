package basic;

public class ChaiIterator<T> {
	ChaiSingleNode<T> head;
	
	public ChaiIterator(ChaiSingleNode<T> head) {
		this.head = head;
	}
	
	public T next(){
		if(head == null) return null;
		T data = head.data;
		head = head.next;
		return data;
	}
}
