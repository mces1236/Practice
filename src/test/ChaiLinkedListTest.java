package test;

import linkedlist.ChaiLinkedList;


public class ChaiLinkedListTest {
	public static void main(String[] args) {
		ChaiLinkedList<Double> list = new ChaiLinkedList<Double>();
		
		for(double d = 1.0; d < 3.0; d++){
			list.add(d);
		}
		
		System.out.println(list);
		list.interchangeFirstandLast();
		System.out.println(list);
	}
}
