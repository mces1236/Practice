package hackerrank;

import java.util.Scanner;

public class ChoclateFeast {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int nftcs = sc.nextInt();
		
		int[] ops = new int[nftcs];
		
		for(int  i = 0; i < nftcs; i++) {
			int n = sc.nextInt();
			int c = sc.nextInt();
			int m = sc.nextInt();
			
			int cb = n/c;
			
			int cwl = cb;
			
			do {
				int cfw = cwl/m;
				cb+=cfw;
				
				int wrapLeft = cwl % m;

				cwl = cfw + wrapLeft;
			}while(cwl >= m);
			
			ops[i] = cb;
		}
		
		sc.close();

		for(int i = 0; i < nftcs; i++) {
			System.out.println(ops[i]);
		}
	}

}
