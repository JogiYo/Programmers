package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// Programmers Level 2 : Alphabet shiritori
// Note that it cannot be zero.
public class Level2_41 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		String[] words = br.readLine().split(",");
		int[] result = solution(n, words);
		
		for(int i = 0; i < result.length; i++) {
			sb.append(result[i] + " ");
		}
		System.out.print(sb);
	}
	
	public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Stack<String> stk = new Stack<>();
        answer[0] = 0;
        answer[1] = 0;
        
        stk.push(words[0]);
        // It cannot be the number zero
        // answer[0] = wrong person number
        // answer[1] = Number of replies
        for(int i = 1; i < words.length; i++) {
        	if(stk.contains(words[i]) || stk.peek().charAt(stk.peek().length()-1) != words[i].charAt(0)) {
        		answer[0] = (i%n) + 1;
        		answer[1] = (i/n) + 1;
        		break;
        	}
        	stk.push(words[i]);
        }
        
        return answer;
    }
}