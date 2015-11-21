package hackerrank;

import java.util.Scanner;

public class CavityMap {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int mapSize = sc.nextInt();
		sc.nextLine();
		
		char[][] cavityMap = new char[mapSize][mapSize];
		
		for(int i = 0; i < mapSize; i++) {
			String num = sc.nextLine();
			
			for(int j = 0; j < num.length(); j++) {
				cavityMap[i][j] = num.charAt(j);
			}
			
		}
		
		getCativies(cavityMap);
		
		for(int i = 0; i <  cavityMap.length; i++) {
			for(int j = 0; j < cavityMap[i].length; j++) {
					System.out.print(cavityMap[i][j]);
			}
			System.out.println();
		}
		
		sc.close();
	}

	private static void getCativies(char[][] cavityMap) {
		
		for(int i = 1; i < (cavityMap.length - 1); i++) {
			for(int j = 1; j < (cavityMap[i].length - 1); j++) {
				boolean isCavity = true;
				char curEle = cavityMap[i][j];
				
				if(curEle <= cavityMap[i-1][j]) isCavity = false;
				
				if(curEle <= cavityMap[i][j-1]) isCavity = false;
				
				if(curEle <= cavityMap[i+1][j]) isCavity = false;
				
				if(curEle <= cavityMap[i][j+1]) isCavity = false;
				
				if(isCavity) cavityMap[i][j] = 'X';
			}
		}
	}
}
