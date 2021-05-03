package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Level2_61 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int rows = Integer.parseInt(br.readLine());
		int columns = Integer.parseInt(br.readLine());
		int q = Integer.parseInt(br.readLine());
		
		int[][] query = new int[q][4];
		for(int i = 0; i < q; ++i) {
			String[] input = br.readLine().split(",");
			for(int j = 0; j < 4; ++j) {
				query[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int[] result = solution(rows, columns, query);
		System.out.print(sb);
	}
	
	static int[][] matrix;
	public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        matrix = new int[rows][columns];
        int num = 1;
        
        for(int i = 0; i < rows; ++i) {
        	for(int j = 0; j < columns; ++j) {
        		matrix[i][j] = i++;
        	}
        }
        
        for(int i = 0; i < answer.length; ++i) {
        	answer[i] = rotate(queries[i]);
        }
        
        return answer;
    }
	
	private static int rotate(int[] is) {
		// TODO Auto-generated method stub
		return 0;
	}
}