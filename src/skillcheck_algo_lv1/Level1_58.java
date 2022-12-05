package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Programmers Level 1 : Split string
public class Level1_58 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        sb.append(solution(str));
        System.out.print(sb);
    }

    private static int solution(String s) {
        ArrayList<String> list = new ArrayList<>();

        char x = s.charAt(0);
        String str = "";
        int x_count = 0;
        int other_count = 0;

        int idx = 0;
        while(true) {
            if(idx >= s.length()) {
                list.add(str);
                break;
            }

            if(x == s.charAt(idx)) x_count++;
            else other_count++;

            str += s.charAt(idx);

            if(x_count == other_count) {
                list.add(str);
                s = s.substring(idx+1);
                if(s.length() == 0) break;

                x = s.charAt(0);
                str = "";
                idx = 0;
                x_count = 0;
                other_count = 0;
            }
            else idx++;
        }

        return list.size();
    }
}