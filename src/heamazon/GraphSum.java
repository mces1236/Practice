package heamazon;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import graph.Edge;
import graph.Vertex;

public class GraphSum {

	public static void main(String[] args) {
		GraphSum gs = new GraphSum();
		
		gs.computeSumofAllPaths();
	}

	private void computeSumofAllPaths() {
		Scanner sc = new Scanner(System.in);
		
		int noOfTestCases = sc.nextInt();
		
		int[] results = new int[noOfTestCases]; 
		
		for(int i = 0; i < noOfTestCases; i++) {
			int vertices = sc.nextInt();
			
			for(int j = 0; j < (vertices - 1); j++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				int weight = sc.nextInt();
				
				addUnDirectedEdge(from, to, weight);
			}
			
			results[i] = computeSum(vertices);
			
			this.vertices.clear();
			this.vertices = new Hashtable<Integer, Vertex<Integer>>();
		}
		
		sc.close();
		
		for(int i = 0; i < noOfTestCases; i++) {
			System.out.println(results[i]);
		}
	}
	
	private int computeSum(int noOfVertices) {
		int sum = 0;
		for(int i = 1; i < noOfVertices; i++) {
			for(int j = i + 1; j <= noOfVertices; j++) {
				sum += findMaxWeightInPath(i, j);
			}
		}
		
		return sum;
	}

	private int findMaxWeightInPath(int i, int j) {
		return dfsIterative(i, j);
//		return dfs(i, j, new HashSet<Integer>());
	}
	
	private int dfs(int current, int destination, Set<Integer> v) {
		if(!v.contains(current)) {
			Vertex<Integer> cur = vertices.get(current);
			for(Edge<Integer> edge : cur.edges) {
				Vertex<Integer> edgeVertex = vertices.get(edge.data);
				int max = dfs(edgeVertex.data,destination, v);
				
				if(max > edge.weight) {
					return max;
				}
				
				return edge.weight;
			}
			v.add(cur.data);
		}
		
		return 0;
	}
	
	private int dfsIterative(int current, int destination) {
		Set<Integer> visited = new HashSet<Integer>();
		
		int maxWeight = 0;
		
		LinkedList<Vertex<Integer>> bfsQueue = new LinkedList<Vertex<Integer>>();
		
		Vertex<Integer> rootVertex = vertices.get(current);
		
		bfsQueue.add(rootVertex);

		while(!bfsQueue.isEmpty()) {
			Vertex<Integer> temp = bfsQueue.removeFirst();
			Integer vertexData = temp.data;
			
			if(!visited.contains(vertexData)) {
				visited.add(vertexData);
				
				for(Edge<Integer> edge : temp.edges) {
					if(maxWeight < edge.weight && vertexData > edge.data) {
						maxWeight = edge.weight;
					}
					
					if(edge.data == destination) {
						return maxWeight;
					}
					
					Vertex<Integer> to = vertices.get(edge.data);
					bfsQueue.add(to);
				}
			}
		}
		
		return 0;
	}

	Map<Integer, Vertex<Integer>> vertices = new Hashtable<Integer, Vertex<Integer>>();
	Integer root = null;
	
	public void addDirectedEdge(Integer from, Integer to, int weight) {
		
		Edge<Integer> edge = new Edge<Integer>(to, weight);
		Vertex<Integer> fromVertex = null;
		
		if(vertices.containsKey(from)) {
			fromVertex = vertices.get(from);
		} else {
			fromVertex = new Vertex<Integer>(from);
		}
		
		if(vertices.isEmpty()){
			root = from;
		}
		
		fromVertex.edges.add(edge);
		vertices.put(from, fromVertex);
		
		if(!vertices.containsKey(to)) {
			Vertex<Integer> toVertex = new Vertex<Integer>(to);
			vertices.put(to, toVertex);
		}
	}
	
	public void addUnDirectedEdge(Integer from, Integer to, int weight) {
		addDirectedEdge(from, to, weight);
		addDirectedEdge(to, from, weight);
	}

}
