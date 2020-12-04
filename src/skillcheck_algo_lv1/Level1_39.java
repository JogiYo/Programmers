package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

// Programmers Level 1 : Dot product
// using sol 1 : loop, sol 2 : stream
// The loop was more efficient than the stream.
public class Level1_39 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input_a = br.readLine().split(",");
		String[] input_b = br.readLine().split(",");
		
		int[] a = new int[input_a.length];
		int[] b = new int[input_b.length];
		
		for(int i = 0; i < a.length; ++i) {
			a[i] = Integer.parseInt(input_a[i]);
			b[i] = Integer.parseInt(input_b[i]);
		}
		sb.append(solution(a,b) + "\n");
		sb.append(solution_stream(a,b) + "");
		System.out.print(sb);
	}
	// Time was much faster than the method below.
	public static int solution(int[] a, int[] b) {
        int answer = 0;
        
        for(int i = 0; i < a.length; ++i) {
        	answer += a[i] * b[i];
        }
        return answer;
    }
	// It took longer than using the loop.
	public static int solution_stream(int[] a, int[] b) {
        return IntStream.range(0, a.length)
        		.map(index -> a[index] * b[index])
        		.sum();
    }
}