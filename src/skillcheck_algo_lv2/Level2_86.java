package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Magical Elevator
public class Level2_86 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int storey = Integer.parseInt(br.readLine());

        sb.append(solution(storey));
        System.out.print(sb);
    }

    private static int solution(int storey) {
        int answer = 0;

        while(storey != 0) {
            int num = storey % 10;

            if(num < 5) {
                answer += num;
                storey -= num;
            }
            else if(num > 5){
                answer += (10 - num);
                storey += (10 - num);
            }
            /*
             * When the digit of 1 is 5,
             * the preceding digit must be considered.
             * If the leading digit is 5 or higher,
             * it is advantageous to go up.
             * On the contrary, going down is an advantage.
             */
            else {
                int temp = storey / 10;
                answer += 5;
                if(temp % 10 >= 5) {
                    storey += 5;
                }
            }

            storey /= 10;
        }

        return answer;
    }
}