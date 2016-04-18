package heamazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GCDSum {

	public static void main(String[] args) {
		GCDSum g = new GCDSum();
	
		g.computeGCDSum();
	}

	public void computeGCDSum() {
		
		Scanner sc = new Scanner(System.in);
		
		int noOfTestCases = sc.nextInt();
		
		int[] ops = new int[noOfTestCases];
		
		for(int i = 0; i < noOfTestCases; i++) {
			ops[i] = sc.nextInt();
		}
		
		int queriesSize = sc.nextInt();
		
		Map<Integer, Integer> gcdsmap = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < noOfTestCases; i++) {
			int ele = ops[i];
			if(!gcdsmap.containsKey(ele)) {
				int gcd = computeGCDSum(ele);
				gcdsmap.put(ele, gcd);
			}
		}
		sc.nextLine();
		
		
		List<Integer> results = new ArrayList<Integer>();
		
		for(int i = 0; i < queriesSize; i++) {
			String query = sc.nextLine();
			String[] splits = query.split(" ");
			int start = Integer.parseInt(splits[1]);
			int end = Integer.parseInt(splits[2]);
			
			if(splits[0].equals("C")) {
				int sum = 0;
				for(int j = start - 1; j < end ; j++) {
					sum += gcdsmap.get(ops[j]);
				}
				
				int result = (int)((double)(sum) % ((Math.pow(10, 9)) + 7));
				results.add(result);
			} else {
				ops[(start - 1)] = end;
				
				if(!gcdsmap.containsKey(end)) {
					int gcd = computeGCDSum(end);
					gcdsmap.put(end, gcd);
				}
			}
		}
		
		sc.close();
		
		for(Integer res : results) {
			System.out.println(res);
		}
	}

	public int computeGCDSum(int ele) {
		int gcdsum = 0;
		
		for(int i = 1; i <= ele; i++) {
			gcdsum += gcd(i, ele);
		}
		
		return gcdsum;
	}
	
	public int gcd(int x , int y) {
		while(y > 0) {
			int temp = y;
			y = x % y;
			x = temp;
		}
		return x;
	}

}
