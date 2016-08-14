package leetcode;

import java.util.Stack;

public class MyQueue {
	
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	addS1toS2();
        if(!s2.isEmpty())
        	s2.pop();
    }

    // Get the front element.
    public int peek() {
    	addS1toS2();
    	if(!s2.isEmpty())
        	return s2.peek();
    	
    	return -1;
    }

    // Return whether the queue is empty.
    public boolean empty() {
    	addS1toS2();
    	return s2.isEmpty();
    }
    
    public void addS1toS2() {
    	if(s2.isEmpty()) {
        	while(!s1.isEmpty()) {
        		s2.push(s1.pop());
        	}
        }
    }
    
    public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.push(10);
		q.push(20);
		System.out.println(q.empty());
		System.out.println(q.peek());
		q.pop();
		System.out.println(q.peek());
		q.pop();
		System.out.println(q.peek());
		q.pop();
		
		q.push(30);
		q.push(40);
		
		System.out.println(q.peek());
		q.pop();
		System.out.println(q.peek());
		q.pop();
		System.out.println(q.peek());
		q.pop();
    }
}
