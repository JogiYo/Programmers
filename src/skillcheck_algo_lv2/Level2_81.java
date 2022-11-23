package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

// Programmers Level 2 : Master of playing alone
// use variant DFS
public class Level2_81 {
    static boolean[] visited; // Variable to check if a card has been drawn
    static int count; // The number of cards drawn in one run
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cards = new int[st.countTokens()];

        for(int i = 0; i  < cards.length; ++i) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(solution(cards));
        System.out.print(sb);
    }

    private static int solution(int[] cards) {
        visited = new boolean[cards.length];
        // list to store counts
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < cards.length; ++i) {
            if(visited[i]) continue;
            count = 1;
            visited[i] = true;
            openBox(cards, cards[i]-1);
            list.add(count);
        }
        // Sort the count stored in the list in descending order
        list.sort(Comparator.reverseOrder());

        // Since the minimum number of routines is 2, it returns 0 if the routine is 1.
        return list.size() == 1 ? 0 : list.get(0)*list.get(1);
    }

    private static void openBox(int[] cards, int index) {
        // If the card has already been drawn, the function is terminated.
        if(visited[index]) return;

        visited[index] = true;
        count++;
        // Take the card in the position of the number written on the card
        openBox(cards, cards[index]-1);
    }
}