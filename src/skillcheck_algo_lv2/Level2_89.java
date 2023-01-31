package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Programmers Level 2 : Converting numbers
public class Level2_89 {
    private static int[] visitCount = new int[10000001];
    private static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());


        sb.append(solution(x,y,n));
        System.out.print(sb);
    }

    // use HashSet
    public static int solution(int x, int y, int n) {
        int cnt = 0;
        HashSet<Integer> curSet = new HashSet<>(), nextSet = null;
        curSet.add(x);

        while (!curSet.isEmpty()) {
            // Find out if there is a number.
            if (curSet.contains(y)) return cnt;

            nextSet = new HashSet<>();
            for(int num : curSet) {
                int plusNum = num + n;
                int doubleNum = num * 2;
                int tripleNum = num * 3;
                if(plusNum <= y) nextSet.add(plusNum);
                if(doubleNum <= y) nextSet.add(doubleNum);
                if(tripleNum <= y) nextSet.add(tripleNum);
            }
            curSet = nextSet;
            cnt++;
        }

        return -1;
    }

    // use bfs
    public static int solution_bfs(int x, int y, int n) {
        queue.offer(x);

        while(!queue.isEmpty()) {
            int value = queue.poll();
            if(value == y) return visitCount[value];

            addQueue(y, value, value + n);
            addQueue(y, value, value * 2);
            addQueue(y, value, value * 3);
        }

        return -1;
    }

    private static void addQueue(int y, int value, int next) {
        if(next <= y && visitCount[next] == 0) {
            queue.offer(next);
            visitCount[next] = visitCount[value] + 1;
        }
    }
}