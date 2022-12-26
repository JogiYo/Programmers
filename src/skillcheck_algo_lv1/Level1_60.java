package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Programmers Level 1 : Substrings of small numbers
public class Level1_60 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String t = st.nextToken();
        String p = st.nextToken();

        sb.append(solution(t, p));
        System.out.print(sb);
    }

    private static int solution(String t, String p) {
        /* **Caution**
         * Since the length of p is between 1 and 18 digits, it is out of the range of int
         * That's why we compare with long.
         */
        int answer = 0;
        long pNum = Long.parseLong(p);
        int pNumLen = p.length();

        for(int i = 0; i <= t.length() - p.length(); ++i) {
            if(pNum >= Long.parseLong(t.substring(i, i + pNumLen))) answer++;
        }

        return answer;
    }
}