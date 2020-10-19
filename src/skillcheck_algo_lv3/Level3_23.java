package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Ranking
// using Graph (Floyd Warshall Algorithm)
public class Level3_23 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	

		String[] input = br.readLine().split(", ");
		int n = Integer.parseInt(input[1]);
		int m = Integer.parseInt(input[0]);
		
		int[][] results = new int[m][2];
		for(int i = 0; i < m; i++) {
			String[] input2 = br.readLine().split(", ");
			results[i][0] = Integer.parseInt(input2[0]);
			results[i][1] = Integer.parseInt(input2[1]);
		}
		
		
		sb.append(solution(n, results) + "");
		System.out.print(sb);
	}
	
	public static int solution(int n, int[][] results) {
        int answer = 0;
        // The remaining values ​​are stored as this value by putting an appropriately large number in max.
        // In this case, do not put Integer.MAX_VALUE in order to put a large number.
        // When both the maximum values ​​of Integer are added together, a negative number occurs due to overflow.
        int max = 111111111;
        int[][] fw = new int[n][n];
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(i != j) fw[i][j] = max;
        	}
        }
        // fw[a][b] : a -> b
        for(int[] edge : results) {
        	fw[edge[0]-1][edge[1]-1] = 1;
        }
        
        // Floyd Warshall algorithm
        // k : the node going through
        for(int k = 0; k < n; k++) {
        	// i to j
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			fw[i][j] = Math.min(fw[i][j], fw[i][k] + fw[k][j]);
        		}
        	}
        }
        
        // Check if players have ever played.
        for(int i = 0; i < n; i++) {
        	boolean flag = true;
        	for(int j = 0; j < n; j++) {
        		if(i == j) continue;
        		// If i and j did not play, the ranking is unknown.
        		// player has to play with everyone to know player's ranking.
        		if(fw[i][j] == max && fw[j][i] == max) {
        			flag = false;
        			break;
        		}
        	}
        	if(flag) answer++;
        }
        return answer;
    }
}