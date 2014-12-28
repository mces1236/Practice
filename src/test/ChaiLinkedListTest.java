package test;

import linkedlist.ChaiLinkedList;

public class ChaiLinkedListTest {
	public static void main(String[] args) {
		ChaiLinkedList<Integer> list = new ChaiLinkedList<Integer>();

		for(int i = 0; i < 6; i++){
			list.add(i);
		}
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.nthNodeFromEnd(1));
	}
}
