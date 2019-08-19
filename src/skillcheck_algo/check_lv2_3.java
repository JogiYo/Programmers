package skillcheck_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers, skill_check Lv2 : TP book prefix problem
// The 'startsWith(prefix)'method is important. 
// solve a problem through brute force
public class check_lv2_3 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] phone_book = br.readLine().split(" ");
		boolean answer = solution(phone_book);
		sb.append(answer);
		System.out.print(sb);
	}
	
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for(int i = 0; i < phone_book.length; i++) {
        	for(int j = 0; j < phone_book.length; j++) {
        		if(!phone_book[i].equals(phone_book[j]) && phone_book[i].startsWith(phone_book[j])) {
        			answer = false;
        			break;
        		}
        	}
        	if(!answer) break;
        }
        return answer;
    }
}