package leetcode;

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(new RomanToInteger().romanToInt("XIV"));
	}


	public int getDecimal(char ch) {
		switch(ch) {
		case 'I' : return 1; 
		case 'V' : return 5;
		case 'X' :	return 10;
		case 'L': return 50;
		case 'C' : return 100;
		case 'D' : return 500;
		case 'M' : return 1000;
		}
		
		return 0;
	}

	public int romanToInt(String s) {
		int len = s.length();
		
		if(len == 0) return 0;
		
		int curDec, preDec, decimal;
		
		preDec = decimal = getDecimal(s.charAt(len - 1));
		
		for(int i = len - 2; i >= 0; i--) {
			curDec = getDecimal(s.charAt(i));
			
			if(curDec < preDec) 
				curDec = -curDec;
			
			preDec = curDec;
			
			decimal += curDec;
		}
		
		return decimal;
	}
}
