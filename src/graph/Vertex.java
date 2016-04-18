package graph;

import java.util.LinkedList;
import java.util.List;

public class Vertex<T> {
	public T data;
	public List<Edge<T>> edges;
	
	public Vertex(T value) {
		data = value;
		edges = new LinkedList<Edge<T>>();
	}
	
	@Override
	public String toString() {
		return this.data.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Vertex){
			Vertex<?> second = (Vertex<?>) obj; 
			this.data.equals(second.data);
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.data.hashCode();
	}
}
