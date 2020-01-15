package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Level2_46 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] record = br.readLine().split(",");
		String[] answer = solution(record);
		
		for(int i = 0; i < answer.length; i++) {
			sb.append(answer[i] + "\n");
		}
		
		System.out.print(sb);
	}
	
	public static String[] solution(String[] record) {
		HashMap<String, String> hs = new HashMap<String, String>();
		ArrayList<String> list = new ArrayList<>();
		String[] answer;
		
		for(int i = 0; i < record.length; i++) {
			String[] str = record[i].split(" ");
			if(!str[0].equals("Leave")) {
				hs.put(str[1], str[2]);
			}
		}
		
		for(int i = 0; i < record.length; i++) {
			String[] str = record[i].split(" ");
			if(str[0].equals("Enter")) {
				list.add(hs.get(str[1]) + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
			}
			else if(str[0].equals("Leave")) {
				list.add(hs.get(str[1]) + "´ÔÀÌ ³ª°¬½À´Ï´Ù.");
			}
		}
		
		answer = new String[list.size()];
		
		for(int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		
	    return answer;
	}
}