package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfArrays {

	public static void main(String[] args) {
		int[] a1 = {1,2,2,1};
		int[] a2 = {2,2};
		int[] interse = new IntersectionOfArrays().intersect(a1, a2);
	}

	 public int[] intersect(int[] nums1, int[] nums2) {
		 int nums1l = nums1.length, nums2l = nums2.length;
		 
		 if(nums1l > nums2l) {
			 int[] temp = nums1;
			 nums1 = nums2;
			 nums2 = temp;
			 
			 int t = nums1l;
			 nums1l = nums2l;
			 nums2l = t;
		 }
		 
		 Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums1l);
		 
		 for(int i = 0; i < nums1l; i++) {
			 int cur = nums1[i];
			 Integer curCount = map.get(cur);
			 
			 if(curCount == null)  {
				 map.put(cur, 1);
			 } else {
				 map.put(cur, ++curCount);
			 }
		 }
		 
		 List<Integer> op = new ArrayList<Integer>();
		 
		 for(int i = 0; i < nums2l; i++) {
			 int cur = nums2[i];
			 Integer curCount = map.get(cur);
			 
			 if(curCount != null && curCount > 0) {
				 map.put(cur, --curCount);
				 op.add(cur);
			 }
		 }
		 
		 int size = op.size();
		 int[] opa = new int[size];
		 int i = 0;
		 for(Integer cur : op) {
			 opa[i++] = cur;
		 }
		 
		 return opa;
	 }
}
