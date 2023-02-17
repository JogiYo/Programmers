package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Level2_94 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] maps = new String[n];

        for(int i = 0; i < n; ++i) {
            maps[i] = br.readLine();
        }

        sb.append(solution(maps));
        System.out.print(sb);
    }

    private static int solution(String[] maps) {
        int[][] maze = new int[maps.length][maps[0].length()];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int sx = 0, sy = 0;
        int ex = -1, ey = -1;

        for(int i = 0; i < maze.length; ++i) {
            for(int j = 0; j < maze[0].length; ++j) {
                if(maps[i].charAt(j) == 'X') maze[i][j] = 0;
                else if(maps[i].charAt(j) == 'S') {
                    maze[i][j] = 0;
                    sx = i;
                    sy = j;
                }
                else if(maps[i].charAt(j) == 'O' || maps[i].charAt(j) == 'L') maze[i][j] = 1;
                else if(maps[i].charAt(j) == 'E') {
                    maze[i][j] = -1;
                    ex = i;
                    ey = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});

        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            boolean flag = false;

            for(int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= maze.length || ny >= maze[0].length) continue;
                if(maze[nx][ny] == 0) continue;
                if(maze[nx][ny] == 1) {
                    maze[nx][ny] = maze[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
                if(maze[nx][ny] == -1) {
                    maze[nx][ny] = maze[x][y] + 1;
                    flag = true;
                }
            }

            if(flag) break;
        }

        return maze[ex][ey];
    }
}