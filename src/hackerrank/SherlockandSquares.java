package hackerrank;

import java.util.Scanner;

public class SherlockandSquares {

	public static void main(String[] args) {
		Scanner  sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		int[] ops = new int[t];
		for(int i = 0; i < t; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			
			int tempfirst = (int)Math.sqrt(first); 
			second = (int)Math.sqrt(second);
			
			ops[i] = Math.abs(second - tempfirst);
			
			if((tempfirst * tempfirst) == first)
				ops[i]++;
		}
		
		sc.close();
		
		for(int i = 0; i < t; i++) {
			System.out.println(ops[i]);
		}
	}

}
