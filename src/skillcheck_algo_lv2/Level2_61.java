package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Rotate matrix border(2021 Dev-Matching: Web Backend Developer (First Half))
// implementation
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
		sb.append(result[0] + "");
		
		for(int i = 1; i < result.length; ++i) {
			sb.append(", " + result[i]);
		}
		
		System.out.print(sb);
	}
	
	static int[][] matrix;
	public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        matrix = new int[rows][columns];
        
        int num = 1;       
        for(int i = 0; i < rows; ++i) {
        	for(int j = 0; j < columns; ++j) {
        		matrix[i][j] = num++;
        	}
        }
        
        for(int i = 0; i < answer.length; ++i) {
        	answer[i] = rotate(queries[i]);
        }
        
        return answer;
    }
	
	private static int rotate(int[] qr) {
		int r1 = qr[0] - 1;
		int c1 = qr[1] - 1;
		int r2 = qr[2] - 1;
		int c2 = qr[3] - 1;
		
		int temp = matrix[r1][c1];
		int min = temp;
		for(int i = r1; i < r2; ++i) {
			matrix[i][c1] = matrix[i+1][c1];
			min = Math.min(min, matrix[i][c1]);
		}
		for(int i = c1; i < c2; ++i) {
			matrix[r2][i] = matrix[r2][i+1];
			min = Math.min(min, matrix[r2][i]);
		}
		for(int i = r2; i > r1; --i) {
			matrix[i][c2] = matrix[i-1][c2];
			min = Math.min(min, matrix[i][c2]);
		}
		for(int i = c2; i > c1; --i) {
			matrix[r1][i] = matrix[r1][i-1];
			min = Math.min(min, matrix[r1][i]);
		}
		matrix[r1][c1+1] = temp;
		
		return min;
	}
}