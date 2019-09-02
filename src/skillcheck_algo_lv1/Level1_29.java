package skillcheck_algo_lv1;

// Programmers Level 1 : Matrix addition
public class Level1_29 {
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		int[][] arr1 = {{1,2}, {2,3}};
		int[][] arr2 = {{3,4}, {5,6}};
		int[][] ans = solution(arr1, arr2);
		
		for(int i = 0; i < ans.length; i++) {
			for(int j = 0; j < ans[i].length; j++) {
				sb.append(ans[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int row = arr1.length;
		int col = arr1[0].length;
		int[][] answer = new int[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return answer;
	}
}