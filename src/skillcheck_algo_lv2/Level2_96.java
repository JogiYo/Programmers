package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Programmers Level 2 : Paint over
// Using conditional statements
public class Level2_96 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] input = br.readLine().split(" ");
        int[] section = new int[input.length];
        for(int i = 0; i < input.length; ++i) {
            section[i] = Integer.parseInt(input[i]);
        }

        sb.append(solution(n, m, section));
        System.out.print(sb);
    }

    private static int solution(int n, int m, int[] section) {
        int answer = 0;
        int currentIdx = 0;

        for(int s : section) {
            if(currentIdx < s) {
                currentIdx = s + m - 1;
                answer++;
            }
        }

        return answer;
    }
}