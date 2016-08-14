package leetcode;

public class HappyNumber {

	public static void main(String[] args) {
		System.out.println(new HappyNumber().isHappy(82));
	}

	public boolean isHappy(int n) {
		while(true) {
			if(n == 1) return true;
			else if(n == 4) return false;
			
			String str = String.valueOf(n);
			n = 0;
			
			for(int i = 0; i < str.length(); i++) {
				int temp = (int)(str.charAt(i) - '0');
				n += (temp * temp);
			}
		}
	}
}
