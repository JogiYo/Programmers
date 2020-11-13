package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Level3_32 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int n = Integer.parseInt(input[0]);
		long k = Long.parseLong(input[1]);
		
		int[] result = solution(n, k);
		
		for(int i = 0; i < result.length; i++) {
			if(i == 0) sb.append(result[i]);
			else sb.append(", " + result[i]);
		}
		System.out.print(sb);
	}
	
	static int count = 0;
	public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        int[] arr = new int[n];
        int[] output = new int[n];
        boolean[] visit = new boolean[n];
        
        for(int i = 0; i < n; i++) {
        	arr[i] = i+1;
        }
        
        perm(arr, output, visit, 0, n, n, answer, k);
        return answer;
    }

	private static void perm(int[] arr, int[] output, boolean[] visit, int depth, int n, int r, int[] answer, long k) {
		if(depth == r) {
			count++;
			if((int)k == count) {
				for(int i = 0; i < r; i++) {
					answer[i] = output[i];
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visit, depth+1, n, r, answer, k);
				visit[i] = false;
				if(count == (int) k) break;
			}
		}
		
	}
}