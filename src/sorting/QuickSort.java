package sorting;

import utils.ArrayUtils;

public class QuickSort {
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] a = {100,0,105,40,650,390,800,750,29};
		qs.quickSort(a);
		ArrayUtils.printArray(a);
	}
	
	public void quickSort(int[] a) {
		quickSort(a, 0, (a.length-1));
	}
	
	public void quickSort(int[] a, int l, int r) {
		
		int tempL = l, tempR = r;
		
		if(l < r) {
			
			int pivot = l++;
			while(l <= r) {
				while(a[l] < a[pivot] && l <= tempR) {
					l++;
				}
				while(a[r] > a[pivot] && r >= tempL) {
					r--;
				}
				
				if(l < r) {
					swap(a, l, r);
				}
			}
			swap(a, pivot, r);
			ArrayUtils.printArray(a);
			quickSort(a, tempL, (r-1));
			quickSort(a, (r+1), tempR);
		}
	}
	
	public void swap(int[] a, int l, int r) {
		int temp = a[l];
		a[l] = a[r];
		a[r] = temp;
	}
}
