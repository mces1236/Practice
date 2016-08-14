package leetcode;

public class UglyNumbers {

	public static void main(String[] args) {
		System.out.println(new UglyNumbers().isUgly(300));
	}
	
	public boolean isUgly(int num) {
        num = divideUntil(num, 2);
        num = divideUntil(num, 3);
        num = divideUntil(num, 5);
        
        if(num == 1) return true;
        
        return false;
    }

	private int divideUntil(int num, int i) {
		while(num % i == 0) num /= i;
		return num;
	}
}
