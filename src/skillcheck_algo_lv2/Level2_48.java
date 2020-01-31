package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : That Song just now (2018 KAKAO BLIND RECRUITMENT)
// Code conversion is important. (Using String.replaceAll)
public class Level2_48 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String m = br.readLine();
		String[] musicinfos = br.readLine().split(" ");
		
		sb.append(solution(m, musicinfos) + "");
		System.out.print(sb);
	}
	
	public static String solution(String m, String[] musicinfos) {
		String answer = "(None)";
        int max = 0;
		m = conv(m);
        
        for(int  i = 0; i < musicinfos.length; i++) {
        	String[] arr = musicinfos[i].split(",");
        	String start_time = arr[0];
        	String end_time = arr[1];
        	
        	int start_h = Integer.parseInt(start_time.substring(0,2));
        	int start_m = Integer.parseInt(start_time.substring(3,5));
        	int end_h = Integer.parseInt(end_time.substring(0,2));
        	int end_m = Integer.parseInt(end_time.substring(3,5));
        	
        	int hour = end_h - start_h;
        	int minute = end_m - start_m;
        	
        	int total_min = (hour * 60) + minute;
        	
        	arr[3] = conv(arr[3]);
        	
        	char[] music = arr[3].toCharArray();
        	int quotient = total_min / music.length;
        	int remainder = total_min % music.length;
        	
        	StringBuilder sb = new StringBuilder();
        	for(int j = 0; j < quotient; j++) sb.append(arr[3]);
        	for(int j = 0; j < remainder; j++) sb.append(arr[3].charAt(j));
        	
        	if(sb.toString().contains(m)) {
        		if(max < total_min) {
        			answer = arr[2];
        			max = total_min;
        		}
        	}
        }
		
        return answer;
    }
	
	public static String conv(String str) {
		str = str.replaceAll("A#", "a");
		str = str.replaceAll("C#", "c");
		str = str.replaceAll("D#", "d");
		str = str.replaceAll("F#", "f");
		str = str.replaceAll("G#", "g");
		
		return str;
	}
}