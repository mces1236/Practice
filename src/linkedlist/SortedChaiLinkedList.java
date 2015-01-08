package linkedlist;

import basic.ChaiSingleNode;

public class SortedChaiLinkedList {
	ChaiLinkedList<Double> sortedLinkedList = new ChaiLinkedList<Double>();
	
	public void add(Double data){
		sortedLinkedList.add(data);
	}
	
	public void insertInaSortedList(Double data){
		ChaiSingleNode<Double> node = new ChaiSingleNode<Double>(data);
		
		if(data < sortedLinkedList.head.data){
			node.next = sortedLinkedList.head;
			sortedLinkedList.head = node;
		}
		else{
			ChaiSingleNode<Double> temp = sortedLinkedList.head;
			while((temp.next != null && data > temp.next.data))
				temp = temp.next;
			
			node.next = temp.next;
			temp.next = node; 
		}
	}
	
	public void removeDuplicatesInaLinkedList(){
		ChaiSingleNode<Double> temp = sortedLinkedList.head;
		
		while(temp.next != null){
			if(temp.data.equals(temp.next.data))
				temp.next = temp.next.next;
			else
				temp = temp.next; 
		}
	}
	
	public String toString(){
		return sortedLinkedList.toString();
	}
	
	public static void main(String[] args) {
		SortedChaiLinkedList sortedList = new SortedChaiLinkedList();
		
		for(double d = 1.0; d < 7.0; d++){
			sortedList.add(d);
		}
		
		sortedList.insertInaSortedList(1.0);
		System.out.println(sortedList);
		sortedList.removeDuplicatesInaLinkedList();
		System.out.println(sortedList);
	}
}
