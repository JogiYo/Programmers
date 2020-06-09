package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// Programmers Level 3 : Crack down Camera
// Greedy algorithm
// Start from sorting
public class Level3_11 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int n = Integer.parseInt(br.readLine());
		int[][] routes = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(",");
			for(int j = 0; j < 2; j++) {
				routes[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		sb.append(solution(routes) + "\n");
		sb.append(solution_other(routes) + "");
		System.out.print(sb);
	}
	
	// sorting criterion : outgoing point
	public static int solution(int[][] routes) {
        int answer = 0;
        int camera = -30001;
        
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
             public int compare(int[] a, int[] b){
                 return a[1] - b[1];
             }
         });
        
        for(int[] route : routes) {
        	if(camera < route[0]) {
        		camera = route[1];
        		answer++;
        	}
        }
        return answer;
    }
	
	// sorting criterion : incoming point
	public static int solution_other(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
             public int compare(int[] a, int[] b){
                 return a[0] - b[0];
             }
         });
        
        int min = 30001;
        int max = -30001;
        
        for(int[] route : routes) {
        	int in = route[0];
        	int out = route[1];
        	
        	 if(in > max || out < min) {
                 answer++;
                 min = in;
                 max = out;
             } else {
                 min = in > min ? in : min;
                 max = max > out ? out : max;
             }
        }
        
        return answer;
    }
}