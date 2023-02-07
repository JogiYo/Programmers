package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

// Programmers Level 2 : Uninhabited island travel
// use recursive function or BFS
public class Level2_92 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] maps = new String[n];

        for(int i = 0; i < n; ++i) {
            maps[i] = br.readLine();
        }

        int[] result = solution(maps);

        sb.append(result[0]);
        for(int i = 1; i < result.length; ++i) {
            sb.append(" ").append(result[i]);
        }

        System.out.print(sb);
    }

    private static int[] solution(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();
        int[][] arr = new int[maps.length][maps[0].length()];
        boolean[][] visit = new boolean[arr.length][arr[0].length];

        for(int i = 0; i < maps.length; ++i) {
            String[] str = maps[i].split("");
            for(int j = 0; j < str.length; ++j) {
                if(str[j].equals("X")) arr[i][j] = 0;
                else arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i = 0; i < arr.length; ++i) {
            for(int j = 0; j < arr[0].length; ++j) {
                int area = findMap(arr, visit, i, j);
                if(area > 0) list.add(area);
            }
        }
        // sort ascending
        list.sort(Comparator.comparingInt(a -> a));

        return list.isEmpty() ? new int[] {-1} : list.stream().mapToInt(i -> i).toArray();
    }

    private static int findMap(int[][] arr, boolean[][] visit, int row, int col) {
        // Range validation check
        if(row < 0 || col < 0 || row == arr.length || col == arr[0].length) return 0;
        // Check if visited or possibility of visit
        if(visit[row][col] || arr[row][col] == 0) return 0;

        visit[row][col] = true;
        int area = arr[row][col];

        // Inspection up and down left and right
        area += findMap(arr ,visit, row + 1, col);
        area += findMap(arr ,visit, row - 1, col);
        area += findMap(arr ,visit, row, col + 1);
        area += findMap(arr ,visit, row, col - 1);

        return area;
    }
}
