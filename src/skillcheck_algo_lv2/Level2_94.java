package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// Programmers Level 2 : Escape the maze
// use BFS
public class Level2_94 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
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
        // S to L -> L to S
        int StoL = bfs(maps, 'S', 'L');
        int LtoE = bfs(maps, 'L', 'E');

        if(StoL == -1 || LtoE == -1) return -1;
        return StoL + LtoE;
    }

    private static int bfs(String[] maps, char start, char end) {
        boolean[][] maze = new boolean[maps.length][maps[0].length()];
        int sx = -1, sy = -1;

        for(int i = 0; i < maze.length; ++i) {
            for(int j = 0; j < maze[0].length; ++j) {
                if(maps[i].charAt(j) == start) {
                    sx = i;
                    sy = j;
                    break;
                }
            }
            if(sx != -1) break;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy, 0});
        maze[sx][sy] = true;

        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            int depth = point[2];

            if(maps[x].charAt(y) == end) return depth;

            for(int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= maze.length || ny >= maze[0].length) continue;
                if(maps[nx].charAt(ny) != 'X' && !maze[nx][ny]) {
                    queue.offer(new int[]{nx, ny, depth+1});
                    maze[nx][ny] = true;
                }
            }
        }

        return -1;
    }
}