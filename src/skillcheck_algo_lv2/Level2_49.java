package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
// Programmers Level 2 : Compression (2018 KAKAO BLIND RECRUITMENT)
// Using HashMap
public class Level2_49 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String msg = br.readLine();
		int[] ans = solution(msg);
		
		for(int i = 0; i < ans.length; i++) {
			sb.append(ans[i] + " ");
		}
		
		System.out.print(sb);
	}
	
	public static int[] solution(String msg) {
		int[] answer;
		ArrayList<Integer> arr = new ArrayList<>();
        HashMap<String, Integer> hs = new HashMap<>();
		
        int index;
		for(index = 1; index <= 26; index++) {
			char c = (char) (index + 64);
			hs.put(String.valueOf(c),index);
		}
        
		
		while(msg.length() != 0) {
			for(int i = msg.length(); i > 0; i--) {
				String w = msg.substring(0,i);
				
				if(hs.containsKey(w)) {
					arr.add(hs.get(w));
					if(msg.length() == 1) {
						msg = "";
					}
					else {
						msg = msg.substring(i);
						if(msg.length() == 0) break;
						String c = String.valueOf(msg.charAt(0));
						String key = w+c;
						if(!hs.containsKey(key)) hs.put(key, index++);
					}
					break;
				}
			}
		}
		
		answer = new int[arr.size()];
		
		for(int i = 0; i < answer.length; i++) {
			answer[i] = arr.get(i);
		}
		
        return answer;
    }
}