package leetcode;

public class PlusOneArray {

	public static void main(String[] args) {
		int[] nums = {0};
		int[] op = new PlusOneArray().plusOne(nums);
		ArrayUtils.printArray(op);
	}

	public int[] plusOne(int[] digits) {
		
		if(digits == null) return digits;
		
		int len = digits.length, carry = 1;
		
		int[] op = new int[len];
		
		for(int i = len -1; i >= 0; i--) {
			int sum = digits[i] + carry;
			carry = sum / 10;
			op[i] = sum%10;
		}
		
		if(carry > 0) {
			len++;
			int[] newop = new int[len];
			newop[0] = carry;
			
			for(int i = 0; i < len-1; i++) {
				newop[i + 1] = op[i];
			}
			
			return newop;
		}
		
		return op;
	}
}
