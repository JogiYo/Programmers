package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Programmers Level 1 : Hall of honors
// use PriorityQueue
public class Level1_57 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        
        int k = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] score = new int[st.countTokens()];

        for(int i = 0; i  < score.length; ++i) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(k, score);
        for (int j : result) {
            sb.append(j).append(" ");
        }
        System.out.print(sb);
    }

    private static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < score.length; ++i) {
            pq.offer(score[i]);
            if(pq.size() > k) {
                pq.poll();
            }

            answer[i] = pq.peek();
        }

        return answer;
    }
}