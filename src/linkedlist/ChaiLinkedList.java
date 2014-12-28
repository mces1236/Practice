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
	
	public T nthNodeFromEnd(int n){
		ChaiSingleNode<T> temp, nthNode;
		temp = nthNode = head;
		
		int size = size();
		if(n > size) return null;
		
		for(int i = 0; i < n; i++){
			nthNode = nthNode.next;
		}
		
		for(;nthNode != null; nthNode = nthNode.next){
			temp = temp.next;
		}
		
		return temp.data;
	}

	public int size() {
		int size = 0;
		for(ChaiSingleNode<T> temp = head; temp != null; temp = temp.next){
			size++;
		}
		return size;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		ChaiIterator<T> iterable = iterator();
		for(T data = iterable.next(); data != null; data = iterable.next()){
			sb.append(data);
		}
		return sb.toString();
	}
}
