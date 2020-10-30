package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : visit distance
// using 4-dimension array
public class Level3_30 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String dirs = br.readLine();
		sb.append(solution(dirs) + "");
		System.out.print(sb);
	}
	
	public static int solution(String dirs) {
        int answer = 0;
        // (x, y) = current coordinate
        // (x2, y2) = coordinate to move
        int x = 5, y = 5, x2 = 5, y2 = 5;
        int[] dx = {-1, 0, 1, 0}; // L, R
        int[] dy = {0, -1, 0, 1}; // D, U
        // visit[x][y][x2][y2] -> Move or not
        boolean[][][][] visit = new boolean[11][11][11][11];         
        for(int i = 0; i < dirs.length(); i++) {
        	x = x2;
        	y = y2;
        	if(dirs.charAt(i) == 'L') {
        		x2 = x + dx[0];
        		y2 = y + dy[0];
        	}
        	else if(dirs.charAt(i) == 'D') {
        		x2 = x + dx[1];
        		y2 = y + dy[1];
        	}
        	else if(dirs.charAt(i) == 'R') {
        		x2 = x + dx[2];
        		y2 = y + dy[2];
        	}
        	else {
        		x2 = x + dx[3];
        		y2 = y + dy[3];
        	}
        	// If it is out of range, it is changed to the coordinates before moving.
        	if(x2 < 0 || x2 > 10 || y2 < 0 || y2 > 10) {
        		x2 = x;
        		y2 = y;
        		// Since the processing is out of range, the next processing is skip.
        		continue;
        	}
        	// If this is first visit, give +1 because it is first trip.
        	if(!visit[x][y][x2][y2]) {
        		visit[x][y][x2][y2] = true;
        		visit[x2][y2][x][y] = true;
        		answer++;
        	}
        }
        
        return answer;
    }
}