package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// Programmers Level 1 : Remove the smallest number
// short coding : Using Arrays.stream
public class Level1_23_short {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int[] arr = new int[input.length];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		int[] ans = solution(arr);
		for(int i = 0; i < ans.length; i++) sb.append(ans[i] + " ");
		System.out.print(sb);
	}
	
	public static int[] solution(int[] arr) {
		if(arr.length <= 1) return new int[] {-1};
		
		int min = Arrays.stream(arr).min().getAsInt();
		return Arrays.stream(arr).filter(i -> i != min).toArray();
	}
}