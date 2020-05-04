package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// Programmers Level 3 : Brian's troubles (2017 KAKAO CODE Qualifier)
// test case : https://programmers.co.kr/learn/questions/9618 
// test case 2 : https://github.com/wh2per/Programmers-Algorithm/blob/master/Programmers/Lv3/Lv3_%EB%B8%8C%EB%9D%BC%EC%9D%B4%EC%96%B8%EC%9D%98%EA%B3%A0%EB%AF%BC.cpp
public class Level3_5 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String sentence = br.readLine();
		sb.append(solution(sentence) + "");
		System.out.print(sb);
	}
	
	public static String solution(String sentence) {	
		HashMap<Character, Integer> set = new HashMap<Character, Integer>();
		Queue<String> qu = new LinkedList<String>();
		
		String temp_sen = sentence;
		for(int i = 0; i < temp_sen.length(); i++) {
			char ch = temp_sen.charAt(i);
			if(ch >= 97 && ch <= 122) {
				int count = 0;
				for(int j = i; j < temp_sen.length(); j++) {
					if(ch == temp_sen.charAt(j)) count++;
				}
				temp_sen = temp_sen.replaceAll(Character.toString(ch), "");
				set.put(ch, count);
				i = 0;
			}
		}
		
		boolean rule2_used = false;
		for(int i = 0; i < sentence.length(); i++) {
			char ch = sentence.charAt(i);
			if(ch == ' ') return "invalid";
			if(set.containsKey(ch)) {
				// rule 1
				// ex) ABAaA
				if(set.get(ch) == 1) {
					if(i == 0) return "invalid";
					if(i == sentence.length()-1) return "invalid";
					if(!(sentence.charAt(i-1) >= 65 && sentence.charAt(i-1) <= 90 && sentence.charAt(i+1) >= 65 && sentence.charAt(i+1) <= 90)) {
						return "invalid";
					}
					String word = sentence.substring(i-1, i+2);
					if(i != 1) {
						qu.offer(sentence.substring(0, i-1));
					}
					sentence = sentence.substring(i+2);
					word = word.replaceAll(Character.toString(ch), "");
					qu.offer(word);
					if(rule2_used) rule2_used = false;
				}
				// rule 1
				// ex) ABAaAaAaA
				else if(set.get(ch) >= 3) {
					if(i == 0) return "invalid";
			
					int start = i - 1;
					int end = sentence.lastIndexOf(ch) + 1;
					
					if(end == sentence.length()) return "invalid"; 
					for(int j = i; j <= sentence.lastIndexOf(ch); j += 2) {
						if(sentence.charAt(j) != ch) return "invalid";
						if(i != 0 && !(sentence.charAt(i-1) >= 65 && sentence.charAt(i-1) <= 90)) return "invalid";
						if(!(sentence.charAt(j+1) >= 65 && sentence.charAt(j+1) <= 90)) {
							return "invalid";
						}
					}
					
					String word = sentence.substring(start, end + 1);
					if(i != 1) {
						qu.offer(sentence.substring(0, i-1));
					}
					sentence = sentence.substring(end+1);
					
					word = word.replaceAll(Character.toString(ch), "");
					for(int t = 0; t < word.length(); t++) {
						char cha = word.charAt(t);
						if(set.containsKey(cha)) {
							return "invalid";
						}
					}
					qu.offer(word);
					if(rule2_used) rule2_used = false;
				}
				
				// rule 1 and rule 2
				// ex) ABAaAaA
				else {
					int upper_case_cnt = 0;
					int start = i;
					int end = sentence.lastIndexOf(ch);
					
					for(int j = i+1; j < sentence.lastIndexOf(ch); j++) {
						if(sentence.charAt(j) >= 65 && sentence.charAt(j) <= 90) upper_case_cnt++;
					}
					
					if(upper_case_cnt == 1) {
						for(int j = i; j <= sentence.lastIndexOf(ch); j += 2) {
							if(sentence.charAt(j) != ch) return "invalid";
							if(i != 0 && !((sentence.charAt(i-1) >= 65 && sentence.charAt(i-1) <= 90) || sentence.charAt(i-1) == ' ')) return "invalid";
			
						}
					}
					else if(upper_case_cnt == 0) return "invalid";
					
					int rule_count = 0;
					String word;
					if(i != 0 && upper_case_cnt == 1) {
						if(rule2_used) {
							word = sentence.substring(start-1, end+2);
							if(start-1 != 0) {
								qu.offer(sentence.substring(0, start-1));
							}
							char cha = word.charAt(i);
							word = word.replaceAll(Character.toString(cha), "");
							sentence = sentence.substring(end+2);
						}
						else {
							word = sentence.substring(start+1, end);
							if(start != 0) {
								qu.offer(sentence.substring(0, start));
							}
							sentence = sentence.substring(end+1);
						}
						//if(end == sentence.length()-1) {
						//	word = sentence.substring(start+1, end);
						//	if(start != 0) {
						//		qu.offer(sentence.substring(0, start));
						//	}
						//	sentence = sentence.substring(end+1);
						//}
						//else {
						//	word = sentence.substring(start+1, end);
						//	if(start != 0) {
						//		qu.offer(sentence.substring(0, start));
						//	}
						//	sentence = sentence.substring(end+1);
							// AaAaAcA
							//word = sentence.substring(start-1, end+2);
							//if(start-1 != 0) {
							//	qu.offer(sentence.substring(0, start-1));
							//}
							//char cha = word.charAt(i);
							//word = word.replaceAll(Character.toString(cha), "");
							//sentence = sentence.substring(end+2);
						//}
						qu.offer(word);
						if(rule2_used) rule2_used = false;
					}
					else {
						if(start != 0) {
							qu.offer(sentence.substring(0, start));
						}
						word = sentence.substring(start+1, end);
						boolean rule_use = false;
						for(int t = 0; t < word.length(); t++) {
							char cha = word.charAt(t);
							if(set.containsKey(cha)) {
								rule_use = true;
								if(word.length() != set.get(cha)*2 + 1) return "invalid";
								//if(set.get(cha) == 2 && word.length() != 5) return "invalid";
								else {
									word = word.replaceAll(Character.toString(cha), "");
									rule_count++;
									t = -1;
								}
							}
							if(rule_count == 2) return "invalid";
						}
						
						if(rule_use) {
							sentence = sentence.substring(start+1, end) + sentence.substring(end + 1);
							rule2_used = true;
						}
						else {
							sentence = sentence.substring(end+1);
							qu.offer(word);
						}
					}
				}	
				i = -1;
			}
		}
		if(!sentence.isEmpty()) qu.offer(sentence);
		
		String answer = "";
		while(!qu.isEmpty()) {
			if(qu.size() != 1) answer += qu.poll() + " ";
			else answer += qu.poll();
		}
		return answer;
    }
}