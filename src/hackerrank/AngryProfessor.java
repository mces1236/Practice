package hackerrank;

import java.util.Scanner;

public class AngryProfessor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int noOfTestCases = sc.nextInt();
		
		boolean[] ops = new boolean[noOfTestCases];
		
		for(int i = 0; i < noOfTestCases; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			for(int j = 0; j < n; j++) {
				int arrivalTime = sc.nextInt();
				if(arrivalTime<=0) k--;
				
				if(k == 0 && !ops[i]) ops[i] = true; 
			}
		}
		
		sc.close();
		
		for(int i = 0; i < noOfTestCases; i++)
			if(ops[i])
				System.out.println("NO");
			else
				System.out.println("YES");
	}

}
