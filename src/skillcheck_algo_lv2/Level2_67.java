package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// Programmers Level 2 : check the distance
// use BFS
public class Level2_67 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[][] places = new String[n][5];

        for(int i = 0; i < n; ++i) {
            places[i] = br.readLine().split(", ");
        }

        int[] result = solution(places);
        for(int num : result) {
            sb.append(num + " ");
        }
        System.out.print(sb);
    }

    private static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i = 0; i < places.length; ++i) {
            String[] place = places[i];
            boolean isValid = true;

            for(int r = 0; r < 5; ++r) {
                for(int c = 0; c < 5; ++c) {
                    // 'P'일 경우를 확인한다.
                    if(place[r].charAt(c) == 'P') {
                        if(!bfs(place, r, c)) {
                            isValid = false;
                            break;
                        }
                    }
                }
                if(!isValid) break;
            }
            answer[i] = isValid ? 1 : 0;
        }

        return answer;
    }

    private static boolean bfs(String[] place, int r, int c) {
        int[] mr = {-1, 1, 0, 0};
        int[] mc = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r, c});

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();

            for(int i = 0; i < 4; ++i) {
                int nr = pos[0] + mr[i];
                int nc = pos[1] + mc[i];

                if(nr < 0 || nc < 0 || nr > 4 || nc > 4 || (nr == r && nc == c)) continue;

                // manhattan distance
                int distance = Math.abs(nr - r) + Math.abs(nc - c);

                // 거리가 2 이하이고, P라면 거짓을 리턴
                if(place[nr].charAt(nc) == 'P' && distance <= 2) return false;
                // 거리가 2 미만이고, O라면 큐에 삽입한다.
                else if(place[nr].charAt(nc) == 'O' && distance < 2) queue.offer(new int[] {nr, nc});
            }
        }

        return true;
    }
}
