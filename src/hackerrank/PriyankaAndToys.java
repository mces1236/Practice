package hackerrank;

import java.util.Scanner;

public class PriyankaAndToys {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] weights = new int[n];
		for(int i = 0; i < n; i++) {
			weights[i] = sc.nextInt();
		}
		
		sort(weights);
		
		int unitsbrought = 1, toSkip = weights[0] + 5;
		for(int i = 1; i < weights.length; i++) {
			if(toSkip > weights[i]) continue;
			unitsbrought++;
			toSkip = weights[i] + 5;
		}
		
		sc.close();
		
		System.out.println(unitsbrought);
		
	}
	
	public static void sort(int[] ar) {
		for(int i = 1; i < ar.length; i++) {
			
			int temp = ar[i], toInsertIndex = i;
			
			for(int j = (i - 1); j >= 0; j--){
			
				if(temp > ar[j]) {
					break;
				}
				
				ar[j+1] = ar[j];
				toInsertIndex--;
			}
			
			ar[toInsertIndex] = temp;
		}
	}

}
