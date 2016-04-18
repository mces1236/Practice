package graph;

public class Edge<T> {
	public T data;
	public int weight;
	Edge<T> next;
	
	public Edge(T data) {
		this.data = data;
	}
	
	public Edge(T data, int weight) {
		this.data = data;
		this.weight = weight;
	}
}
