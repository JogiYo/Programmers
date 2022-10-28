package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level1_53 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        String x = st.nextToken();
        String y = st.nextToken();

        sb.append(solution(x, y));
        System.out.print(sb);
    }

    private static String solution(String x, String y) {
        if(x.length() > y.length()) {
            String temp = x;
            x = y;
            y = temp;
        }

        
    }
}
