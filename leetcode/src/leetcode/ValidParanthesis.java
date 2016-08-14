package leetcode;

import java.util.Scanner;
import java.util.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {
		System.out.println(new ValidParanthesis().isValid("[(5+4)]"));
	}

	public Character getOppositeParanthesis(Character key) {
		switch (key) {
		case '{' : return '}';
		case '(' : return ')';
		case '[' : return ']';

		default : return null;
		}
	}

	public int isValid(String s) {

		if(s != null) {
			int len = s.length();

			Stack<Character> stack = new Stack<Character>();

			for(int i = 0; i < len; i++) {
				Character ch = s.charAt(i);
				
				if(!(ch == '[' || ch == ']' || ch == '{' || ch == '}' || ch == '(' || ch == ')')) continue;
				
				Character och = getOppositeParanthesis(ch);
				
				if(och != null) stack.push(och);
				else {
					if(stack.isEmpty()) return 0;
					
					och = stack.pop();
					
					if(ch != och) return 0;
				}
			}
			
			if(!stack.isEmpty()) return 0;
		}

		return 1;
	}
}
