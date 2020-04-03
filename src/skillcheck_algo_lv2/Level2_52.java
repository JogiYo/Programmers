package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Programmers Level 2 : Tuple (KAKAO 2019 Winter InternShip)
// Using ArrayList, Comparator
public class Level2_52 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String s = br.readLine();
		int[] result = solution(s);
		
		for(int i = 0; i < result.length; i++) {
			sb.append(result[i] + " ");
		}
		
		System.out.print(sb);
	}
	
	public static int[] solution(String s) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        
        int idx = -1;
        String str = "";
        for(int i = 1; i < s.length()-1; i++) {
        	if(s.charAt(i) == '{') {
        		list.add(new ArrayList<Integer>());
        		idx++;
        	}
        	else if(s.charAt(i) != ',' && s.charAt(i) != '}') {
        		str += s.charAt(i);
        	}
        	else if(s.charAt(i) == '}') {
        		if(i == s.length()-2) list.get(idx).add(Integer.parseInt(str));
        		else continue;
        	}
        	else {
        		list.get(idx).add(Integer.parseInt(str));
        		str = "";
        	}
        }
        
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {

			@Override
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				if(a.size() > b.size()) {
					return 1;
				}
				else if(a.size() < b.size()) {
					return -1;
				}
				else {
					return 0;
				}
			}
        	
        });
        
        ArrayList<Integer> tuple = new ArrayList<Integer>();
        
        for(int i = 0; i < list.size(); i++) {
        	ArrayList<Integer> temp = list.get(i);
        	
        	for(int j = 0; j < temp.size(); j++) {
        		if(!tuple.contains(temp.get(j))) {
        			tuple.add(temp.get(j));
        		}
        	}
        }
        int[] answer = new int[tuple.size()];
        
        for(int i = 0; i < tuple.size(); i++) {
        	answer[i] = tuple.get(i);
        }
        
        return answer;
    }
}