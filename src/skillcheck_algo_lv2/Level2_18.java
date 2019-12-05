package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Level2_18 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		sb.append(solution(br.readLine()) + "");
		System.out.print(sb);
	}
	
	public static int solution(String numbers) {
        int answer = 0;
        char[] list = numbers.toCharArray();
        Set<Integer> primeList = new HashSet<>();
        
        for(int i = 1; i <= list.length; i++) {
        	perm(list, 0, list.length, i, primeList);
        }
        
        return answer;
    }

	private static void perm(char[] list, int depth, int n, int r, Set<Integer> primeList) {
		if(depth == r) {
			print(list, r, primeList);
			return;
		}
		
		for(int i = depth; i < n; i++) {
			swap(list, depth, i);
			perm(list, depth + 1, n, r, primeList);
			swap(list, depth, i);
		}
		
	}

	private static void print(char[] list, int r, Set<Integer> primeList) {
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < r; i++) {
			
		}
	}

	private static void swap(char[] list, int depth, int i) {
		char temp = list[depth];
		list[depth] = list[i];
		list[i] = temp;
	}
}