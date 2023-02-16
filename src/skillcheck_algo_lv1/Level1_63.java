package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Programmers Level 1 : Deck of cards
// use Queue
public class Level1_63 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] cards1 = br.readLine().split(" ");
        String[] cards2 = br.readLine().split(" ");
        String[] goal = br.readLine().split(" ");

        sb.append(solution(cards1, cards2, goal));

        System.out.print(sb);
    }

    private static String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> qGoal = new LinkedList<>();
        Queue<String> qCard1 = new LinkedList<>();
        Queue<String> qCard2 = new LinkedList<>();

        for(String str : goal) {
            qGoal.offer(str);
        }

        for(String card : cards1) {
            qCard1.offer(card);
        }

        for(String card : cards2) {
            qCard2.offer(card);
        }

        while(!qGoal.isEmpty()) {
            String str = qGoal.poll();

            if(str.equals(qCard1.peek())) qCard1.poll();
            else if(str.equals(qCard2.peek())) qCard2.poll();
            else return "No";
        }

        return "Yes";
    }
}