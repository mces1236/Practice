package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Sudoku {

	public static void main(String[] args) {
		
		System.out.println(multiply(10.0, 11.0));
		
		System.exit(0);

		LinkedList<String> list = new LinkedList<String>();
		list.addLast("..5.....6");
		list.addLast("....14...");
		list.addLast(".........");
		list.addLast(".....92..");
		list.addLast("5....2...");
		list.addLast(".......3.");
		list.addLast("...54....");
		list.addLast("3.....42.");
		list.addLast("...27.6..");
		System.out.println(new Sudoku().isValidSudoku(list));
	}
	
	public static Double multiply(Double a, Double b) {
		return a * b;
	}

	public int isValidSudoku(final List<String> a) {

		char[][] board = new char[9][9];

		int i = 0;
		for(String str : a)
			board[i++] = str.toCharArray();

		if(isValidSudoku(board)) return  1;

		return 0;
	}

	public boolean isValidSudoku(char[][] board) {

		HashSet<String> set = new HashSet<String>();

		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				char ele = board[i][j];

				if(ele == '.') continue;

				String str = "c," + i + ",0," + ele;
				if(set.contains(str)) 
					return false;
				set.add(str);

				str = "r,0," + j + "," + ele;
				if(set.contains(str)) 
					return false;
				set.add(str);

				str = "s-" + (i/3) + "-" + (j/3) + "-" + ele;
				if(set.contains(str)) 
					return false;
				set.add(str);
			}
		}

		return true;
	}
}
