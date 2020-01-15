package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

// Programmers Level 2 : Cache (KAKAO BLIND RECRUITMENT)
// Using LinkedHashMap, can solve it simply.
public class Level2_45 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int cacheSize = Integer.parseInt(br.readLine());
		String[] cities = br.readLine().split(",");
		sb.append(solution(cacheSize, cities) + "");
		System.out.print(sb);
	}
	
	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		
		if(cacheSize == 0) return cities.length*5;
		
		LinkedHashMap<String, Integer> lruMap = new LinkedHashMap<String, Integer>() {
			private static final long serialVersionUID = 1L;

			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<String, Integer> eldest) {
                return cacheSize > 0 ? size() > cacheSize : false;
            }
		};
		// Even if the key is included, it is the latest key to be used if hit.
		for(String key : cities) {
			if(lruMap.containsKey(key.toLowerCase())) {
				answer++;
				lruMap.remove(key.toLowerCase());
			}
			else {
				answer += 5;
			}
			lruMap.put(key.toLowerCase(), 1);
		}
	    return answer;
	}
}