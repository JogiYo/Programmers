package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level2_87 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long l = Long.parseLong(st.nextToken());
        long r = Long.parseLong(st.nextToken());

        sb.append(solution(n, l, r));
        System.out.print(sb);
    }

    private static int solution(int n, long l, long r) {
        /*
         * n=0, 1
         * n=1, 11011
         * n=2, 11011 11011 00000 11011 11011
         */
        int answer = 0;

        return answer;
    }
}
