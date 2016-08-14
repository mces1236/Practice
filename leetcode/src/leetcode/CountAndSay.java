package leetcode;

public class CountAndSay {

	public static void main(String[] args) {
		new CountAndSay().countAndSay(2);
	}

	public String countAndSay(int n) {
		
		StringBuilder sb = new StringBuilder("1");
		if(n == 1) return sb.toString();
		
		while(n > 1) {
			n--;
			
			int len = sb.length();
			
			System.out.println(sb.toString());
			
			StringBuilder temp = new StringBuilder();
			
			int count = 1;
			char pre = sb.charAt(0);
			
			for(int i = 1; i < len; i++) {
				char cur = sb.charAt(i);
				
				if(cur == pre) {
					count++;
				} else {
					temp.append(Integer.toString(count));
					temp.append(pre);
					count = 1;
					pre = cur;
				}
			}
			
			temp.append(Integer.toString(count));
			temp.append(pre);
			
			sb = temp;
		}
		
		return sb.toString();
	}
}
