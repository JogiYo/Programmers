package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Programmers Level 2 : Hail sequence definite integral
// use cumulative sum
public class Level2_83 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        int rangeNum = Integer.parseInt(br.readLine());
        int[][] ranges = new int[rangeNum][2];

        for(int i = 0; i < rangeNum; ++i) {
            st = new StringTokenizer(br.readLine());
            ranges[i][0] = Integer.parseInt(st.nextToken());
            ranges[i][1] = Integer.parseInt(st.nextToken());
        }

        double[] result = solution(k, ranges);

        sb.append(result[0]);
        for(int i = 1; i < result.length; ++i) {
            sb.append(" ").append(result[i]);
        }
        System.out.print(sb);
    }

    private static double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        // Check how many times k becomes 1 by Collatz conjecture
        int cnt = count(k);

        double[] yVal = new double[cnt+1];
        yVal[0] = k;
        for(int i = 1; i < cnt+1; ++i) {
            double previousVal = yVal[i-1];
            yVal[i] = calYVal(previousVal);
        }

        // Araa of Trapezoid
        double[] area = new double[cnt+1];
        for(int i = 1; i < cnt+1; ++i) {
            area[i] = (yVal[i-1] + yVal[i])/2;
        }

        // Cumulative sum of areas
        double[] cumulSum = new double[cnt+1];
        cumulSum[1] = area[1];
        for(int i = 2; i < cnt+1; ++i) {
            cumulSum[i] = area[i] + cumulSum[i-1];
        }

        for(int i = 0; i < ranges.length; ++i) {
            int start = ranges[i][0];
            int end = cnt + ranges[i][1];

            // definite integral from start to end (area)
            if(end > start) {
                double integral = cumulSum[end] - cumulSum[start];

                // The condition is to display only one decimal place.
                String str = String.format("%.1f", integral);
                answer[i] = Double.parseDouble(str);
            }
            else if(start > end) answer[i] = -1.0;
            else answer[i] = 0.0;
        }

        return answer;
    }

    private static double calYVal(double previousVal) {
        if(previousVal % 2 == 0) return previousVal/2;
        return (3*previousVal) + 1;
    }

    private static int count(int k) {
        int cnt = 0;
        while(k > 1) {
            if(k%2 == 0) k /= 2;
            else k = (k*3) + 1;
            cnt++;
        }
        return cnt;
    }
}
