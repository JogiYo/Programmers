package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Wallpaper cleanup
// simple comparison
public class Level1_65 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] wallpaper = new String[n];

        for(int i = 0; i < n; ++i) {
            wallpaper[i] = br.readLine();
        }

        int[] result = solution(wallpaper);
        sb.append(result[0]);
        for(int i = 1; i < 4; ++i) {
            sb.append(", ").append(result[i]);
        }

        System.out.print(sb);
    }

    private static int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE, luy = Integer.MAX_VALUE, rdx = Integer.MIN_VALUE, rdy = Integer.MIN_VALUE;

        for(int i = 0; i < wallpaper.length; ++i) {
            for(int j = 0; j < wallpaper[i].length(); ++j) {
                if(wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i+1);
                    rdy = Math.max(rdy, j+1);
                }
            }
        }

        return new int[]{lux, luy, rdx, rdy};
    }
}
