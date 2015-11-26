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
			int cfw = cb/m;
			
			int wrapLeft = cb % m;
			
			int chocForLeftWraps = ((wrapLeft + cfw) / m);
			
			int totalWrapsLeft = (chocForLeftWraps/m);
			
			ops[i] = (cb + cfw + chocForLeftWraps + totalWrapsLeft);
		}
		
		sc.close();
		for(int i = 0; i < nftcs; i++) {
			System.out.println(ops[i]);
		}
	}

}
