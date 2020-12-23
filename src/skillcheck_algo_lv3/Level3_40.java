package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// Programmers Level 3 : Number game
// After sorting the two arrays in ascending order, Solve in linear time
public class Level3_40 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input_a = br.readLine().split(", ");
		String[] input_b = br.readLine().split(", ");
		int[] A = new int[input_a.length];
		int[] B = new int[input_b.length];
		
		for(int i = 0; i < input_a.length; ++i) {
			A[i] = Integer.parseInt(input_a[i]);
			B[i] = Integer.parseInt(input_b[i]);
		}
		
		sb.append(solution(A,B) + "");
		System.out.print(sb);
	}
	
	public static int solution(int[] A, int[] B) {
        int answer = 0;
        int a_idx = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int b_idx = 0; b_idx < A.length; ++b_idx) {
        	if(A[a_idx] < B[b_idx]) {
        		a_idx++;
        		answer++;
        	}
        }
        return answer;
    }
}