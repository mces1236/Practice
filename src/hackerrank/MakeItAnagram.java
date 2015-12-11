package hackerrank;

import java.util.Scanner;

public class MakeItAnagram {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		int[] chars = new int[26];
		
		for(int i = 0; i < str1.length(); i++) {
			char ch = str1.charAt(i);
			chars[(ch - 'a')]++;
		}
		
		int toDelete = 0;
		
		for(int i = 0; i < str2.length(); i++) {
			int index = (str2.charAt(i) - 'a');
			if(chars[index] > 0) chars[index]--;
			else toDelete++;
		}
		
		for(int i = 0; i < 26; i++) {
			if(chars[i] > 0) toDelete += chars[i];
		}
		
		sc.close();
		System.out.println(toDelete);
	}

}
