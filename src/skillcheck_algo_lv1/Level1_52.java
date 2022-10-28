package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Level1_52 {
    static String[] pronun = {"aya", "ye", "woo", "ma"};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] babbling = br.readLine().split(" ");

        sb.append(solution(babbling));
        System.out.print(sb);
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        for (String s : babbling) {
            String temp = s;
            int length = temp.length();
            int cur = -1;

            boolean check = false;
            // 연속체크
            for (int j = 0; j < 4; ++j) {
                String str = pronun[j] + pronun[j];
                if(s.contains(str)) {
                    check = true;
                    break;
                }
            }

            if(check) continue;

            for (int j = 0; j < 4; ++j) {
                if (temp.contains(pronun[j]) && cur != j) {
                    if (j == 0 || j == 2) {
                        temp = temp.replaceFirst(pronun[j], "000");
                    } else {
                        temp = temp.replaceFirst(pronun[j], "00");
                    }

                    cur = j;
                    j = -1;
                }
            }

            int count = 0;
            for (int k = 0; k < temp.length(); ++k) {
                if (temp.charAt(k) == '0') count++;
            }

            if (count == length) answer++;
        }
        return answer;
    }
}