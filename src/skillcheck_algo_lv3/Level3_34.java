package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Programmers Level 3 : Delivery
// using Dijkstra Algorithm
public class Level3_34 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] nkr = br.readLine().split(", ");
		int n = Integer.parseInt(nkr[0]);
		int k = Integer.parseInt(nkr[1]);
		int r = Integer.parseInt(nkr[2]);
		
		int[][] road = new int[r][3];
		for(int i = 0; i < r; i++) {
			String[] input = br.readLine().split(",");
			road[i][0] = Integer.parseInt(input[0]);
			road[i][1] = Integer.parseInt(input[1]);
			road[i][2] = Integer.parseInt(input[2]);
		}
		sb.append(solution(n, road, k) + "");
		System.out.print(sb);
	}
	
	public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        // adj[from][to] : Edge, Value is weight
        int[][] adj = new int[N][N];
        // array initialize
        for(int i = 0; i < N; ++i) {
        	for(int j = 0; j < N; ++j) {
        		adj[i][j] = Integer.MAX_VALUE;
        	}
        }
        // Since it is an array, the value of each node is subtracted by 1.
        for(int i = 0; i < road.length; ++i) {
        	int from = road[i][0] - 1;
        	int to = road[i][1] - 1;
        	int weight = road[i][2];
        	if(weight < adj[from][to]) {
        		adj[from][to] = adj[to][from] = weight;
        	}
        }
        
        boolean[] visit = new boolean[N];
        // Starting at node 1, the distance from node 1 to each node
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(dist[o1], dist[o2]);
            }
        });

        dist[0] = 0;
        pq.offer(0);
        // Dijkstra algorithm
        while(!pq.isEmpty()) {
        	int cur = pq.poll();
        	if(visit[cur]) continue;
        	
        	visit[cur] = true;
        	for(int i = 0; i < N; ++i) {
        		if(adj[cur][i] != Integer.MAX_VALUE) {
        			if(dist[i] > dist[cur] + adj[cur][i]) {
        				dist[i] = dist[cur] + adj[cur][i];
        				pq.offer(i);
        			}
        		}
        	}
        }
        
        for(int i = 0; i < dist.length; ++i) {
        	if(dist[i] <= K) answer++;
        }
        
        return answer;
    }
}