package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// Programmers Level 2 : Kakao friends coloring book
// using Stack, BFS, not DFS(run time error)
public class Level2_13 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		
		int[][] picture = new int[m][n];
		
		for(int i = 0 ; i < m; i++) {
			String[] input_2 = br.readLine().split(", ");
			for(int j = 0; j < n; j++) {
				picture[i][j] = Integer.parseInt(input_2[j]);
			}
		}
		
		int[] result = solution(m, n, picture);
		
		sb.append("[" + result[0] + ", " + result[1] + "]");
		
		System.out.print(sb);
	}
	
	 public static int[] solution(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      
	      int[] answer = new int[2];
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      
	      boolean[][] visited = new boolean[m][n];
	      Stack<Integer> sX = new Stack<>();
	      Stack<Integer> sY = new Stack<>();
	      
	      // You have to navigate up, down, left and right.
	      for(int i = 0; i < m; i++) {
	    	  for(int j = 0; j < n; j++) {
	    		  // count is the width of the area
	    		  int count = 0;
	    		  // The discovery of new area
	    		  if(picture[i][j] != 0 && visited[i][j] == false) {
	    			  same_area(visited, sX, sY, j, i);
	    			  count++;
	    			  answer[0]++;
	    		  }
	    		  
	    		  while(!sX.isEmpty()) {
	    			  int x = sX.pop();
	    			  int y = sY.pop();
	    			  // move up
	    			  if(y > 0 && picture[y - 1][x] == picture[i][j] && visited[y - 1][x] == false) {
	    				  same_area(visited, sX, sY, x, y - 1);
	    				  count++;
	    			  }
	    			  // move down
	    			  if(y < m - 1 && picture[y + 1][x] == picture[i][j] && visited[y + 1][x] == false) {
	    				  same_area(visited, sX, sY, x, y + 1);
	    				  count++;
	    			  }
	    			  // move left
	    			  if(x > 0 && picture[y][x - 1] == picture[i][j] && visited[y][x - 1] == false) {
	    				  same_area(visited, sX, sY, x - 1, y);
	    				  count++;
	    			  }
	    			  // move right
	    			  if(x < n - 1 && picture[y][x + 1] == picture[i][j] && visited[y][x + 1] == false) {
	    				  same_area(visited, sX, sY, x + 1, y);
	    				  count++;
	    			  }
	    		  }
	    		  answer[1] = Math.max(answer[1], count);
	    	  }
	      }
	      return answer;
	  }

	private static void same_area(boolean[][] visited, Stack<Integer> sX, Stack<Integer> sY, int j, int i) {
		sX.add(j);
		sY.add(i);
		visited[i][j] = true;
	}
}