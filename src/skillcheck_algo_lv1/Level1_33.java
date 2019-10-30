package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// Programmers Level 1 : Failure rate(2019 KAKAO BLIND RECRUITMENT)
// using sorting Descending order
public class Level1_33 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] stages = new int[input.length];
		
		for(int i = 0; i < stages.length; i++) {
			stages[i] = Integer.parseInt(input[i]);
		}
		
		int[] result = solution(n, stages);
		
		for(int i = 0; i < n; i++) {
			sb.append(result[i] + " ");
		}
		
		System.out.print(sb);
	}
	
	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		double[] failure_rate = new double[N+1];
		int[] trial = new int[N+2];
		int[] reached = new int[N+1];
		int totalChallenger = stages.length;
		
		for(int i = 0; i < stages.length; i++) {
			trial[stages[i]]++;
		}
		
		reached[0] = totalChallenger;
		
		// failure rate.
		for(int i = 1; i <= N; i++) {
			reached[i] = reached[i-1] - trial[i-1];
			if(trial[i] == 0) failure_rate[i] = 0;
			else failure_rate[i] = trial[i] / (double) reached[i];
		}
		
		ArrayList<Pair> list = new ArrayList<Pair>();
		
		for(int i = 1; i <= N; i++) {
			list.add(new Pair(i, failure_rate[i]));
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < N; i++) {
			answer[i] = list.get(i).index;
		}
		
		return answer;
	}
	
	static class Pair implements Comparable<Pair> {
		int index;
		double rate;
		
		Pair(int index, double rate) {
			this.index = index;
			this.rate = rate;
		}

		@Override
		public int compareTo(Pair p) {
			// TODO Auto-generated method stub
			if(this.rate < p.rate) return 1;
			else if(this.rate == p.rate) {
				if(this.index > p.index) return 1;
			}
			return -1;
		}
	}
}