package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Friends 4 block(2018 KAKAO BLIND RECRUITMENT)
// using array
// When erasing a block, it is important to lower the blocks above it.
public class Level2_44 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		String[] board = new String[m];
		
		for(int i = 0; i < m; i++) {
			board[i] = br.readLine();
		}
		sb.append(solution(m, n, board) + "");
		System.out.print(sb);
	}
	
	public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] newboard = new char[m][n];
        
        for(int i = 0; i < m; i++) {
        	char[] arr = board[i].toCharArray();
        	for(int j = 0; j < n; j++) {
        		newboard[i][j] = arr[j];
        	}
        }
        
        boolean flag = false;
        while(!flag) {
        	boolean[][] visit = new boolean[m][n];
        	flag = true;
        	// Check the blocks to be erased.
        	for(int i = 0; i < m-1; i++) {
        		for(int j = 0; j < n-1; j++) {
        			if(newboard[i][j] == ' ') {
        				continue;
        			}
        			if(newboard[i][j] == newboard[i][j+1] && newboard[i][j] == newboard[i+1][j] && newboard[i][j] == newboard[i+1][j+1]) {
        				visit[i][j] = true;
        				visit[i][j+1] = true;
        				visit[i+1][j] = true;
        				visit[i+1][j+1] = true;
        				flag = false;
        			}
        		}
        	}
        	// Erase the block.
        	// When a block is erased, the process of lowering the remaining blocks
        	for(int i = 0; i < m; i++) {
        		for(int j = 0; j < n; j++)  {
        			if(visit[i][j] == true) {
        				answer++;
        				if(i == 0) newboard[i][j] = ' ';
        				else {
        					for(int k = i; k > 0; k--) {
        						char temp = newboard[k-1][j];
        						newboard[k-1][j] = ' ';
        						newboard[k][j] = temp;
            				}
        				}
        			}
        		}
        	}
        }
        return answer;
    }
}