package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Programmers Level 2 : Make the sum of two queues equal (2022 KAKAO TECH INTERNSHIP)
// use Greedy Algorithm & Queue
public class Level2_75 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int[] queue1 = new int[st.countTokens()];
        for(int i = 0; i < queue1.length; ++i) {
            queue1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] queue2 = new int[st.countTokens()];
        for(int i = 0; i < queue1.length; ++i) {
            queue2[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(solution(queue1, queue2));
        System.out.print(sb);
    }

    private static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0, sum2 = 0, sum;

        for(int temp : queue1) {
            q1.offer(temp);
            sum1 += temp;
        }

        for(int temp : queue2) {
            q2.offer(temp);
            sum2 += temp;
        }

        sum = sum1 + sum2;

        // If the sum is odd, both sums cannot be equal.
        if(sum%2 == 1) return -1;

        int c1 = 0, c2 = 0, limit = queue1.length*2;
        // Greedy algorithm
        while(c1 <= limit && c2 <= limit) {
            if(sum1 == sum2) return c1+c2;

            if(sum1 > sum2) {
                c1++;
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.offer(q1.poll());
            }
            else {
                c2++;
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.offer(q2.poll());
            }
        }

        return -1;
    }
}