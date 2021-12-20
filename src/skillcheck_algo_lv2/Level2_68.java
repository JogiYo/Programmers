package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

// Programmers Level 2 : star at intersection
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
        String[] answer = {};
        HashSet<Point> set = new HashSet<>();

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

                long denominator = (a * d) - (b * c);
                if(denominator == 0) continue;

                long num1 = (b*f - e*d);
                long num2 = (e*c - a*f);
                if(num1 % denominator != 0 || num2 % denominator != 0) continue;

                int x = (int) (num1 / denominator);
                int y = (int) (num2 / denominator);

                x_min = Math.min(x_min, x);
                y_min = Math.min(y_min, y);
                x_max = Math.max(x_max, x);
                y_max = Math.max(y_max, y);

                set.add(new Point(x, y));
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

        long row, col;
        for(Point p : set) {
            row = Math.abs(p.y - y_max);
            col = Math.abs(p.x - x_min);
            answer[(int)row] = answer[(int)row].substring(0, (int)col) + "*"
                    + answer[(int)row].substring((int)col + 1);
        }

        return answer;
    }

    private static class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
