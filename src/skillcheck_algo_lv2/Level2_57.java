package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// Programmers Level 2 : Menu renewal
// using DFS, combination
public class Level2_57 {
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
	
	static ArrayList<String> comb_list;
	public static String[] solution(String[] orders, int[] course) {
        String[] answer;
        ArrayList<String> alpha_list = new ArrayList<>();
        ArrayList<String> course_list = new ArrayList<>();
        comb_list = new ArrayList<>();
        char[] alph = new char[26];
        
        for(int i = 0; i < orders.length; i++) {
        	for(int j = 0; j < orders[i].length(); j++) {
        		alph[orders[i].charAt(j)-65]++;
        	}
        }
        
        for(int i =0; i < alph.length; i++) {
        	char c = (char)(i + 65);
        	if(alph[i] >= 2) alpha_list.add(Character.toString(c));
        }
        
        // combination
        int n = alpha_list.size();
        boolean[] visited = new boolean[n];
        
        for(int i = 2; i <= n; i++) {
        	for(int j = 0; j < course.length; j++) {
        		if(i == course[j]) {
        			comb(alpha_list, visited, 0, n, i);
        		}
        	}
        }
        
        // find
        int max = 0;
        int pre_size = 0;
        int course_length = comb_list.get(0).length();
        for(int i = 0; i < comb_list.size(); i++) {
        	int count = 0;
        	//String s = comb_list.get(i);
        	for(int j = 0; j < orders.length; j++) {
        		boolean flag = true;
        		for(int k = 0; k < comb_list.get(i).length(); k++) {
        			if(!orders[j].contains(Character.toString(comb_list.get(i).charAt(k)))) {
        				flag = false;
        				break;
        			}
        		}
        		if(flag) count++;
        	}
        	
        	if(course_length != comb_list.get(i).length()) {
        		if(count >= 2) {
        			max = count;
            		pre_size = course_list.size();
            		course_length = comb_list.get(i).length();
            		course_list.add(comb_list.get(i));
        		}
        	}
        	else {
        		if(count > max) {
        			max = count;
        			while(course_list.size() > pre_size) {
        				course_list.remove(pre_size);
        			}
        			course_list.add(comb_list.get(i));
        		}
        		else if(count == max) course_list.add(comb_list.get(i));
        	}
        }
        
        answer = new String[course_list.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = course_list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

	private static void comb(ArrayList<String> alpha_list, boolean[] visited, int depth, int n, int r) {
		if(r == 0) {
			String str = "";
			for(int i = 0; i< n; i++) {
				if(visited[i]) str += alpha_list.get(i);
			}
			comb_list.add(str);
			return;
		}
		
		for(int i = depth; i < n; i++) {
			visited[i] = true;
			comb(alpha_list, visited, i+1, n, r-1);
			visited[i] = false;
		}
	}
}