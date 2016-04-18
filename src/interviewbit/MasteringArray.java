package interviewbit;

import java.util.Scanner;

public class MasteringArray {

	public static void main(String[] args) {
		MasteringArray ma = new MasteringArray();
		ma.computeArray();
	}
	
	private void computeArray() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arraySize = ((2 * n) -1);
		
		for(int i = 0; i < arraySize; i++) {
			for(int j = 0; j < arraySize; j++) {
				System.out.print((Math.max(Math.abs((i - (n - 1))), Math.abs((j - (n - 1)))) + 1) + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
