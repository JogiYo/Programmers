package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Level1_44 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        sb.append(solution(s) + "");
        System.out.print(sb);
    }

    private static int solution(String s) {
        String[] str_arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < str_arr.length; ++i) {
            s = s.replaceAll(str_arr[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}