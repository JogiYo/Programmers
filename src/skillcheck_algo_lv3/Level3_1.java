package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Programmers Level 3 : Origami
// Find rules
public class Level3_1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		int[] ans = solution(n);
		
		for(int i = 0; i < ans.length; i++) {
			sb.append(ans[i] + " ");
		}
		
		System.out.print(sb);
	}
	
	public static int[] solution(int n) {
		int[] answer; 
		ArrayList<Integer> arr = new ArrayList<>();
		// Add zero when folded (first time)
		arr.add(0);
		// When folding more than once
		for(int i = 2; i <=n; i++) {
			int[] temp = new int[arr.size()];
			
			for(int j = 0; j < temp.length; j++) {
				temp[j] = arr.get(j);
			}
			// Add zero when folded
			arr.add(0);
			// when temp is {0, 0, 1}
			// arr is {0, 0, 1, 0}
			// arr(4) = !temp(2) [!1 = 0], arr(5) = !temp(1) [!0 = 1], arr(6) = !tmep(0) [!0 = 1]
			for(int j = temp.length-1; j >= 0; j--) {
				if(temp[j] == 0) arr.add(1);
				else arr.add(0);
			}
		}
		
		answer = new int[arr.size()];
		
		for(int i = 0; i < answer.length; i++) {
			answer[i] = arr.get(i);
		}
		return answer;
    }
}