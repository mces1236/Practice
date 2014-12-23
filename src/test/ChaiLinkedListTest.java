package test;

import linkedlist.ChaiLinkedList;
import basic.ChaiIterator;

public class ChaiLinkedListTest {
	public static void main(String[] args) {
		ChaiLinkedList<String> list = new ChaiLinkedList<String>();

		for(int i = 0; i < 6; i++){
			list.add("data"+i);
		}

		ChaiIterator<String> iterator = list.iterator();
		for(String data = iterator.next(); data != null; data=iterator.next()){
			System.out.println(data);
		}
		
	}
}
