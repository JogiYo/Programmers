package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// Programmers Level 1 : Calculate insufficient amount
// use sum of arithmetic sequences
public class Level1_46 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(", ");

        sb.append(solution(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])) + "");
        System.out.print(sb);
    }

    // The total number of times is the sum of the arithmetic sequence.
    // The important thing is that the range can be exceeded when calculating in int type.
    // It needs to be cast to long type.
    private static long solution(int price, int money, int count) {
        return Math.max(((long) count * (count + 1) / 2) * price - money, 0);
    }
}
