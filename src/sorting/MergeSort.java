  package sorting;

public class MergeSort {

	public static void main(String[] args) {
		
		MergeSort ms = new MergeSort();
		
		int[] a = {1,-1};
		
		printArray(a);
		
		ms.mergeSort(a);
		
		printArray(a);
	}
	
	public void mergeSort(int[] a) {
		mergeSort(a, 0, (a.length-1));
	}

	public void mergeSort(int[] a, int l, int r) {
		if(l < r) {
			int m = ((l + r) / 2);
			mergeSort(a, l, m);
			mergeSort(a, (m + 1), r);
			mergeSortedArrays(a, l, m, r);
		}
	}
	
	public void mergeSortedArrays(int[] a, int l, int m, int r) {
		int[] b = new int[(r-l+1)];
		int tempL = l;
		int bpos = 0;
		int temp = (m+1);
		
		for(;(l <= m && temp <= r);) {
			if(a[l] < a[temp]) {
				b[bpos++] = a[l++];
			}
			else {
				b[bpos++] = a[temp++];
			}
		}
		
		if(l <= m) {
			for(; l<=m; l++) {
				b[bpos++] = a[l];
			}
		}
		
		if(temp <= r) {
			for(;temp<=r; temp++) {
				b[bpos++] = a[temp];
			}
		}
		
		for(int i = tempL, j=0; i <= r; i++) {
			a[i] = b[j++];
		}
	}
	
	private static void printArray(int[] a) {
		for(int i = 0; i < a.length; i++) 
			System.out.print(a[i] + " ");
		
		System.out.println();
	}
}
