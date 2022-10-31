package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Level 1 : Number Mate
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

    private static String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] x = new int[10];
        int[] y = new int[10];

        for(int i = 0; i < X.length(); ++i) {
            x[X.charAt(i) - '0']++;
        }

        for(int i = 0; i < Y.length(); ++i) {
            y[Y.charAt(i) - '0']++;
        }

        // Repeat common numbers in reverse order.
        for(int i = 9; i >= 0; --i) {
            answer.append(String.valueOf(i).repeat(Math.max(0, Math.min(x[i], y[i]))));
        }

        if(answer.toString().equals("")) return "-1";
        else if(answer.toString().startsWith("0")) return "0";
        else return answer.toString();
    }
}