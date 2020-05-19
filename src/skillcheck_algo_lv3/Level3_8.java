package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Key and Lock (2020 KAKAO BLIND RECRUITMENT)
public class Level3_8 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input_mn = br.readLine().split(", ");
		int M = Integer.parseInt(input_mn[0]);
		int N = Integer.parseInt(input_mn[1]);
		
		int[][] key = new int[M][M];
		int[][] lock = new int[N][N];
		
		for(int i = 0; i < key.length; i++) {
			String[] m = br.readLine().split(", ");
			for(int j = 0; j < m.length; j++) {
				key[i][j] = Integer.parseInt(m[j]);
			}
		}
		
		for(int i = 0; i < lock.length; i++) {
			String[] n = br.readLine().split(", ");
			for(int j = 0; j < n.length; j++) {
				lock[i][j] = Integer.parseInt(n[j]);
			}
		}
 		
		sb.append(solution(key, lock) + "");
		System.out.print(sb);
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int size = lock.length;
        int[][] padding_lock = new int[3*size-2][3*size-2];
        
        for(int i = size-1; i < 2*size-1; i++) {
        	System.arraycopy(lock[i-(size-1)], 0, padding_lock[i], size-1, lock[i-(size-1)].length);
        }
        return answer;
    }
}
