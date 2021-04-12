package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// Programmers Level 2 : The shortest distance in the game map
// using BFS
public class Level2_58 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] nm = br.readLine().split(", ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		int[][] maps = new int[n][m];
		for(int i = 0; i < n; ++i) {
			String[] input = br.readLine().split(",");
			for(int j = 0; j < m; ++j) {
				maps[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		sb.append(solution(maps) + "");
		System.out.print(sb);
	}
	// BFS : using Queue
	public static int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length; // row
        int m = maps[0].length; // column
        Queue<Pos> qu = new LinkedList<>();
        int[][] dist = new int[n][m]; // Array to find the shortest distance
        boolean[][] visit = new boolean[n][m]; // Array to determine if the road has passed
        
        qu.offer(new Pos(0, 0));
        dist[0][0] = 1; 
        visit[0][0] = true; 
        
        while(!qu.isEmpty()) {
        	Pos cur = qu.poll();
        	int cur_dist = dist[cur.y][cur.x];
        	// It can move in 4 directions. (Up Down Left Right)
        	final int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        	for(int i = 0; i < move.length; ++i) {
        		Pos moved_pos = new Pos(cur.x + move[i][0], cur.y + move[i][1]);
        		if(!moved_pos.isValid(n, m)) continue;
        		if(visit[moved_pos.y][moved_pos.x]) continue;
        		if(maps[moved_pos.y][moved_pos.x] == 0) continue;
        		
        		dist[moved_pos.y][moved_pos.x] = cur_dist + 1;
        		visit[moved_pos.y][moved_pos.x] = true;
        		qu.offer(moved_pos);
        	}
        }
        
        answer = dist[n-1][m-1];
        if(answer == 0) return -1;
        return answer;
    }
	
	static class Pos {
		int x, y;
		
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		boolean isValid(int n, int m) {
			if(x < 0 || x >= m) return false;
			if(y < 0 || y >= n) return false;
			return true;
		}
	}
}