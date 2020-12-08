package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Pillar and Beam Installation
// Let's look at conditions rather than algorithms
public class Level3_38 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] build_frame = new int[m][4];
		
		for(int i = 0; i < m; ++i) {
			String[] input = br.readLine().split(",");
			for(int j = 0; j < 4; ++j) {
				build_frame[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int[][] result = solution(n, build_frame);
		for(int i = 0; i < result.length; ++i) {
			sb.append(result[i][0] + "," + result[i][1] + "," + result[i][2] + "\n");
		}
		System.out.print(sb);
	}
	
	static boolean[][] pillars, beams;
	static final int PILLAR = 0, BEAM = 1, REMOVE = 0, ADD = 1;
	public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        int count = 0;
        // 1. Manage pillars and beams separately.
        //  1.1 This is because both pillars and beams can exist in one space
        // 2. ex) n = 5, array index : 0,1,2,3,4,5 total 6 index. 
        //  2.2 When deleting, you have to think about both sides, so do +1 each. so total array size is n+3.
        pillars = new boolean[n+3][n+3];
        beams = new boolean[n+3][n+3];
        
        for(int[] frame : build_frame) {
        	int x = frame[0] + 1;
        	int y = frame[1] + 1;
        	
        	if(frame[3] == ADD) {
        		if(frame[2] == PILLAR && canConstructPillar(x,y)) {
        			pillars[x][y] = true;
        			count++;
        		}
        		if(frame[2] == BEAM && canConstructBeam(x,y)) {
        			beams[x][y] = true;
        			count++;
        		}
        	}
        	else if(frame[3] == REMOVE) {
        		// Temporarily removed
        		if(frame[2] == PILLAR) pillars[x][y] = false;
        		else if(frame[2] == BEAM) beams[x][y] = false;
        		// If it can be removed, keep it in state.
        		if(canRemove(x, y, n)) {
        			count--;
        			continue;
        		}
        		// If it cannot be removed, restore it again.
        		if(frame[2] == PILLAR) pillars[x][y] = true;
        		else if(frame[2] == BEAM) beams[x][y] = true;
        	}
        }
        
        // Finally, the existing pillars and beams are stored in an array.
        answer = new int[count][3];
        int index = 0;
        for(int i = 1; i <= n + 1; ++i) {
        	for(int j = 1; j <= n + 1; ++j) {
        		if(pillars[i][j]) answer[index++] = new int[] {i - 1, j - 1, PILLAR};
        		if(beams[i][j]) answer[index++] = new int[] {i - 1, j - 1, BEAM};
        	}
        }
        return answer;
    }

	// Pillar installation conditions
	//  1. When installing the pillars on the floor (y == 1)
	//  2. When on another pillar (pillars[x][y-1])
	//  3. When on one end of the beam (Remaining conditions)
	private static boolean canConstructPillar(int x, int y) {
		return y == 1 || pillars[x][y-1] || beams[x][y] || beams[x-1][y];
	}
	
	// Beam installation conditions
	//  1. When one end is on the pillar (pillars[x][y-1] or pillars[x+1][y-1])
	//  2. When both ends are connected to another beam at the same time (Remaining condition)
	private static boolean canConstructBeam(int x, int y) {
		return pillars[x][y-1] || pillars[x+1][y-1] || (beams[x-1][y] && beams[x+1][y]);
	}
	
	private static boolean canRemove(int x, int y, int n) {
		for(int i = 1; i <= n + 1; ++i) {
			for(int j = 1; j < n + 1; ++j) {
				if(pillars[i][j] && !canConstructPillar(i, j)) {
					return false;
				}
				if(beams[i][j] && !canConstructBeam(i, j)) {
					return false;
				}
			}
		}

		return true;
	}
}