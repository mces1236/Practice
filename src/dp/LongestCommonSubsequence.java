package dp;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String str1 = "aggtab";
		String str2 = "gxtxayb";
		int[][] lcsArray = new int[str1.length()][str2.length()];
		
		for(int i = 0; i < str1.length(); i++)
			for(int j = 0; j < str2.length(); j++)
				lcsArray[i][j] = -1;
		
		int len = lcsLength(str1, str2, (str1.length() - 1), (str2.length() - 1), lcsArray);
		System.out.println(len);
		printArray(lcsArray);
		
		String lcsStr = lcsString(str1, str2, lcsArray, len);
		System.out.println(lcsStr);
	}
	
	public static void printArray(int[][] lcsArray) {
		for(int i = 0; i < lcsArray.length; i++) { 
			for(int j = 0; j < lcsArray[i].length; j++) {
				System.out.print(lcsArray[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static String lcsString(String str1, String str2, int[][] lcsArray, int lcsLength) {
		StringBuilder sb = new StringBuilder(lcsLength);
		
		int i = (str1.length() - 1), j = (str2.length() - 1);
		
		while(i >= 0 && j >= 0) {
			if(str1.charAt(i) == str2.charAt(j)) {
				sb.append(str1.charAt(i));
				i--;j--;
			} else if(lcsArray[i-1][j] < lcsArray[i][j-1]) {
				j--;
			} else {
				i--;
			}
		}
		
		return sb.reverse().toString();
	}


	public static int lcsLength(String str1, String str2, int m, int n, int[][] lcsArray) {
		if(m >= 0 && n >= 0) {
			
			if(lcsArray[m][n] != -1) {
				return lcsArray[m][n];
			}
			
			if(str1.charAt(m) == str2.charAt(n)) {
				return (lcsArray[m][n] = (1 + lcsLength(str1, str2, (m-1), (n-1), lcsArray)));
			} else {
				return (lcsArray[m][n] = Math.max(lcsLength(str1, str2, m-1, n, lcsArray), lcsLength(str1, str2, m, n-1, lcsArray)));
			}
		}
		return 0;
	}
}
