package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Programmers Level 2 : Function Development
// Pay attention at the end of the array
public class Level2_5 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input_1 = br.readLine().split(" ");
		String[] input_2 = br.readLine().split(" ");
		int[] progresses = new int[input_1.length];
		int[] speeds = new int[input_2.length];
		for(int i = 0; i < input_1.length; i++) {
			progresses[i] = Integer.parseInt(input_1[i]);
			speeds[i] = Integer.parseInt(input_2[i]);
		}
		int[] ans = solution(progresses, speeds);
		for(int i = 0; i < ans.length; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.print(sb);
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int[] publish = new int[progresses.length];
		
		for(int i = 0; i < progresses.length; i++) {
			int remain = 100 - progresses[i];
			if(remain % speeds[i] == 0) publish[i] = remain / speeds[i];
			else publish[i] = (remain / speeds[i]) + 1;
		}
		
		// At the end of the arrangement it is always an insertion.
		int count = 1;
		int comp = publish[0];
		for(int i = 1; i < publish.length; i++) {
			if(publish[i] <= comp) {
				count++;
				if(i == publish.length-1) arr.add(count);
			}
			else {
				comp = publish[i];
				arr.add(count);
				if(i == publish.length-1) arr.add(1);
				else count = 1;
			}
		}
		
		answer = new int[arr.size()];
		for(int i = 0; i < arr.size(); i++) {
			answer[i] = arr.get(i);
		}
		return answer;
	}
}