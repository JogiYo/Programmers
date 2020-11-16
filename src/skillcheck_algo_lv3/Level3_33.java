package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// Programmers Level 3 : The Change
// using Dynamic Programming
// refferce blog : https://tosuccess.tistory.com/57
public class Level3_33 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(",");
		int[] money = new int[input.length];
		
		for(int i = 0; i < money.length; i++) {
			money[i] = Integer.parseInt(input[i]);
		}
		
		sb.append(solution(n, money) + "");
		System.out.print(sb);
	}

	public static int solution(int n, int[] money) {
        int answer = 0;

        int[] dp = new int[n+1];
        int mod = 1000000007;
        
        Arrays.sort(money);
        dp[0] = 1;
        
        for(int i = 0; i < money.length; i++) {
        	for(int j = money[i]; j <= n; j++) {
        		dp[j] = (dp[j] + dp[j - money[i]]) % mod;
        	}
        }
        
        answer = dp[n];
        return answer;
    }
}