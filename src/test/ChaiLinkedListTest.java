package test;

import linkedlist.ChaiLinkedList;


public class ChaiLinkedListTest {
	public static void main(String[] args) {
		ChaiLinkedList<Double> list = new ChaiLinkedList<Double>();
		
		for(double d = 1.0; d < 10.0; d++){
			list.add(d);
		}
		
		System.out.println(list);
		list.reverseEveryAlternateKNodes(3);
		System.out.println(list);
		
//		ChaiLinkedList<Double> list1 = new ChaiLinkedList<Double>();
//		
//		for(double d = 1.0; d < 10.0;  d=d+2.0){
//			list1.add(d);
//		}
		
//		System.out.println(list1);
		
//		System.out.println(SortedChaiLinkedList.mergeTwoSortedLists(list, list1));
	}
}
