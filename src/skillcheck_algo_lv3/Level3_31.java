package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Hanoi Tower
// using recursive function
public class Level3_31 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		int[][] result = solution(n);
		
		for(int i = 0; i < result.length; i++) {
			sb.append(result[i][0] + "," + result[i][1] + "\n");
		}
		System.out.print(sb);
	}
	
	static int idx = 0;
	public static int[][] solution(int n) {
		// To move all the disks, you need to move (2 to the power of n) -1 times
		int count = (int)Math.pow(2, n) - 1;
        int[][] answer = new int[count][2];
        
        hanoi(answer, n, 1, 3, 2);
        return answer;
    }

	// algorithm (hanoi)
	// 1. If there is only one disk, move it immediately (end condition).
	// 2. When there are n disks
	//   2.1) Move n-1 of the n disks in Pillar 1 to Pillar 2.(Pillar 3 is used as an auxiliary.)
	//   2.2) Move the largest disk remaining in Pillar 1 to Pillar 3.
	//   2.3) Move the n-1 disks from pillar 2 to pillar 3.(Pillar 1 is used as an auxiliary.)
	private static void hanoi(int[][] answer, int n, int from, int to, int aux) {
		if(n == 1) {
			answer[idx][0] = from;
			answer[idx++][1] = to;
			return;
		}
		
		hanoi(answer, n-1, from, aux, to);
		answer[idx][0] = from;
		answer[idx++][1] = to;
		hanoi(answer, n-1, aux, to, from);
	}
}