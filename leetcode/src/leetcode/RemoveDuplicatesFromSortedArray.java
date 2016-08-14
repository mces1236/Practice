package leetcode;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] arr = {1,1,2,2,3,4,4,4,5};
		System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(arr));
	}

	public int removeDuplicates(int[] nums) {
		if(nums == null) return 0;
		int len = nums.length;
		
		if(len == 0) return 0;
		
		int pre = nums[0], newArrLen = 1;
		
		for(int i = 1; i < len; i++) {
			int cur = nums[i];
			
			if(pre != cur) {
				pre = nums[newArrLen++] = cur; 
			}
		}
		
		return newArrLen;
	}
}
