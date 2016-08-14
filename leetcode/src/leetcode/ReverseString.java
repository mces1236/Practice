package leetcode;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println(new ReverseString().reverseVowels("leetcode"));
	}

	
	 public boolean isVowel(char ch) {
		 	ch = Character.toLowerCase(ch);
	        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
	        return false;
	    }
	    
	    public String reverseVowels(String s) {
	        
	        StringBuilder sb  = new StringBuilder(s);
	        
	        boolean foundVowelFromStart = false, foundVowelFromEnd = false;
	        
	        int vowelFromStart = 0, vowelFromEnd = s.length() - 1;
	        
	        while(vowelFromStart < vowelFromEnd) {
	            
	            if(!foundVowelFromStart) {
	                if(isVowel(s.charAt(vowelFromStart))) 
	                    foundVowelFromStart = true; 
	                else {
	                    sb.setCharAt(vowelFromStart, s.charAt(vowelFromStart));
	                    vowelFromStart++;
	                }
	            }
	            
	            if(!foundVowelFromEnd) {
	                if(isVowel(s.charAt(vowelFromEnd))) {
	                    foundVowelFromEnd = true; 
	                }
	                else {
	                    sb.setCharAt(vowelFromEnd, s.charAt(vowelFromEnd));
	                    vowelFromEnd--;
	                }
	            }
	            
	            if(foundVowelFromStart && foundVowelFromEnd) {
	                sb.setCharAt(vowelFromEnd, s.charAt(vowelFromStart));
	                sb.setCharAt(vowelFromStart, s.charAt(vowelFromEnd));
	                foundVowelFromStart = foundVowelFromEnd = false;
	                vowelFromStart++;
	                vowelFromEnd--;
	            }
	        }
	        
	        return sb.toString();
	    }
}
