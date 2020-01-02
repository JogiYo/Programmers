package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// Programmers Level 2 : Create the minimum value
// Using Arrays.sort
public class Level2_33 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] a_str = br.readLine().split(", ");
		String[] b_str = br.readLine().split(", ");
		
		int[] A = new int[a_str.length];
		int[] B = new int[b_str.length];
		
		for(int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(a_str[i]);
			B[i] = Integer.parseInt(b_str[i]);
		}
		
		sb.append(solution(A, B) + "");
		System.out.print(sb);
	}
	
	public static int solution(int[] A, int[] B) {
        int answer = 0;
        int len = A.length;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        // Minimum value = (a[0] * b[len-1]) + ... + (a[len-1] * b[0])
        for(int i = 0; i < len; i++) {
        	answer += A[i] * B[len-1-i];
        }
        
        return answer;
    }
}