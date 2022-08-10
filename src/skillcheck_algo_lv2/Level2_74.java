package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level2_74 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long begin = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        int[] result = solution(begin, end);

        System.out.print(sb);
    }

    public static int[] solution(long begin, long end) {
        int length = (int)(end-begin+1);
        int[] answer = new int[length];

        for(int i = (int) begin; i <= end; ++i) {
            
        }

        return answer;
    }
}
