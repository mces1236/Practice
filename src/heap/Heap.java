package heap;

public class Heap {

	int[] data = null;
	int heapSize = -1;
	
	public Heap(int capacity) {
		data = new int[capacity];
	}
	
	int left(int index) {
		return ((index * 2) + 1);
	}
	
	int right(int index) {
		return ((index * 2) + 2);
	}
	
	int parent(int index) {
		return ((index - 1) / 2);
	}
	
	void minHeapifyArray() {
		for (int i = (heapSize / 2); i >= 0; i--) {
			minHeapify(i);
		}
	}
	
	void minHeapify(int index) {
		if(isEmpty()) return;
		
		int left = left(index);
		int right = right(index);
		
		int min = index;
		
		if(left <= heapSize && data[left] < data[min]) min = left;
		if(right <= heapSize && data[right] < data[min]) min = right;
		
		if(min != index) {
			int temp = data[min];
			data[min] = data[index];
			data[index] = temp;
			
			minHeapify(min);
		}
	}
	
	void insert(int ele) {
		data[++heapSize] = ele;
		
		reverseMinHeapify(heapSize);
	}
	
	void reverseMinHeapify(int index) {
		int parent = parent(index);
		int cur = index;
		
		while(parent != cur && data[parent] > data[cur]) {
			int temp = data[parent];
			data[parent] = data[cur];
			data[cur] = temp;
			
			cur = parent;
			parent = parent(cur);
		}
	}
	
	Integer getMin() {
		if(heapSize >= 0) {
			return data[0];
		}
		return null;
	}
	
	boolean isEmpty() {
		if(heapSize >= 0) return false;
		return true;
	}
	
	boolean isNotEmpty() {
		return (!(isEmpty()));
	}
	
	Integer extractMin() {
		if(isNotEmpty()) {
			int min = data[0];
			data[0] = data[heapSize--];
			minHeapify(0);
			return min;
		}
		return null;
	}
	
	void decreaseKey(int index, int element) {
		data[index] = element;
		reverseMinHeapify(index);
	}
	
	void deleteKey(int index) {
		decreaseKey(index, (Integer.MIN_VALUE));
		extractMin();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i <= heapSize; i++) {
			sb.append(data[i]);
			sb.append(" ");
		}
		
		return sb.toString().trim();
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap(6);
		heap.insert(5);
		heap.insert(6);
		heap.insert(7);
		heap.insert(10);
		heap.insert(15);
		heap.insert(12);

		System.out.println(heap);
		
		heap.deleteKey(1);
		
		System.out.println(heap);
	}

}
