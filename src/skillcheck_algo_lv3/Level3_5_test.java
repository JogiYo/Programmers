package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Level3_5_test {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String sentence = br.readLine();
		sb.append(solution(sentence) + "");
		System.out.print(sb);
	}
	
	public static String solution(String sentence) {	
		HashMap<Character, Integer> set = new HashMap<Character, Integer>();
		
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
		
		int rule_seq = 0;
		for(int i = 0; i < sentence.length(); i++) {
			char ch = sentence.charAt(i);
			
			if(set.containsKey(ch)) {
				// rule 2 or rule 1
				if(set.get(ch) == 2) {
					int upper_case_cnt = 0;
					int start = i;
					int end = sentence.lastIndexOf(ch)-2;
					for(int j = i+1; j < sentence.lastIndexOf(ch); j++) {
						if(sentence.charAt(j) >= 65 && sentence.charAt(j) <= 90) upper_case_cnt++;
					}
					
					if(upper_case_cnt == 1) {
						for(int j = i; j <= sentence.lastIndexOf(ch)+1; j += 2) {
							if(sentence.charAt(j) != ch) return "invalid";
							if(i != 0 && !((sentence.charAt(i-1) >= 65 && sentence.charAt(i-1) <= 90) || sentence.charAt(i-1) == ' ')) return "invalid";
							if(!(sentence.charAt(j+1) >= 65 && sentence.charAt(j+1) <= 90)) {
								return "invalid";
							}
						}
						if(rule_seq == 1) {
							if(i == 0) {
								sentence = sentence.substring(i+1, sentence.lastIndexOf(ch)+2) + " " + sentence.substring(sentence.lastIndexOf(ch)+2);
							}
							else {
								if(i == 1) {
									sentence = sentence.substring(i-1, sentence.lastIndexOf(ch)+2) + " " + sentence.substring(sentence.lastIndexOf(ch)+2);
								}
								else {
									sentence = sentence.substring(0, i-1) + " " + sentence.substring(i-1, sentence.lastIndexOf(ch)+2) + " " + sentence.substring(sentence.lastIndexOf(ch)+2);
								}
							}

						}
						else if(rule_seq == set.size()) {
							sentence = sentence.substring(0, i-1) + sentence.substring(i-1, sentence.lastIndexOf(ch)+2);
						} 
						else {
							sentence = sentence.substring(0, i-1) + " " + sentence.substring(i-1, sentence.lastIndexOf(ch)+2) + " " + sentence.substring(sentence.lastIndexOf(ch)+2);
							
						}
						sentence = sentence.replaceAll(Character.toString(ch), "");
					}
					
					else {
						if(rule_seq == 1) {
							if(i == 0) {
								sentence = sentence.substring(i+1, sentence.lastIndexOf(ch)) + " " + sentence.substring(sentence.lastIndexOf(ch) + 1);
							}
							else {
								sentence = sentence.substring(0, i) + " " + sentence.substring(i+1, sentence.lastIndexOf(ch)) + " " + sentence.substring(sentence.lastIndexOf(ch) + 1);
							}
						}
						else if(rule_seq == set.size()) {
							sentence = sentence.substring(0, i) + sentence.substring(i+1, sentence.lastIndexOf(ch));
						}
						else {
							sentence = sentence.substring(0, i) + " " + sentence.substring(i+1, sentence.lastIndexOf(ch)) + " " +  sentence.substring(sentence.lastIndexOf(ch) + 1);	
						}
					}
					
					int rule_count = 0;
					String word = sentence.substring(start, end+1);
					for(int t = 0; t <= word.length(); t++) {
						char cha = sentence.charAt(t);
						if(set.containsKey(cha)) {
							if(set.get(cha) == 2) return "invalid";
							else {
								word = word.replaceAll(Character.toString(cha), "");
								rule_count++;
							}
						}
						if(rule_count == 2) return "invalid";
					}
				}
				
				// rule 1
				else if(set.get(ch) == 1) {
					if(i == 0) return "invlid";
					
					if(!(sentence.charAt(i-1) >= 65 && sentence.charAt(i-1) <= 90 && sentence.charAt(i+1) >= 65 && sentence.charAt(i+1) <= 90)) {
						return "invalid";
					}
					if(rule_seq == 1) {
						if(i == 1) {
							sentence = sentence.substring(i-1, i+2) + " " + sentence.substring(i+2);
						}
						else {
							sentence = sentence.substring(0, i-1) + " " + sentence.substring(i-1, i+2) + " " + sentence.substring(i+2);
						}
					}
					else if(rule_seq == set.size()) {
						sentence = sentence.substring(0, i-1) + " " + sentence.substring(i-1, i+2);
					} 
					else {
						sentence = sentence.substring(0, i-1) + " " + sentence.substring(i-1, i+2) + " " + sentence.substring(i+2);
						
					}
					sentence = sentence.replaceAll(Character.toString(ch), "");
				}
				
				// rule 1
				else if(set.get(ch) >= 3) {
					if(i == 0) return "invalid";
					
					int start = i - 1;
					int end = sentence.lastIndexOf(ch) + 1 - set.get(ch);
					
					for(int j = i; j <= sentence.lastIndexOf(ch)+1; j += 2) {
						if(sentence.charAt(j) != ch) return "invalid";
						if(i != 0 && !(sentence.charAt(i-1) >= 65 && sentence.charAt(i-1) <= 90)) return "invalid";
						if(!(sentence.charAt(j+1) >= 65 && sentence.charAt(j+1) <= 90)) {
							return "invalid";
						}
					}
					if(rule_seq == 1) {
						if(i == 1) {
							sentence = sentence.substring(i-1, sentence.lastIndexOf(ch)+2) + " " + sentence.substring(sentence.lastIndexOf(ch)+2);
						}
						else {
							sentence = sentence.substring(0, i-1) + " " + sentence.substring(i-1, sentence.lastIndexOf(ch)+2) + " " + sentence.substring(sentence.lastIndexOf(ch)+2);
						}
					}
					else if(rule_seq == set.size()) {
						sentence = sentence.substring(0, i-1)+ " " + sentence.substring(i-1, sentence.lastIndexOf(ch)+2);
						
					} 
					else {
						sentence = sentence.substring(0, i-1) + " " + sentence.substring(i-1, sentence.lastIndexOf(ch)+2) + " " + sentence.substring(sentence.lastIndexOf(ch)+2);
						
					}
					sentence = sentence.replaceAll(Character.toString(ch), "");
				}
				
				rule_seq++;
				i = 0;
			}
		}
		return sentence;
    }
}
