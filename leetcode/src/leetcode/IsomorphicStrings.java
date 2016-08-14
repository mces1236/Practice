package leetcode;

public class IsomorphicStrings {
	public static void main(String[] args) {
		System.out.println(new IsomorphicStrings().isIsomorphic("pape r", "titl e"));
	}
	
	public boolean isIsomorphic(String s, String t) {
		if(s == null && t == null) return true;
		if(s == null || t == null) return false;
		
		int slen = s.length(), tlen = t.length();
		
		if(slen != tlen) return false;
		
		int[] charMappings = new int[256];
		boolean[] seenCharacters = new boolean[256];
		
		for(int i = 0; i < 256; i++) charMappings[i] = -1;
		
		for(int i = 0; i < slen; i++) {
			char sch = s.charAt(i);
			char tch = t.charAt(i);
			
			int mappedChar = charMappings[sch];
			
			if(seenCharacters[tch]) {
				if(charMappings[sch] != tch) return false;
			} else if(mappedChar != -1 && mappedChar != (int)tch) {
					return false;
			} else {
				charMappings[sch] = tch;
				seenCharacters[tch] = true;
			}
		}
		
		return true;
    }
}
