package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// Programmers Level 1 : Coke problem
// use loop
public class Level1_50 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        sb.append(solution(a, b, n));
        System.out.print(sb);
    }

    public static int solution(int a, int b, int n) {
        int answer = 0;
        int remainder;

        while(a <= n) {
            answer += b*(n/a);
            remainder = n%a;
            n = b*(n/a) + remainder;
        }

        return answer;
    }
}