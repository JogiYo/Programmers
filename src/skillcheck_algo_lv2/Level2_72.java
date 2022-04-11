package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Level2_72 {
    static int[] res = {-1};
    static int[] ryan;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(",");
        int[] info = new int[input.length];

        for(int i = 0; i < info.length; ++i) {
            info[i] = Integer.parseInt(input[i]);
        }

        res = solution(n, info);

        for(int i = 0; i < res.length; ++i) {
            sb.append(res[i] + " ");
        }
        System.out.print(sb);
    }

    public static int[] solution(int n, int[] info) {
        ryan = new int[11];
        dfs(info, 1, n);
        return res;
    }

    private static void dfs(int[] info, int cnt, int n) {

    }
}
