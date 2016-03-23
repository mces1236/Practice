package patternmatching;

public class KMPAlgorithm {

	public static void main(String[] args) {
		
		String pattern = "AAACAAAAAC";
//		String text = "";
		
		int[] lps = prefixSuffixArray(pattern);
		
		if(lps != null) {
			printArray(lps);
		}
	}

	private static void printArray(int[] lps) {
		for(int i = 0; i < lps.length; i++) {
			System.out.print(lps[i] + "\t");
		}
	}

	private static int[] prefixSuffixArray(String pattern) {
		if (pattern == null || pattern.isEmpty()) return null; 
		
		int len = pattern.length();
		int [] lps = new int[len];
		lps[0] = 0;
		
		int preI = 0;
		for(int i = 1; i < len; i++) {
			preI = lps[i-1];
			
			if(pattern.charAt(preI) == pattern.charAt(i)) {
				lps[i] = (preI + 1);
			} else {
				lps[i] = 0;
			}
		}
		
		return lps;
	}

}
