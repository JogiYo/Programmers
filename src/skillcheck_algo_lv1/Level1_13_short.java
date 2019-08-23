package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// Level 1_13 : find kim in seoul (short coding) 
public class Level1_13_short {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		sb.append(solution(input) + "");
		System.out.print(sb);
	}
	
	public static String solution(String[] seoul) {
		return "김서방은 " + Arrays.asList(seoul).indexOf("Kim") +"에 있다";
	}
}