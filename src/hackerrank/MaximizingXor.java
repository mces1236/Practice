package hackerrank;

import java.util.Scanner;

public class MaximizingXor {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		int r = sc.nextInt();
		
		int max = 0;
		for(int i = l; i <=r; i++){
			for(int j = i; j<=r; j++){
				int xor = i ^ j;
				
				if(xor > max) {
					max = xor;
				}
			}
		}
		
		sc.close();
		
		System.out.println(max);
	}

}
