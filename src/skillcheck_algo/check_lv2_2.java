package skillcheck_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class check_lv2_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int brown = Integer.parseInt(input[0]);
		int red = Integer.parseInt(input[1]);
		
		int[] answer = solution(brown, red);
		sb.append(answer);
		System.out.print(sb);
	}
	
	public static int[] solution(int brown, int red) {
		int[] answer = new int[2];
		return answer;
	}
}