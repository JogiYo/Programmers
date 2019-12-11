package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// Programmers Level 2 : Find Prime number
// Using Permutation, Exclude Duplicates(Using HashSet)
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
        
        // nP1, nP2, ..., nPr (In all cases)
        for(int i = 1; i <= list.length; i++) {
        	perm(list, 0, list.length, i, primeList);
        }
        
        answer = primeList.size();
        		
        return answer;
    }

	// Permutation
	private static void perm(char[] list, int depth, int n, int r, Set<Integer> primeList) {
		if(depth == r) {
			StringBuilder s = new StringBuilder();
			
			for(int i = 0; i < r; i++) {
				s.append(list[i]);
			}
			
			isPrime(primeList, s);
			return;
		}
		
		for(int i = depth; i < n; i++) {
			swap(list, depth, i);
			perm(list, depth + 1, n, r, primeList);
			swap(list, depth, i);
		}
		
	}

	private static void swap(char[] list, int depth, int i) {
		char temp = list[depth];
		list[depth] = list[i];
		list[i] = temp;
	}
	
	// Check for prime numbers.
	private static void isPrime(Set<Integer> primeList, StringBuilder s) {
		int x = Integer.parseInt(String.valueOf(s));
		boolean prime = true;
		
		if( x <= 1) {
			return;
		}
		for(int i = 2; i <= Math.sqrt(x); i++) {
			if(x % i == 0) {
				prime = false;
				break;
			}
		}
		if(prime) {
			primeList.add(x);
		}
	}
}