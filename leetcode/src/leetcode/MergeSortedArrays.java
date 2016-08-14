package leetcode;

public class MergeSortedArrays {

	public static void main(String[] args) {
		
		System.out.println(Long.MAX_VALUE - 9223370579426763404L);
		
		int[] nums1 = {1,0};
		int[] nums2 = {1};
		
		new MergeSortedArrays().merge(nums1, 1, nums2, nums2.length);
		
		ArrayUtils.printArray(nums1);
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int cur = m + n - 1;
		m -= 1;n -= 1;
		
		while(m >= 0 && n >= 0) {
			int n1 = nums1[m];
			int n2 = nums2[n];
			
			if(n1 > n2) {
				nums1[cur--] = nums1[m--];
			} else {
				nums1[cur--] = nums2[n--];
			}
		}
		
		while(n >= 0) {
			nums1[cur--] = nums2[n--];
		}
	}
}
