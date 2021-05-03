package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 1 : Lotto's highest and lowest rankings(2021 Dev-Matching: Web Backend Developer (First Half))
public class Level1_42 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] lt = br.readLine().split(", ");
		String[] wn = br.readLine().split(", ");
		
		int[] lottos = new int[6];
		int[] win_nums = new int[6];
		
		for(int i = 0; i < 6; ++i) {
			lottos[i] = Integer.parseInt(lt[i]);
			win_nums[i] = Integer.parseInt(wn[i]);
		}
		
		int[] result = solution(lottos, win_nums);
		sb.append(result[0] + ", " + result[1]);
		System.out.print(sb);
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero_count = 0;
        int correct_count = 0;
        
        for(int i = 0; i < 6; ++i) {
        	if(lottos[i] == 0) zero_count++;
        	for(int j = 0; j < 6; ++j) {
        		if(lottos[i] == win_nums[j]) {
        			correct_count++;
        			break;
        		}
        	}
        }
        
        int max = correct_count + zero_count;
        int[] rank = {6,6,5,4,3,2,1};
        
        answer[0] = rank[max];
        answer[1] = rank[correct_count];
        return answer;
    }
}