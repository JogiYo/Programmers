package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Programmers Level 2 : light path cycle
// implementation
public class Level2_69 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] grid = br.readLine().split(", ");

        int[] result = solution(grid);
        for(int num : result) {
            sb.append(num + " ");
        }
        System.out.print(sb);
    }

    static int R, C;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1};
    static boolean[][][] visited;

    private static int[] solution(String[] grid) {
        ArrayList<Integer> list = new ArrayList<>();

        R = grid.length;
        C = grid[0].length();
        visited = new boolean[R][C][4];

        for(int i = 0; i < R; ++i) {
            for(int j = 0; j < C; ++j) {
                for(int d = 0; d < 4; ++d) {
                    if(!visited[i][j][d]) {
                        list.add(dist(grid, i, j, d));
                    }
                }
            }
        }
        return list.stream().sorted().mapToInt(i -> i).toArray();
    }

    private static Integer dist(String[] grid, int r, int c, int d) {
        int distance = 0;

        while(true) {
            if(visited[r][c][d]) break;

            distance++;
            visited[r][c][d] = true;

            if (grid[r].charAt(c) == 'L') d = d == 0 ? 3 : d - 1; // 좌회전
            else if (grid[r].charAt(c) == 'R') d = d == 3 ? 0 : d + 1; // 우회전

            // 범위를 벗어날 수 있기 때문에 +R or +C를 하는 것이다.
            r = (r + dr[d] + R) % R;
            c = (c + dc[d] + C) % C;
        }

        return distance;
    }
}
