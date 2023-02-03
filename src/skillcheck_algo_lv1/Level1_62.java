package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Programmers Level 1 : Our own code.
// use ASCII code
public class Level1_62 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String skip = st.nextToken();
        int index = Integer.parseInt(st.nextToken());

        sb.append(solution(s, skip, index));
        System.out.print(sb);
    }

    private static String solution(String s, String skip, int index) {
        String answer = "";

        /*
         * Since the lengths of s and skip are short,
         * a double for statement can be used.
         */
        for(int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);

            int count = 0;
            // Use ASCII code.
            // Repeat until counted as much as index.
            while(count < index) {
                ch = (char)(ch + 1);
                if(ch > 122) ch -= 26;

                if(skip.contains(Character.toString(ch))) continue;
                count++;
            }

            answer += ch;
        }

        return answer;
    }
}
