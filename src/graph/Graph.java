package graph;

import java.beans.Visibility;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<T> {
	Map<T, Vertex<T>> vertices;
	T root = null;
	
	public Graph() {
		vertices = new Hashtable<T, Vertex<T>>();
	}
	
	public void addEdge(T from, T to) {
		
		Edge<T> edge = new Edge<T>(to);
		Vertex<T> fromVertex = null;
		
		if(vertices.containsKey(from)) {
			fromVertex = vertices.get(from);
		} else if(vertices.isEmpty()){
			root = from;
			fromVertex = new Vertex<T>(from);
		}
		
		fromVertex.edges.add(edge);
		vertices.put(from, fromVertex);
		
		if(!vertices.containsKey(to)) {
			Vertex<T> toVertex = new Vertex<T>(to);
			vertices.put(to, toVertex);
		}
	}
	
	public List<T> bfs() {
		if(root == null) return null;
		
		Set<T> visited = new HashSet<T>();
		List<T> bfsList = new ArrayList<T>();
		
		LinkedList<Vertex<T>> bfsQueue = new LinkedList<Vertex<T>>();
		
		Vertex<T> rootVertex = vertices.get(root);
		
		bfsQueue.add(rootVertex);

		while(!bfsQueue.isEmpty()) {
			Vertex<T> temp = bfsQueue.removeFirst();
			T vertexData = temp.data;
			
			if(!visited.contains(vertexData)) {

				bfsList.add(vertexData);
				visited.add(vertexData);

				for(Edge<T> edge : temp.edges) {
					Vertex<T> to = vertices.get(edge.data);
					bfsQueue.add(to);
				}
			}
		}
		
		return bfsList;
	}
	
	public List<T> dfs() {
		if(root == null) return null;
		
		List<T> dfsList = new ArrayList<T>();
		
		Set<T> visited = new HashSet<T>();
		
		dfs(vertices.get(root), visited, dfsList);
		
		return dfsList;
	}
	
	private void dfs(Vertex<T> cur, Set<T> v, List<T> list) {
		if(!v.contains(cur.data)) {
			for(Edge<T> edge : cur.edges) {
				Vertex<T> edgeVertex = vertices.get(edge.data);
				dfs(edgeVertex, v, list);
			}
			list.add(cur.data);
			v.add(cur.data);
		}
	}
	
	public void print() {
		if(root == null) return;
		
		Set<T> visited = new HashSet<T>();
		
		LinkedList<Vertex<T>> bfsQueue = new LinkedList<Vertex<T>>();
		
		Vertex<T> rootVertex = vertices.get(root);
		
		bfsQueue.add(rootVertex);

		while(!bfsQueue.isEmpty()) {
			Vertex<T> temp = bfsQueue.removeFirst();
			T vertexData = temp.data;
			
			if(!visited.contains(vertexData)) {
				visited.add(vertexData);
				
				StringBuilder sb = new StringBuilder();
				sb.append(vertexData + " ");
				
				for(Edge<T> edge : temp.edges) {
					Vertex<T> to = vertices.get(edge.data);
					bfsQueue.add(to);
					sb.append(to.data + " ");
				}
				
				System.out.println(sb.toString().trim());
			}
		}
	}
	
	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<Integer>();
		
		graph.addEdge(10, 20);
		graph.addEdge(10, 50);
		graph.addEdge(20, 30);
		graph.addEdge(20, 40);
		graph.addEdge(30, 40);
		graph.addEdge(40, 50);
		
//		graph.print();
//		System.out.println(graph.bfs());
		System.out.println(graph.dfs());
	}
}
