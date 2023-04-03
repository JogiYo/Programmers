package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level1_67 {
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

        int[][] result = solution(park, routes);
        System.out.print(sb);
    }

    private static int[][] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int sRow = 0, sCol = 0;
        char[][] arr = new char[park.length][park[0].length()];
        for(int i = 0; i < arr.length; ++i) {
            String input = park[i];
            for(int j = 0; j < input.length(); ++j) {
                arr[i][j] = input.charAt(j);
                if(arr[i][j] == 'S') {
                    sRow = i;
                    sCol = j;
                }
            }
        }

        int nRow = sRow, nCol = sCol;
        for(int i = 0; i < routes.length; ++i) {
            String[] str = routes[i].split(" ");
            char op = str[0].charAt(0);
            int dist = Integer.parseInt(str[1]);
        }

        return answer;
    }
}