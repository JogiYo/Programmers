package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// Programmers Level 1 : Failure rate(2019 KAKAO BLIND RECRUITMENT)
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
	
	public static int[] solution(int n, int[] stages) {
		int[] answer = new int[n];
		double[] failure_rate = new double[n];
		
		for(int i = 0; i < n; i++) {
			double denominator = 0;
			double numerator = 0;
			
			for(int j = 0; j < stages.length; j++) {
				if(i+1 == stages[j]) numerator++;
				if(i+1 <= stages[j]) denominator++;
			}
			failure_rate[i] = numerator/denominator;
		}
		
		ArrayList<Pair> list = new ArrayList<Pair>();
		
		for(int i = 0; i < n; i++) {
			list.add(new Pair(i+1, failure_rate[i]));
		}
		Collections.sort(list);
		
		for(int i = 0; i < n; i++) {
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