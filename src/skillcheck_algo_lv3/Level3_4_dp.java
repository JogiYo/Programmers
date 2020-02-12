package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

// Programmers Level 3 : Express as N (Using dynamic programming)
public class Level3_4_dp {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int number = Integer.parseInt(input[1]);
		
		sb.append(solution(N, number) + "");
		System.out.print(sb);
	}
	
	static HashSet<Integer> check = new HashSet<Integer>();
    @SuppressWarnings("unchecked")
	static ArrayList<Integer>[] cache = new ArrayList[9];
	
	public static int solution(int N, int number) {
		if(N == number) return 1;
		
		int temp = N;
		
		for(int i = 1; i < 9; i++) {
			if(temp == number) return i;
			cache[i] = new ArrayList<Integer>();
			cache[i].add(temp);
			check.add(temp);
			temp = temp * 10 + N;
		}
		
		for(int count = 1; count < 9; count++) {
			for(int i = 1; i < count; i++) {
				int j = count - i;
				for(int left : cache[i]) {
					for(int right : cache[j]) {
						cal(count, left, right);
						if(check.contains(number)) {
							return count;
						}
					}
				}
			}
		}
		
		return -1;
    }
	
	public static void cal(int count, int left, int right) {
		addCache(count, left + right);
		addCache(count, left - right);
		addCache(count, left * right);
		if(right == 0) {
			addCache(count, 0);
		}
		else addCache(count, left / right);
	}

	public static void addCache(int count, int ret) {
		if(!check.contains(ret)) {
			check.add(ret);
			cache[count].add(ret);
		}
	}
}