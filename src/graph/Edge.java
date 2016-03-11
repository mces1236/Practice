package graph;

public class Edge<T> {
	T data;
	Edge<T> next;
	
	public Edge(T data) {
		this.data = data;
	}
}
