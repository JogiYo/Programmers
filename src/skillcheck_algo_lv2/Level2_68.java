package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Level2_68 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] line = new int[n][3];

        for(int i = 0; i < n; ++i) {
            String[] input = br.readLine().split(" ");
            line[i][0] = Integer.parseInt(input[0]);
            line[i][1] = Integer.parseInt(input[1]);
            line[i][2] = Integer.parseInt(input[2]);
        }

        String[] result = solution(line);
        for(String s : result) {
            sb.append(s + "\n");
        }
        System.out.print(sb);
    }

    private static String[] solution(int[][] line) {
        String[] answer;
        ArrayList<int[]> list = new ArrayList<>();
        int x_min = Integer.MAX_VALUE, x_max = Integer.MIN_VALUE;
        int y_min = Integer.MAX_VALUE, y_max = Integer.MIN_VALUE;

        for(int i = 0; i < line.length - 1; ++i) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];

            for(int j = i + 1; j < line.length; ++j) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                if(a*d - b*c == 0) continue;
                long num1 = (b*f - e*d);
                long num2 = (e*c - a*f);
                if(num1 % (a*d - b*c) != 0 || num2 % (a*d - b*c) != 0) continue;

                int x = (int) (num1 / (a*d - b*c));
                int y = (int) (num2 / (a*d - b*c));

                x_min = Math.min(x_min, x);
                y_min = Math.min(y_min, y);
                x_max = Math.max(x_max, x);
                y_max = Math.max(y_max, y);

                list.add(new int[] {x, y});
            }
        }

        long height = y_max - y_min + 1;
        long width = x_max - x_min + 1;
        answer = new String[(int)height];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < width; ++i) {
            sb.append(".");
        }

        Arrays.fill(answer, sb.toString());

        for(int[] l : list) {
            int row = Math.abs(l[1] - y_max);
            int col = Math.abs(l[0] + x_max);

            char[] charArray = answer[row].toCharArray();
            charArray[col] = '*';
            answer[row] = String.valueOf(charArray);
        }

        return answer;
    }
}
