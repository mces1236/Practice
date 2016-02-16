package hackerrank;

import java.util.Scanner;

public class StringReduction {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		sc.nextLine();

		int[] ops = new int[t];
		for(int i = 0; i < t; i++){
			StringBuffer str = new StringBuffer(sc.nextLine());
			StringBuffer temp = new StringBuffer();
			
			boolean hasChanged = true;
			int sum = (int)('a' + 'b' + 'c');
			
			while(hasChanged) {
				for(int j = 0; j < (str.length()-1); j++) {
					char cur = str.charAt(j);
					char next = str.charAt(j+1);
				}
			}
			
		}

		sc.close();

		for(int i = 0; i < ops.length; i++)
			System.out.println(ops[i]);
	}

}
