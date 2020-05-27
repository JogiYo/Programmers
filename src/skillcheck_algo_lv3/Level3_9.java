package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// Programmers Level 3 : Connecting islands
// using Greedy algorithm -> Kruskal algorithm, union-find algorithm
// union-find -> https://gmlwjd9405.github.io/2018/08/31/algorithm-union-find.html
public class Level3_9 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int n = Integer.parseInt(input[0]);
		int edge = Integer.parseInt(input[1]);
		int[][] costs = new int[edge][3];
		
		for(int i = 0; i < edge; i++) {
			String[] cost = br.readLine().split(",");
			for(int j = 0; j < cost.length; j++) {
				costs[i][j] = Integer.parseInt(cost[j]);
			}
		}
		
		sb.append(solution(n, costs) + "");
		System.out.print(sb);
	}

	public static int solution(int n, int[][] costs) {
		int answer = 0;
		int[] parent = new int[n];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for(int i = 0; i < costs.length; i++) {
			Edge edge = new Edge(costs[i][0], costs[i][1], costs[i][2]);
			pq.offer(edge);
		}
		
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(find(edge.from, parent) == find(edge.to, parent)) continue;
			else {
				union(edge.from, edge.to, parent);
				answer += edge.cost;
			}
		}
		
		return answer;
	}
	
	private static void union(int from, int to, int[] parent) {
		int rootFrom = find(from, parent);
		int rootTo = find(to, parent);
		
		if(rootFrom != rootTo) parent[rootTo] = rootFrom;
	}
	// find root
	private static int find(int n, int[] parent) {
		if(parent[n] == n) return n;
		return parent[n] = find(parent[n], parent);
	}

	static class Edge implements Comparable<Edge> {
	    int from, to, cost;
	    
	    Edge(int from, int to, int cost){
	        this.from = from;
	        this.to = to;
	        this.cost = cost;
	    }
	    
	    @Override
	    public int compareTo(Edge other){
	        return this.cost - other.cost;
	    }
	}
}