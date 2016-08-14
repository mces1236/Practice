package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {
		System.out.println(new PascalsTriangle().generate(7));
		System.out.println(new PascalsTriangle().getRow(7));
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pt = new ArrayList<List<Integer>>();

		if(numRows == 0) return pt;

		LinkedList<Integer> fr = new LinkedList<Integer>();
		fr.add(1);
		pt.add(fr);

		if(numRows == 1) return pt;

		LinkedList<Integer> sr = new LinkedList<Integer>();
		sr.add(1);sr.add(1);
		pt.add(sr);

		if(numRows == 2) return pt;

		int[] preRow = {1,1};

		numRows -= 2;

		while(numRows > 0) {
			int len = preRow.length;

			int[] curArr = new int[len + 1];
			LinkedList<Integer> curList = new LinkedList<Integer>();
			curList.add(preRow[0]);
			curArr[0] = preRow[0];


			for(int i = 0; i < len - 1; i++) {
				int sum = preRow[i] + preRow[i+1];
				curList.add(sum);
				curArr[i + 1] = sum;
			}

			curList.add(preRow[len - 1]);
			curArr[len] = preRow[len - 1];

			numRows--;

			preRow = curArr;
			pt.add(curList);
		}

		return pt;
	}

	public List<Integer> getRow(int rowIndex) {
		rowIndex++;
		List<Integer> pt = new ArrayList<Integer>();

		if(rowIndex == 0) return pt;

		LinkedList<Integer> fr = new LinkedList<Integer>();
		fr.add(1);

		if(rowIndex == 1) return fr;

		LinkedList<Integer> sr = new LinkedList<Integer>();
		sr.add(1);sr.add(1);

		if(rowIndex == 2) return sr;

		int[] preRow = new int[rowIndex];
		
		preRow[0] = preRow[1] = 1;
		
		int tempCount = rowIndex - 2;

		for(int i = 2; i < rowIndex; i++)
			preRow[i] = 0;

		while(tempCount > 0) {
			int len = rowIndex - tempCount;
			
			int last = preRow[len - 1], pre = preRow[0];
			
			for(int i = 1; i < len; i++) {
				int sum = preRow[i] + pre;
				pre = preRow[i];
				preRow[i] = sum;
			}

			preRow[len] = last;

			tempCount--;
		}

		for(int i = 0; i < rowIndex; i++)
			pt.add(preRow[i]);

		return pt;
	}
}
