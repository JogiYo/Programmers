package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Arrays;

// Programmers Level 2 : Menu renewal
// using hash map, priority queue and DFS.
public class Level2_57_other {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] orders = br.readLine().split(", ");
		String[] input = br.readLine().split(", ");
		int[] course = new int[input.length];
		
		for(int i = 0; i < course.length; i++) {
			course[i] = Integer.parseInt(input[i]);
		}
		
		String[] result = solution(orders, course);
		for(int i = 0; i < result.length; i++) {
			sb.append(result[i] + " ");
		}
		System.out.print(sb);
	}
	// Combining and counting menus using a hash map.
	static HashMap<String, Integer> hm;
	static int max;
	public static String[] solution(String[] orders, int[] course) {
		// Priority queue is for lexicographical arrangement of menu
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		for(int i = 0; i < course.length; ++i) {
			hm = new HashMap<>();
			max = 0;
			for(int j = 0; j < orders.length; ++j) {
				find(0, "", course[i], 0, orders[j]);
			}
			
			for(String s : hm.keySet()) {
				if(hm.get(s) == max && max > 1) {
					pq.offer(s);
				}
			}
		}
		
		String[] answer = new String[pq.size()];
		int k = 0;
		while(!pq.isEmpty()) {
			answer[k++] = pq.poll();
		}
		
		return answer;
	}
	// Create combinations using DFS.
	private static void find(int cnt, String str, int targetNum, int idx, String word) {
		if(cnt == targetNum) {
			char[] c = str.toCharArray();
			Arrays.sort(c);
			String temp = "";
			for(int i = 0; i < c.length; ++i) temp += c[i];
			hm.put(temp, hm.getOrDefault(temp, 0)+1);
			max = Math.max(max, hm.get(temp));
			return;
		}
		
		for(int i = idx; i < word.length(); ++i) {
			char cur = word.charAt(i);
			find(cnt+1, str+cur, targetNum, i+1, word);
		}
	}
}