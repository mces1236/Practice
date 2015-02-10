package test;

import linkedlist.SortedChaiLinkedList;


public class ChaiLinkedListTest {
	public static void main(String[] args) {
		SortedChaiLinkedList list = new SortedChaiLinkedList();
		list.add(3.0);list.add(5.0);list.add(7.0);
		list.sortEvenandOddElements();
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
