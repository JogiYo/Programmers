package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//Programmers Level 2 : File name sorting (2018 KAKAO BLIND RECRUITMENT)
// Using Arrays.sort and Comparator
// Split through regular expression
public class Level2_50 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] files = br.readLine().split(", ");
		String[] ans = solution(files);
		
		for(int i = 0; i < ans.length; i++) {
			sb.append(ans[i] + " ");
		}
		
		System.out.print(sb);
	}
	
	public static String[] solution(String[] files) {
		String[] answer = new String[files.length];
		
		Arrays.sort(files, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				// head_1 is head of string1
				String head_1 = s1.split("[0-9]")[0];
				s1 = s1.replace(head_1, "");
				head_1 = head_1.toLowerCase();
				
				// Number extraction
				String num_extract = "";
				for(char c : s1.toCharArray()) {
					if(Character.isDigit(c) && num_extract.length() < 5) {
						num_extract += c;
					} else break;
				}
				
				int num_1 = Integer.parseInt(num_extract);
				// head_2 is head of string2
				String head_2 = s2.split("[0-9]")[0];
				s2 = s2.replace(head_2, "");
				head_2 = head_2.toLowerCase();
				
				num_extract = "";
				for(char c : s2.toCharArray()) {
					if(Character.isDigit(c) && num_extract.length() < 5) {
						num_extract += c;
					} else break;
				}
				
				int num_2 = Integer.parseInt(num_extract);
				// compare
				return head_1.equals(head_2) ? num_1 - num_2 : head_1.compareTo(head_2); 
			}
			
		});

		for(int i = 0; i < answer.length; i++) {
			answer[i] = files[i];
		}
		
        return answer;
    }
}