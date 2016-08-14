package leetcode;

public class RemoveGivenElementFromArray {

	public static void main(String[] args) {
		int[] nums = {3,2,2};
		int val = 2;
		System.out.println(new RemoveGivenElementFromArray().removeElement(nums, val));
	}

	public int removeElement(int[] nums, int val) {
		int len = nums.length, cur = 0;
		for(int i = 0; i < len; i++)
			if(nums[i] != val)
				nums[cur++] = nums[i];
		
		return cur;
	}
}
