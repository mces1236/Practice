package linkedlist;

import basic.ChaiSingleNode;

public class SortedChaiLinkedList {
	ChaiLinkedList<Double> sortedLinkedList = new ChaiLinkedList<Double>();
	
	public void add(Double data){
		sortedLinkedList.add(data);
	}
	
	public boolean delete(Double data){
		if(sortedLinkedList.head != null){
			if(sortedLinkedList.head.data == data){
				sortedLinkedList.head = sortedLinkedList.head.next;
				return true;
			}
		}
		
		ChaiSingleNode<Double> temp = sortedLinkedList.head;
		
		while(temp.next != null){
			if(temp.next.data == data){
				temp.next = temp.next.next;
				return true;
			}
		}
		
		return false;
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
	
	public static ChaiLinkedList<Double> intersectionOfTwoSortedLists(ChaiLinkedList<Double> list1, ChaiLinkedList<Double> list2){
		ChaiLinkedList<Double> commonList = new ChaiLinkedList<Double>();
		ChaiSingleNode<Double> node1 = list1.head, node2 = list2.head;
		
		while(node1 != null && node2 != null){
			if(node1.data.equals(node2.data)){
				commonList.add(node1.data);
				node1 = node1.next;
				node2 = node2.next;
			}
			else if(node1.data > node2.data){
				node2 = node2.next;
			}
			else{
				node1 = node1.next;
			}
		}
		
		return commonList;
	}
	
	public static ChaiLinkedList<Double> mergeTwoSortedLists(ChaiLinkedList<Double> list1, ChaiLinkedList<Double> list2){
		ChaiLinkedList<Double> mergeList = new ChaiLinkedList<Double>();
		ChaiSingleNode<Double> node1 = list1.head, node2 = list2.head;
		
		while(node1 != null && node2 != null){
			if(node1.data.equals(node2.data)){
				mergeList.add(node1.data);
				mergeList.add(node1.data);
				node1 = node1.next;
				node2 = node2.next;
			}
			else if(node1.data > node2.data){
				mergeList.add(node2.data);
				node2 = node2.next;
			}
			else{
				mergeList.add(node1.data);
				node1 = node1.next;
			}
		}
		
		while(node1 != null){
			mergeList.add(node1.data);
			node1 = node1.next;
		}

		while(node2 != null){
			mergeList.add(node2.data);
			node2 = node2.next;
		}
		
		return mergeList;
	}
	
	public String toString(){
		return sortedLinkedList.toString();
	}
}
