package test;

import basic.ChaiSingleNode;
import linkedlist.ChaiLinkedList;

public class ChaiLinkedListTest {
	public static void main(String[] args) {
		ChaiLinkedList<Integer> list = new ChaiLinkedList<Integer>();

		for(int i = 1; i < 3; i++){
			list.add(i);
		}
		for(int i = 2; i > 0; i--){
			list.add(i);
		}
		
		ChaiSingleNode<Integer> middle = list.getMiddle();
		System.out.println(middle.data);
		middle = list.reverse(middle);
		System.out.println(list.toString(middle));
	}
}
