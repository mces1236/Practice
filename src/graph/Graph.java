package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Graph<T> {
	Map<T, Vertex<T>> vertices;
	T root = null;
	
	public Graph() {
		vertices = new Hashtable<T, Vertex<T>>();
	}
	
	public void addDirectedEdge(T from, T to) {
		
		Edge<T> edge = new Edge<T>(to);
		Vertex<T> fromVertex = null;
		
		if(vertices.containsKey(from)) {
			fromVertex = vertices.get(from);
		} else {
			fromVertex = new Vertex<T>(from);
		}
		
		if(vertices.isEmpty()){
			root = from;
		}
		
		fromVertex.edges.add(edge);
		vertices.put(from, fromVertex);
		
		if(!vertices.containsKey(to)) {
			Vertex<T> toVertex = new Vertex<T>(to);
			vertices.put(to, toVertex);
		}
	}
	
	public void addUnDirectedEdge(T from, T to) {
		addDirectedEdge(from, to);
		addDirectedEdge(to, from);
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
	
	public boolean isBipartate() {
		if(root == null) return true;
		
		Hashtable<T, Integer> colorTable = new Hashtable<T, Integer>();
		
		for(Entry<T, Vertex<T>> entry : vertices.entrySet()) {
			T curRoot = entry.getKey();
			LinkedList<T> queue = new LinkedList<T>();

			queue.add(curRoot);
			
			if(!colorTable.containsKey(curRoot))
				colorTable.put(curRoot, 1);

			while(!queue.isEmpty()) {
				T cur = queue.removeFirst();
				int parentColor = colorTable.get(cur);
				Vertex<T> curVertex = vertices.get(cur);
				
				int colorToAssign = getOppositeColor(parentColor);
				
				for(Edge<T> edge : curVertex.edges) {
					T adjacentData = edge.data;
					
					if(colorTable.containsKey(adjacentData)) { 
						int alreadyAssignedColor = colorTable.get(adjacentData);
						
						if(parentColor == alreadyAssignedColor) return false;
					} else {
						queue.add(adjacentData);
						colorTable.put(adjacentData, colorToAssign);
					}
				}
			}
		}
		
		return true;
	}
	
	private int getOppositeColor(int parentColor) {
		if(parentColor == 1) return 2;
		return 1;
	}

	public List<T> topologicalSorting() {
		if(root == null) return null;
		
		LinkedList<T> dfsList = new LinkedList<T>();
		
		Set<T> visited = new HashSet<T>();
		
		for(Entry<T, Vertex<T>> entry : vertices.entrySet())
			topologicalSorting(entry.getValue(), visited, dfsList);
		
		return dfsList;
	}
	
	private void topologicalSorting(Vertex<T> cur, Set<T> v, LinkedList<T> list) {
		if(!v.contains(cur.data)) {
			for(Edge<T> edge : cur.edges) {
				Vertex<T> edgeVertex = vertices.get(edge.data);
				topologicalSorting(edgeVertex, v, list);
			}
			list.addFirst(cur.data);
			v.add(cur.data);
		}
	}
	
	public boolean detectCycleInDirectedGraph() {
		if(root == null) return false;
		
		Set<T> visited = new HashSet<T>();
		Set<T> depthVisited = new HashSet<T>();
		
		return detectCycleInDirectedGraphUsingDFS(root, visited, depthVisited);
	}
	
	private boolean detectCycleInDirectedGraphUsingDFS(T cur, Set<T> visited, Set<T> depthVisited) {
		if(!visited.contains(cur)) {
			if(depthVisited.contains(cur)) return true;
			
			depthVisited.add(cur);
			Vertex<T> curVertex = vertices.get(cur);
			
			for(Edge<T> edge : curVertex.edges) {
				return detectCycleInDirectedGraphUsingDFS(edge.data, visited, depthVisited);
			}
			
			depthVisited.remove(cur);
		}
		
		return false;
	}
	
	public boolean detectCycleInUnDirectedGraph() {
		if(root == null) return false;
		
		Set<T> visited = new HashSet<T>();
		Set<T> depthVisited = new HashSet<T>();
		T pre = null;
		return detectCycleInUnDirectedGraphUsingDFS(root, pre, visited, depthVisited);
	}
	
	private boolean detectCycleInUnDirectedGraphUsingDFS(T cur, T pre, Set<T> visited, Set<T> depthVisited) {
		if(!visited.contains(cur)) {
			if(depthVisited.contains(cur)) return true;
			
			depthVisited.add(cur);
			Vertex<T> curVertex = vertices.get(cur);
			
			for(Edge<T> edge : curVertex.edges) {
				if(pre != null && pre == edge.data) {
					
				} else {
					pre = cur;
					return detectCycleInUnDirectedGraphUsingDFS(edge.data, pre, visited, depthVisited);
				}
			}
			
			depthVisited.remove(cur);
		}
		
		return false;
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
		
		graph.addDirectedEdge(10, 20);
//		graph.addDirectedEdge(10, 50);
		graph.addDirectedEdge(20, 30);
//		graph.addDirectedEdge(20, 40);
		graph.addDirectedEdge(30, 40);
		graph.addDirectedEdge(40, 50);
		
		
		graph.printAll();
		System.out.println(graph.isBipartate());
	}

	public void printAll() {
		for(Entry<T, Vertex<T>> entry : vertices.entrySet()) {
			StringBuilder sb = new StringBuilder();
			for(Edge<T> edge : entry.getValue().edges) sb.append(edge.data + " ");
			System.out.println(entry.getKey() + "\t" + sb.toString().trim());
		}
	}
}
