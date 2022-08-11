package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Programmers Level 2 : Number Block
// Apply the Sieve of Eratosthenes
public class Level2_74 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long begin = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        int[] result = solution(begin, end);

        sb.append(result[0]);
        for(int i = 1; i < result.length; ++i) {
            sb.append(" ").append(result[i]);
        }

        System.out.print(sb);
    }

    public static int[] solution(long begin, long end) {
        int beginInt = (int) begin;
        int endInt = (int) end;
        int[] answer = new int[endInt-beginInt+1];

        for(int i = beginInt; i <= endInt; ++i) {
            /*
             * The color of the block is the quotient divided
             * by the smallest prime number to be the color of the block.
             */
            answer[i - beginInt] = blockNumber(i);
        }

        return answer;
    }

    private static int blockNumber(int block_num) {
        if(block_num == 1) return 0;

        for(int i = 2; i <= Math.sqrt(block_num); ++i) {
            // filters because the number of blocks is less than 10000000.
            if(block_num % i == 0 && (block_num/i) <= 10000000) return block_num/i;
        }

        return 1; // Where the block number is prime, it cannot be divided.
    }
}