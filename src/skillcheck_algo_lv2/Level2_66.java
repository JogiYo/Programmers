package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Truncate n^2 Array
public class Level2_66 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(", ");
        int n = Integer.parseInt(input[0]);
        int left = Integer.parseInt(input[1]);
        int right = Integer.parseInt(input[2]);

        int[] result = solution(n, left, right);
        for(int num : result) {
            sb.append(num + " ");
        }
        System.out.print(sb);
    }

    private static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        int count = 0;
        long i = left;
        while(i <= right) {
            long quotient = i / n;
            long remainder = i % n;
            answer[count++] = (int)(Math.max(quotient, remainder) + 1);
            i++;
        }

        return answer;
    }
}
