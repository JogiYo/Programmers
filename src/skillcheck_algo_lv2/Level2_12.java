package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Programmers Level 2 : A fine rectangle
public class Level2_12 {
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
		long answer = w*h;
        long cd = gcd(w,h);
        
        long sw = w/cd;
        long sh = h/cd;
        
        answer -= cd * sw * sh;
        
        long safe = 0;
        
        for(int i = 1; i < sw; i++){
            safe += i * sh/sw;
        }
        
        answer += safe * 2 * cd;
        return answer;
    }
	
    public static long gcd(int a, int b){
        while(a!=0){
            if(a<b){
                int temp = a;
                a = b;
                b = temp;
            }
            a = a-b;
        }
        return b;
    }
}