package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : (binary <= n <= hexadecimal) number game (2018 KAKAO BLIND RECRUITMENT)
// 0 - F array is important
public class Level2_51 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int n = Integer.parseInt(input[0]);
		int t = Integer.parseInt(input[1]);
		int m = Integer.parseInt(input[2]);
		int p = Integer.parseInt(input[3]);
		
		sb.append(solution(n, t, m, p));
		
		System.out.print(sb);
	}
	
	public static String solution(int n, int t, int m, int p) {
		String answer = "";
		String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D" ,"E", "F"};
        
		String str = "0";
		int i = 1;
		int count = 1;
		// The maximum number of spoken numbers
		int total = t*m;
		while(count < total) {
			String temp = "";
			int num = i;
			// convert to desired
			while(num != 0) {
				temp = number[num%n] + temp;
				num /= n;
			}
			// add by the length because we speak one by one
			count += temp.length();
			str += temp;
			i++;
		}
		
		// Initially, the first person says the number at index zero
		for(int j = p-1; j < total; j += m) {
			answer += str.charAt(j);
		}
		
		return answer;
    }
}