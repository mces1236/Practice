package hackerrank;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class IcecreamParlor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int noOfTestCases = sc.nextInt();
		
		List<Pair> ops = new ArrayList<Pair>();
		
		for(int i = 0; i < noOfTestCases; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			
			boolean found = false;
			Hashtable<Integer, Integer> eleIndex = new Hashtable<Integer, Integer>();
			for(int j = 0; j < n; j++) {
				int currentNumber = sc.nextInt();
				int toFind = m - currentNumber;
				
				if(eleIndex.containsKey(toFind) && !found) {
					found = true;
					int firstIndex = eleIndex.get(toFind);
					Pair pair = new Pair((firstIndex+1), (j+1));
					ops.add(pair);
				}
				eleIndex.put(currentNumber, j);
			}
		}
		
		sc.close();
		
		for(Pair pair : ops) {
			System.out.println(pair.first + " " + pair.second);
		}
	}

}

class Pair {
	public int first, second;
	
	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
