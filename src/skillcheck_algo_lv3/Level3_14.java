package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
// Programmers Level 3 : Farthest node
// Graph, using BFS
public class Level3_14 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		int[][] edge = new int[7][2];
		
		for(int i = 0; i < 7; i++) {
			String[] input = br.readLine().split(", ");
			for(int j = 0; j < 2; j++) {
				edge[i][j] = Integer.parseInt(input[j]);
			}
		}
		sb.append(solution(n, edge) + "");
		
		System.out.print(sb);
	}
	
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        int[] dist = new int[n];
        boolean[][] visit = new boolean[n][n];
        
        for(int i = 0; i < edge.length; i++) {
        	visit[edge[i][0]-1][edge[i][1]-1] = true;
        	visit[edge[i][1]-1][edge[i][0]-1] = true;
        }
        
        Queue<Integer> qu = new LinkedList<Integer>();
        qu.offer(0);
        // using Breadth First Search, BFS
        while(!qu.isEmpty()) {
        	int idx = qu.poll();
        	for(int i = 1; i < n; i++) {
        		if(dist[i] == 0 && visit[idx][i]) {
        			dist[i] = dist[idx] + 1;
            		qu.add(i);
        		}
        	}
        }
        
        int max = 0;
        for(int i = 0; i < n; i++) {
        	max = Math.max(dist[i], max);
        }
        
        for(int i = 0; i < n; i++) {
        	if(max == dist[i]) answer++;
        }
        return answer;
    }
}