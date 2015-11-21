package hackerrank;

import java.util.Scanner;

public class ServiceLane {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int t = sc.nextInt();
		
		int[] width = new int[n];
		
		for(int i = 0; i < n ;i++) {
			width[i] = sc.nextInt();
		}
		
		int[] op = new int[t];
		
		for(int i = 0; i < t; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			int min = Integer.MAX_VALUE;
			while(start <= end) {
				if(width[start] < min) {
					min = width[start];
				}
				start++;
			}
			
			op[i] = min;
		}
		
		for(int i = 0; i < t; i++) {
			System.out.println(op[i]);
		}
		
		sc.close();
	}
}
