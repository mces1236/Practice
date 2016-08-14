package leetcode;

import java.util.HashMap;

public class DuplicatesInAtmostKArray {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,5};
		System.out.println(new DuplicatesInAtmostKArray().containsNearbyDuplicate(nums, 3));
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int len = nums.length;
		for(int i = 0; i < len; i++){
			Integer cur = nums[i];
			Integer preOccuredIndex = map.get(cur);
			
			if(preOccuredIndex != null && (i - preOccuredIndex) <= k) return true;
			
			map.put(cur, i);
		}
		
		return false;
	}
}
