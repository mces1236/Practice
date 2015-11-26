package hackerrank;

import java.util.Scanner;

public class MarkAndToys {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int noOfProducts = sc.nextInt();
		
		int totalAmount = sc.nextInt();
		
		int[] pricesOfProducts = new int[noOfProducts];
		
		for(int i = 0; i < noOfProducts; i++) {
			pricesOfProducts[i] = sc.nextInt();
		}
		
		sort(pricesOfProducts);
		
		int countOfProductsBrought = 0;
		for(int i = 0; i < noOfProducts; i++) {
			if(totalAmount < pricesOfProducts[i])
				break;
			
			totalAmount -= pricesOfProducts[i];
			countOfProductsBrought++;
		}
				
		sc.close();
		
		System.out.println(countOfProductsBrought);
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
