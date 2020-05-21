package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Key and Lock (2020 KAKAO BLIND RECRUITMENT)
// using brute force
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
        
        // Create an empty space surrounding the lock
        for(int i = size-1; i < 2*size-1; i++) {
        	System.arraycopy(lock[i-(size-1)], 0, padding_lock[i], size-1, lock[i-(size-1)].length);
        }
        
        int padding_size = padding_lock.length;
        int key_size = key.length;
        
        // brute force after rotation
        for(int i = 0; i < 4; i++) {
        	key = rotate(key);
        	
        	int[][] copy = new int[padding_size][padding_size];
        	for(int x = 0; x <= padding_size - key_size; x++) {
        		for(int y = 0; y <= padding_size - key_size; y++) {
        			for(int j = 0; j < padding_size; j++) {
        				System.arraycopy(padding_lock[j], 0, copy[j], 0, padding_size);
        			}
        			
        			for(int j = 0; j < key_size; j++) {
        				for(int k = 0; k < key_size; k++) {
        					copy[j+x][k+y] += key[j][k];
        				}
        			}
        			
        			if(un_lock(copy, size)) {
        				return true;
        			}
        		}
        	}
        }
        return answer;
    }

	private static boolean un_lock(int[][] copy, int size) {
		for(int i = size-1; i < size*2-1; i++) {
			for(int j = size-1; j < size*2-1; j++) {
				if(copy[i][j] != 1) return false;
			}
		}
		return true;
	}

	private static int[][] rotate(int[][] key) {
		int[][] rot = new int[key.length][key[0].length];
		
		// rotate 90. key[i][j] -> rot[i][j] = key[j][key[0].length-i-1]
		for(int i = 0; i < key.length; i++) {
			for(int j = 0; j < key[0].length; j++) {
				rot[i][j] = key[j][key[0].length-i-1];
			}
		}
		return rot;
	}
}
