package hackerrank;

import java.util.Scanner;

public class TwoArrays {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int noOfTestCases = sc.nextInt();
		
		boolean[] isSumEquals = new boolean[noOfTestCases];
		
		for(int i = 0 ; i < noOfTestCases; i++) {
			int noOfElements = sc.nextInt();
			int k = sc.nextInt();
			
			int[] first = new int[noOfElements];
			int[] second = new int[noOfElements];			
			
			for(int j = 0; j < noOfElements; j++) {
				first[j] = sc.nextInt();
			}
			
			for(int j = 0; j < noOfElements; j++) {
				second[j] = sc.nextInt();
			}
			
			sort(first);
			sort(second);
			
			Boolean doesSumEquals = checkForSum(first, second, k);
			
			isSumEquals[i] = doesSumEquals;
		}
		
		for(boolean doesSumEquals : isSumEquals) {
			if(doesSumEquals) System.out.println("YES");
			else System.out.println("NO");
		}
		
		sc.close();
	}
	
	private static Boolean checkForSum(int[] first, int[] second, int k) {
		
		int n = first.length;
		
		int i = 0, j = (n-1);
		
		for(; i < n; i++, j--) {
			if(!((first[i] + second[j]) >= k))
				break;
		}
		
		if(i == n) {
			return true;
		}
		
		return false;
	}

	public static void sort(int[] ar) {
		for(int i = 1; i < ar.length; i++) {
			
			int temp = ar[i], toInsertIndex = i;
			
			for(int j = (i - 1); j >= 0; j--){
			
				if(temp < ar[j]) {
					break;
				}
				
				ar[j+1] = ar[j];
				toInsertIndex--;
			}
			
			ar[toInsertIndex] = temp;
		}
	}
}
