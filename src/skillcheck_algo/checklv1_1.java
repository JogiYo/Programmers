package skillcheck_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers, skillcheck_lv1
// Problem of adding each digit
public class checklv1_1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int result = solution(n);
		sb.append(result + "");
		System.out.print(sb);
	}
	
	public static int solution(int n) {
        int answer = 0;

        while(n != 0) {
            answer += n%10;
            n /= 10;
        }
        return answer;
    }
}