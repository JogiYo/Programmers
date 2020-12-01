package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Programmers Level 3 : Bad User
// using way 1 : DFS, way 2 : DFS and Bit mask
public class Level3_36 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] user_id = br.readLine().split(", ");
		String[] banned_id = br.readLine().split(", ");
		
		sb.append(solution(user_id, banned_id) + ", ");
		sb.append(solution_bit(user_id, banned_id) + "");
		System.out.print(sb);
	}
	
	static String[] userID;
	static String[] bannedID;
	static Set<List<String>> result;
	public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        userID = user_id;
        bannedID = banned_id;
        result = new HashSet<>();
        boolean[] visit = new boolean[user_id.length];
        
        dfs(0, 0, visit);
        answer = result.size();
        return answer;
    }
	
	private static void dfs(int idx, int depth, boolean[] visit) {
		if(depth == bannedID.length) {
			List<String> list = new ArrayList<>();
			
			for(int i = 0; i < visit.length; i++) {
				if(visit[i]) list.add(userID[i]);
			}
			
			result.add(list);
			return;
		}
		
		for(int i = 0; i < userID.length; i++) {
			// In regular expressions, '.' represents a single character.
			String s = bannedID[idx].replace("*", ".");
			Pattern pattern = Pattern.compile(s);
			Matcher matcher = pattern.matcher(userID[i]);
			
			if(matcher.find() && userID[i].length() == bannedID[idx].length()) {
				if(!visit[i]) {
					visit[i] = true;
					dfs(idx+1, depth+1, visit);
					visit[i] = false;
				}
			}
		}
	}
	
	static String[] regex_id;
	static HashSet<Integer> set;
	public static int solution_bit(String[] user_id, String[] banned_id) {
        regex_id = new String[banned_id.length];
        set = new HashSet<>();
        
        for(int i = 0; i < banned_id.length; i++) {
        	regex_id[i] = banned_id[i].replace("*", ".");
        }
        
        dfs_2(user_id, 0, banned_id.length, 0);
        
        return set.size();
    }

	private static void dfs_2(String[] list, int depth, int r, int bit) {
		if(depth == r) {
			set.add(bit);
			return;
		}
		
		for(int i = 0; i < list.length; i++) {
			if(list[i].matches(regex_id[depth]) && ((bit >> i) & 1) == 0) {
				dfs_2(list, depth+1, r, (bit | 1 << i));
			}
		}
	}
}