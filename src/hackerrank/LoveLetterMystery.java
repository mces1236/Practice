package hackerrank;

import java.util.Scanner;

public class LoveLetterMystery {

	public static void main(String[] args) {
		Scanner  sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		sc.nextLine();
		
		int[] ops = new int[t];
		for(int i = 0; i < t; i++) {
			String str = sc.nextLine();
			
			for(int j = 0, k = (str.length() - 1); j < k; j++, k--) {
				int diff = (int)(str.charAt(j) - str.charAt(k));
				ops[i] += Math.abs(diff);
			}
		}
		
		sc.close();
		
		for(int i = 0; i < ops.length; i++) {
			System.out.println(ops[i]);
		}
	}

}
