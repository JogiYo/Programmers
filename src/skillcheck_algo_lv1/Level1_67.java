package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// Programmers Level 1 : Walk in the park
// Implementation
public class Level1_67 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] park = new String[st.countTokens()];
        for(int i = 0; i < park.length; ++i) {
            park[i] = st.nextToken();
        }

        int n = Integer.parseInt(br.readLine());
        String[] routes = new String[n];
        for(int i = 0; i < n; ++i) {
            routes[i] = br.readLine();
        }

        int[] result = solution(park, routes);
        sb.append(result[0]).append(" ").append(result[1]);
        System.out.print(sb);
    }

    private static int[] solution(String[] park, String[] routes) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('W', 0);
        hm.put('E', 1);
        hm.put('N', 2);
        hm.put('S', 3);

        int cRow = 0, cCol = 0;
        char[][] arr = new char[park.length][park[0].length()];
        for(int i = 0; i < arr.length; ++i) {
            String input = park[i];
            for(int j = 0; j < input.length(); ++j) {
                arr[i][j] = input.charAt(j);
                if(arr[i][j] == 'S') {
                    cRow = i;
                    cCol = j;
                }
            }
        }

        for(int i = 0; i < routes.length; ++i) {
            int nRow = cRow, nCol = cCol;
            String[] str = routes[i].split(" ");
            char op = str[0].charAt(0);
            int dist = Integer.parseInt(str[1]);
            boolean stop = false;

            while(dist-- > 0) {
                int idx = hm.get(op);
                nRow += dx[idx];
                nCol += dy[idx];

                if(nRow < 0 || nRow >= arr.length || nCol < 0 || nCol >= arr[0].length || arr[nRow][nCol] == 'X') {
                    stop = true;
                    break;
                }
            }

            if(!stop) {
                cRow = nRow;
                cCol = nCol;
            }
        }

        return new int[] {cRow, cCol};
    }
}