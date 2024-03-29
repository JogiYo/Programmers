package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// Programmers Level 2 : Rank search (2021 KAKAO BLIND RECRUITMENT)
// using Bit operation(for combination) and binary search(for score search)
public class Level2_59 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] arr_size = br.readLine().split(" ");
		int info_size = Integer.parseInt(arr_size[0]);
		int query_size = Integer.parseInt(arr_size[1]);
		
		String[] info = new String[info_size];
		String[] query = new String[query_size];
		
		for(int i = 0; i < info.length; ++i) {
			info[i] = br.readLine();
		}
		
		for(int i = 0; i < query.length; ++i) {
			query[i] = br.readLine();
		}
		
		int[] result = solution(info, query);
		for(int i = 0; i < result.length - 1; ++i) {
			sb.append(result[i] + ", ");
		}
		sb.append(result[result.length-1] + "");
		
		System.out.print(sb);
	}
	
	public static int[] solution(String[] info, String[] query) {
        int[] answer;
        Map<String, List<Integer>> infos = new HashMap<>();
        // Create a key by finding all possible combinations with info except the score.
        for(String inf : info) {
        	String[] info_str = inf.split(" ");
        	int score = Integer.parseInt(info_str[4]);
        	// search 0,0,0,0 -> 1,1,1,1 (combination) (0 ~ 15)
        	for(int i = 0; i < (1 << 4); ++i) {
        		StringBuilder key = new StringBuilder();
        		for(int j = 0; j < 4; ++j) {
        			if((i & (1 << j)) > 0) key.append(info_str[j]);
        		}
        		infos.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
        	}
        }
        
        List<Integer> empty = new ArrayList<>();
        // Sort the scores of each combination in ascending order.
        for(Entry<String, List<Integer>> entry : infos.entrySet()) entry.getValue().sort(null);
        
        answer = new int[query.length];
        // If you find lower_bound (the smallest value among the indexes with matching values) through the binary search 
        // and subtract it from the size of the list, the number of people with the corresponding score or higher is derived.
        for(int i = 0; i < query.length; ++i) {
        	String[] str = query[i].replaceAll("-", "").split(" and | ");
        	String key = String.join("", str[0], str[1], str[2], str[3]);
        	int score = Integer.parseInt(str[4]);
        	
        	List<Integer> list = infos.getOrDefault(key, empty);
        	
        	int start = 0, end = list.size();
        	
        	while(start < end) {
        		int mid = (start + end) / 2;
        		
        		if(list.get(mid) < score) start = mid + 1;
        		else end = mid;
        	}
        	
        	answer[i] = list.size() - start;
        }
        
        return answer;
    }
}