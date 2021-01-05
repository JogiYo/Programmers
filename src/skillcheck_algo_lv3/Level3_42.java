package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Level3_42 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		
		sb.append(solution(n) + "");
		System.out.print(sb);
	}
	
	static int answer = 0;
	static int x = 0;
	static int col[];
	
	public static int solution(int n) {
        col = new int[n];
        x = n;
        queen(0);
        return answer;
    }
	
	private static void queen(int depth) {
		if(depth == x) {
			answer++;
		}
		else {
			for(int i = 0; i < x; ++i) {
				col[depth] = i;
				if(isPossible(depth)) {
					queen(depth+1);
				}
			}
		}
	}
	
	private static boolean isPossible(int depth) {
		for(int i = 0; i < depth; ++i) {
			if(col[i] == col[depth]) return false;
			if(Math.abs(depth-1) == Math.abs(col[depth] - col[i])) return false;
		}
		
		return true;
	}
}