package sorting;

import utils.ArrayUtils;

public class RadixSort {

	public static void main(String[] args) {
		
		int[] a = {155,55,135,45,655,395,855,755,29};
		
		RadixSort rs = new RadixSort();
		rs.radixSort(a);
		ArrayUtils.printArray(a);
	}

	public void radixSort(int[] a) {
		
		int maxDigits = 0;
		for(int i = 0; i < a.length; i++) {
			int noOfDigits = ((int)Math.log10((double)(a[i])) + 1);
			
			if(noOfDigits > maxDigits) {
				maxDigits = noOfDigits;
			}
		}
		
		int divider = 10;
		
		while(maxDigits-- > 0) {
			CountingSort cs = new CountingSort();
			cs.initialize(10);

			for(int i = 0; i < a.length; i++) {
				int index = (a[i] % divider);
				index = ((index * 10)/divider);
				cs.increment(index);
			}

			cs.count();

			int[] b = new int[a.length];
			for(int i = 0; i < a.length; i++) {
				int index = (a[i] % divider);
				index = ((index * 10)/divider);
				int newIndex = cs.getCountForIndex(index);
				b[newIndex] = a[i];
			}

			a = b;
			divider *= 10;
		}
	}
}
