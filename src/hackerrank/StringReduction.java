package hackerrank;

import java.util.Scanner;

import com.sun.org.apache.xml.internal.security.keys.storage.StorageResolverException;

public class StringReduction {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		int[] ops = new int[t];
		for(int i = 0; i < t; i++){
			StringBuffer str = new StringBuffer(sc.nextLine());

			int strlen = 0;
			for(int j = 0; i < (str.length()-1); j++) {
				char fir = str.charAt(j);
				char sec = str.charAt(j+1);
				int diff = fir - sec;

				switch(diff) {
				case 0 : strlen++; break;
				case 1 : 
					if((fir == 'a' && sec == 'b') || (fir == 'b' && sec == 'a')) {
						str.insert((j+1), 'c');
					}
					else if((fir == 'b' && sec == 'c') || (fir == 'c' && sec == 'b')) {
						str.insert((j+1), 'a');
					}
					break;
				case 2 :
					str.insert((j+1), 'b');
					break;
				}
			}
			ops[i] = strlen+1;
		}

		sc.close();

		for(int i = 0; i < ops.length; i++)
			System.out.println(ops[i]);
	}

}
