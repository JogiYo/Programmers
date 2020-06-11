package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 3 : Words Conversion
// using depth-first search (or breadth-first search)
public class Level3_13 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String begin = br.readLine();
		String target = br.readLine();
		
		String[] words = br.readLine().split(", ");
		
		sb.append(solution(begin, target, words) + "\n");
		System.out.print(sb);
	}
	
	public static int solution(String begin, String target, String[] words) {
        int min = words.length + 1;
        
        min = dfs(begin, target, words, new boolean[words.length], 0, min, words.length);
        // If the conversion was not successful, the first value of min will be returned.
        return min == words.length + 1 ? 0 : min;
    }

	private static int dfs(String begin, String target, String[] words, boolean[] visited, int n, int min, int length) {
		for(int i = 0; i < length; i++) {
			if(!visited[i] && possible_conv(begin, words[i])) {
				// route search
				System.out.println(n + " " + min + " " + begin + " " + words[i]);
				
				if(words[i].equals(target)) {
					return Math.min(min, n+1);
				}
				
				visited[i] = true;
				int count = dfs(words[i], target, words, visited, n+1, min, length);
				if(count < min) min = count;
			}
		}
		
		return min;
	}

	private static boolean possible_conv(String word1, String word2) {
		int char_dif = 0;
		
		for(int i = 0; i < word1.length(); i++) {
			if(word1.charAt(i) != word2.charAt(i)) {
				char_dif++;
				if(char_dif > 1) return false;
			}
		}
		return true;
	}
}
