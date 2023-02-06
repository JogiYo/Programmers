package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Programmers Level 2 : Rent a hotel room
// use PriorityQueue(Min-heap)
public class Level2_91 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String[][] book_time = new String[n][2];

        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            book_time[i][0] = st.nextToken();
            book_time[i][1] = st.nextToken();
        }

        sb.append(solution(book_time));
        System.out.print(sb);
    }

    private static int solution(String[][] book_time) {
        int answer = 0;

        int[][] book_time_minute = new int[book_time.length][2];

        for(int i = 0; i < book_time.length; ++i) {
            book_time_minute[i][0] = calMinutes(book_time[i][0]);
            book_time_minute[i][1] = calMinutes(book_time[i][1]) + 10;
        }

        // Sort by check-in time in ascending order
        Arrays.sort(book_time_minute, Comparator.comparingInt(a -> a[0]));

        // Heap by check-out time in ascending order(Min-Heap)
        PriorityQueue<int[]> roomInuse = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for(int i = 0; i < book_time_minute.length; ++i) {
            // Poll for rooms that are cleaned up by the next check-in time
            while(!roomInuse.isEmpty() && roomInuse.peek()[1] <= book_time_minute[i][0]) {
                roomInuse.poll();
            }

            roomInuse.add(book_time_minute[i]);
            answer = Math.max(answer, roomInuse.size());
        }

        return answer;
    }

    private static int calMinutes(String time) {
        String[] hour_minute = time.split(":");
        return Integer.parseInt(hour_minute[0])*60 + Integer.parseInt(hour_minute[1]);
    }
}
