package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level2_100 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());

        long result = solution(r1, r2);
        sb.append(result);
        System.out.print(sb);
    }

    private static long solution(int r1, int r2) {
        long r1Count = (long)(4 + Math.pow(2*r1-1, 2));
        long r2Count = (long)(4 + Math.pow(2*r2-1, 2));

        return r2Count - r1Count + 4;
    }
}
