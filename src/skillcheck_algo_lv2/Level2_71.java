package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Find the number of decimals in k base
// implementation
public class Level2_71 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        sb.append(solution(n, k) + "");

        System.out.print(sb);
    }

    public static int solution(int n, int k) {
        int answer = 0;
        StringBuilder str = new StringBuilder();

        // Convert to decimals in k base
        while(n >= k) {
            str.insert(0, n%k);
            n /= k;
        }
        str.insert(0, n);

        String conv = str.toString();
        // temp is P
        long temp = 0L;
        for(int i = 0; i < conv.length(); ++i) {
            /*
             * When it encounters 0, Check if P is prime.
             * If it is a prime number, add the number and initialize P.
             */
            if(conv.charAt(i) == '0') {
                if(temp != 0L && isPrime(temp)) {
                    answer++;
                }
                temp = 0L;
            }
            else {
                temp = temp * 10 + conv.charAt(i) - '0';
            }
        }

        /*
         * After looping through the for loop, check because 0P may exist.
         */
        if(temp % 10 != 0L && isPrime(temp)) answer++;

        return answer;
    }

    private static boolean isPrime(long num) {
        if(num == 1) return false;

        int square = (int) Math.sqrt(num);
        for(int i = 2; i <= square; ++i) {
            if(num % i == 0) return false;
        }

        return true;
    }
}
