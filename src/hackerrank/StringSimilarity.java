package hackerrank;

import java.util.Scanner;

public class StringSimilarity {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		sc.nextLine();

		int[] ops = new int[t];
		for(int i = 0; i < t; i++){
			String str = sc.nextLine();
			int strLen = str.length();
			int similarityScore = strLen;
			int[] sumArr = new int[strLen];
			
			int sumUntil = 0;
			for(int j = 0; j < strLen; j++) {
				sumUntil += str.charAt(j);
				sumArr[j] = sumUntil;
			}
			
			for(int j = 1; j < strLen; j++) {
				similarityScore += binarySearchSimilarity(sumArr, j, strLen);
			}
			
			ops[i] = similarityScore;
		}
		
		sc.close();
		
		for(int i = 0; i < t; i++) {
			System.out.println(ops[i]);
		}
	}
	
	static int binarySearchSimilarity(int[] sumArr, int startIndex, int length) {
		int preSimilar = 0;
		
		int start = 0, end = (length - startIndex - 1);
		int toSubstract = sumArr[startIndex-1];
		
		while(start <= end) {
			int mid = (start + end)/2;
			
			if(sumArr[mid] == (sumArr[(mid+startIndex)] - toSubstract)) {
				start = mid+1;
				preSimilar = (mid+1);
			}
			else{
				end = (mid-1);
			}
		}
		
		return preSimilar;
	}

}
