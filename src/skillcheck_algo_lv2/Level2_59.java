package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
        	// search 0,0,0,0 -> 1,1,1,1 (combination)
        	for(int i = 0; i < (1 << 4); ++i) {
        		StringBuilder key = new StringBuilder();
        		for(int j = 0; j < 4; ++j) {
        			if((i & (1 << j)) > 0) key.append(info_str[j]);
        		}
        		infos.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
        	}
        }
        
        List<Integer> empty = new ArrayList<>();
        for(Entry<String, List<Integer>> entry : infos.entrySet()) entry.getValue().sort(null);
        
        answer = new int[query.length];
        return answer;
    }
}