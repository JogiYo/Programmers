package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Level2_53 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String expression = br.readLine();
		
		sb.append(solution(expression) + "");
		
		System.out.print(sb);
	}
	
	static char[] operation = {'+', '-', '*'};
	static boolean[] visited = new boolean[3];
	static ArrayList<Long> numbers;
	static ArrayList<Character> opers;
	static long answer;
	
	public static long solution(String expression) {
        answer = 0;
		numbers = new ArrayList<Long>();
        opers = new ArrayList<Character>();
        
        String num = "";
        for(int i = 0; i < expression.length(); i++) {
        	if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
        		num += expression.charAt(i);
        	}
        	else {
        		numbers.add(Long.parseLong(num));
        		num = "";
        		opers.add(expression.charAt(i));
        	}
        }
        // 마지막숫자 추가
        numbers.add(Long.parseLong(num));
        dfs(0, new char[3]);
        return answer;
    }

	private static void dfs(int count, char[] p) {
		if(count == 3) {
			ArrayList<Long> copyNums = new ArrayList<Long>(numbers);
			ArrayList<Character> copyOpers = new ArrayList<Character>(opers);
			
			for(int i = 0; i < p.length; i++) {
				for(int j = 0; j < copyOpers.size(); j++) {
					if(copyOpers.get(j) == p[i]) {
						Long res = calculation(copyNums.remove(j), copyNums.remove(j), p[i]);
						copyNums.add(j, res);
						copyOpers.remove(j);
						j--;
					}
				}
			}
			answer = Math.max(answer, Math.abs(copyNums.get(0)));
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			if(!visited[i]) {
				visited[i] = true;
				p[count] = operation[i];
				dfs(count+1, p);
				visited[i] = false;
			}
		}
	}

	private static Long calculation(Long num1, Long num2, char op) {
		long num = 0;
		if(op == '+') {
			return num1 + num2;
		}
		else if(op == '-') {
			return num1 - num2;
		}
		else {
			return num1 * num2;
		}
	}
}