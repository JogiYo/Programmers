package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// Programmers Level 2 : the maximum and the maximum value
// Using String to Integer conversion
public class Level2_32 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String s = br.readLine();
		sb.append(solution(s) + "");
		System.out.print(sb);
	}
	
	public static String solution(String s) {
        String answer = "";
        
        String[] str = s.split(" ");
        int[] arr = new int[str.length];
        
        for(int i = 0; i < arr.length; i++) {
        	arr[i] = Integer.parseInt(str[i]);
        }
        
        Arrays.sort(arr);
        answer = arr[0] + " " + arr[arr.length-1];
        
        return answer;
    }
}