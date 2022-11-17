package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Programmers Level 1 : Templar's Weapon
// Implementation
public class Level1_55 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int power = Integer.parseInt(st.nextToken());

        sb.append(solution(number, limit, power));
        System.out.print(sb);
    }

    private static int solution(int number, int limit, int power) {
        int answer = 0;

        for(int i = 1; i <= number; ++i) {
            int count = 0;
            // Use the properties of divisors.
            // Add one square root, and add two for the rest.
            // ex) 16 <-- 1 2 4 8 16 : (1, 16), (2, 8), (4)
            for(int j = 1; j*j <= i; ++j) {
                if(j*j == i) count++;
                else if(i%j == 0) count += 2;
            }

            if(count > limit) answer += power;
            else answer += count;
        }

        return answer;
    }
}