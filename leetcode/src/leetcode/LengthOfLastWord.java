package leetcode;

public class LengthOfLastWord {

	public static void main(String[] args) {
		System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello"));
	}

	public int lengthOfLastWord(String s) {
		int count = 0;
		
		int len = s.length();
		
		for(int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			
			if(ch == ' ') if(count >0) count = 0;
			else count++;
		}
		
		return count;
	}
}
