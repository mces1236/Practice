package sorting;

public class CountingSort {
	int[] a;
	
	public void initialize(int count) {
		a = new int[count];
	}
	
	public void increment(int index) {
		increment(index, 1);
	}
	
	public void increment(int index, int toAdd) {
		a[index] += toAdd;
	}
	
	public void count() {
		int sumUntil = 0;
		for(int i = 0; i < a.length; i++) {
			int temp = a[i];
			a[i] = sumUntil;
			sumUntil += temp;
		}
	}
	
	public int getCountForIndex(int index) {
		return a[index]++;
	}
}
