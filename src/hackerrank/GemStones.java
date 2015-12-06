package hackerrank;

import java.util.Scanner;

public class GemStones {

	public static void main(String[] args) {
		Scanner  sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		int[] alphabets = new int[26];
		for(int i = 0; i < n; i++) {
			String str = sc.nextLine();
			
			boolean[] uniqueEles = new boolean[26];
			for(int j = 0; j < str.length(); j++) {
				int index = str.charAt(j) - 'a';
				if(!uniqueEles[index]) {
					alphabets[index]++;
					uniqueEles[index] = true;
				}
			}
		}
		
		sc.close();
		
		int gemEles = 0;
		for(int i = 0; i < 26; i++){
			if (alphabets[i] == n) {
				gemEles++;
			}
		}
		
		System.out.println(gemEles);
	}

}
