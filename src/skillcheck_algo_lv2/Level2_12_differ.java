package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Programmers Level 2 : A fine rectangle
// When you cut a rectangle diagonally, fine rectangle is w * h - (w + h - gcd(w,h)).
public class Level2_12_differ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] input = br.readLine().split(", ");
		int w = Integer.parseInt(input[0]);
		int h = Integer.parseInt(input[1]);
		
		sb.append(solution(w,h) + "");
		
		System.out.print(sb);
	}
	
	public static long solution(int w,int h) {
		long answer = 0;
		long W = (long) w;
		long H = (long) h;
        long cd = gcd(w,h);
        // fine rectangle(answer) is w * h - (w + h - gcd(w,h)).
        answer = W * H - (W + H - cd);
        
        return answer;
    }
	
    public static long gcd(int a, int b){
        while(b != 0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}