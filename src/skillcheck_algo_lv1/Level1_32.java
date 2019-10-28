package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : secret map (2018 KAKAO BLIND RECRUITMENT)
// using decimal to binary
public class Level1_32 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		
		String[] input1 = br.readLine().split(" ");
		String[] input2 = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(input1[i]);
			arr2[i] = Integer.parseInt(input2[i]);
		}
		String[] ans = solution(n, arr1, arr2);
		for(int i = 0; i < n; i++) {
			sb.append(ans[i] +"\n");
		}
		System.out.print(sb);
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		
		for(int i = 0; i < n; i++) {
			String conv_arr1_num = Integer.toBinaryString(arr1[i]);
			String conv_arr2_num = Integer.toBinaryString(arr2[i]);
			
			// padding 0
			if(conv_arr1_num.length() < n) {
				while(conv_arr1_num.length() < n) {
					conv_arr1_num = "0" + conv_arr1_num;
				}
			}
			if(conv_arr2_num.length() < n) {
				while(conv_arr2_num.length() < n) {
					conv_arr2_num = "0" + conv_arr2_num;
				}
			}
			
			// compare conv_arr1_num with conv_arr2_num
			String str = "";
			for(int j = 0; j < n; j++) {
				if(conv_arr1_num.charAt(j) == '0' && conv_arr2_num.charAt(j) == '0') str += " ";
				else str += "#";
			}
			answer[i] = str;
		}	
		return answer;
	}
}