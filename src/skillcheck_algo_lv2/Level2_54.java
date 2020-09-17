package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Level2_54 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		int[] result = solution(n);
		for(int i = 0; i < result.length; i++) {
			sb.append(result[i] + " ");
		}
		System.out.print(sb);
	}
	
	public static int[] solution(int n) {
		int[] answer;
		int max_num = 0;
		for(int i = 1; i <= n; i++) {
			max_num += i;
		}
		
		int[][] arr = new int[n][n];
		int num = 1;
		
		int x = -1, y = 0;
		while(num <= max_num) {
			x++;
			while(x < n && y < n && arr[x][y] == 0) {
				arr[x][y] = num++;
				x++;
			}
			if(x == n) x--;
			
			y++;
			while(x < n && y < n && arr[x][y] == 0) {
				arr[x][y] = num++;
				y++;
			}
			if(y == n) y--;
			
			while(arr[x-1][y-1] == 0) {
				arr[--x][--y] = num++;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] != 0) list.add(arr[i][j]);
			}
		}
		
		answer = new int[list.size()];
		for(int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
}
