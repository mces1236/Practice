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

			int strlen = str.length(), cur = (strlen - 1), toDel = 0, sum = 'a' + 'b' + 'c';
			
			while(cur > 0) {
				char curChar = str.charAt(cur);
				char preChar = str.charAt((cur-1));
				
				if (curChar == preChar) {
					toDel++;
					cur--;
				}
				else {
					char toInsert = (char)(sum - (curChar + preChar));
					str.setCharAt((cur-1), toInsert);
					strlen--;
					
					if(toDel > 0) toDel--;
					else cur--;
				}
			}
			
			ops[i] = strlen;
		}

		sc.close();

		for(int i = 0; i < ops.length; i++)
			System.out.println(ops[i]);
	}

}
