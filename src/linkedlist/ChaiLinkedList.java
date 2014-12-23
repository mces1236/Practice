package linkedlist;

import basic.ChaiIterator;
import basic.ChaiSingleNode;


public class ChaiLinkedList<T> {
	
	public ChaiSingleNode<T> head;
	
	public void add(T data){
		ChaiSingleNode<T> node = new ChaiSingleNode<T>(data);

		if(head == null){
			head = node;
		}
		else{
			ChaiSingleNode<T> temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	
	public ChaiIterator<T> iterator(){
		ChaiIterator<T> iterator = new ChaiIterator<T>(head);
		return iterator;
	}
	
}
