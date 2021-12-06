package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Programmers Level 2 : Split the power grid in two
// use adjacency list and bfs
public class Level2_65 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] wires1 = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int[][] wires2 = {{1, 2}, {2, 3}, {3, 4}};
        int[][] wires3 = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
        sb.append(solution(9, wires1) + "\n");
        sb.append(solution(4, wires2) + "\n");
        sb.append(solution(7, wires3) + "\n");
        System.out.print(sb);
    }

    static List<Integer>[] list;

    private static int solution(int n, int[][] wires) {
        int answer = 100;

        list = new ArrayList[n+1];
        for(int i = 0; i < n+1; ++i) {
            list[i] = new ArrayList<>();
        }

        // 연결하기
        for(int[] wire : wires) {
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }

        // 하나씩 끊었을 때 비교
        for(int[] wire : wires) {
            int a = bfs(wire[0], wire[1], n);
            int b = bfs(wire[1], wire[0], n);

            answer = Math.min(answer, Math.abs(a - b));
        }

        return answer;
    }

    private static int bfs(int a, int b, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];

        int count = 0;
        visit[a] = true;
        queue.add(a);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            count++;

            for(int next : list[cur]) {
                if(next != b && !visit[next]) {
                    queue.add(next);
                    visit[next] = true;
                }
            }
        }

        return count;
    }
}
