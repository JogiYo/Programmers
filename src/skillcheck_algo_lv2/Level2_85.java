package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// Programmers Level 2 : Table Hash Function
// use Sort
public class Level2_85 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] data = new int[x][y];
        for(int i = 0; i < x; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < y; ++j) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row_begin = Integer.parseInt(st.nextToken());
        int row_end = Integer.parseInt(st.nextToken());

        sb.append(solution(data, col, row_begin, row_end));
        System.out.print(sb);
    }

    private static int solution(int[][] data, int col, int rowBegin, int rowEnd) {
        int answer = 0;

        // Arrays.sort(data,(o1, o2) -> o1[col-1] != o2[col-1] ? o1[col-1]- o2[col-1] : o2[0]- o1[0]);
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[col-1] == o2[col-1]) return o2[0] - o1[0];
                return o1[col-1] - o2[col-1];
            }
        });

        for(int i = rowBegin-1; i <= rowEnd-1; ++i) {
            int sum = 0;
            for(int j = 0; j < data[i].length; ++j) {
                sum += data[i][j] % (i+1);
            }

            answer ^= sum;
        }

        return answer;
    }
}