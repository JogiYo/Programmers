package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Programmers Level 2 : News Clustering(2018 KAKAO BLIND RECRUITMENT)
public class Level2_43 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String str1 = br.readLine();
		String str2 = br.readLine();
		sb.append(solution(str1, str2) + "");
		System.out.print(sb);
	}
	
	public static int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        
        for(int i = 0; i < str1.length()-1; i++) {
        	if(str1.charAt(i) < 97 || str1.charAt(i) > 122 || str1.charAt(i+1) < 97 || str1.charAt(i+1) > 122) {
        		continue;
        	}
        	arr1.add(str1.substring(i, i+2));
        }
        
        for(int i = 0; i < str2.length()-1; i++) {
        	if(str2.charAt(i) < 97 || str2.charAt(i) > 122 || str2.charAt(i+1) < 97 || str2.charAt(i+1) > 122) {
        		continue;
        	}
        	arr2.add(str2.substring(i, i+2));
        }
        
        // If both sets are empty, the similarity of the jaccard is 1.
        // return 1 * 65536;
        if(arr1.size() == 0 && arr2.size() == 0) return 65536;
        
        for(int i = 0; i < arr1.size(); i++) {
        	if(arr2.contains(arr1.get(i))) {
        		intersection.add(arr1.get(i));
        		arr2.remove(arr1.get(i));
        	}
        }
        
        for(int i = 0; i < intersection.size(); i++) {
        	if(arr1.contains(intersection.get(i))) {
        		arr1.remove(intersection.get(i));
        	}
        }
        
        // If intersection set is empty, the similarity of the jaccard is 0.
        // return 0;
        if(intersection.size() == 0) return 0;
   
        while(!arr1.isEmpty() || !arr2.isEmpty()) {
        	if(!arr1.isEmpty() && !arr2.isEmpty()) {
        		union.add(arr1.remove(0));
        		union.add(arr2.remove(0));
        	}
        	else if(arr1.isEmpty()) {
        		union.add(arr2.remove(0));
        	}
        	else {
        		union.add(arr1.remove(0));
        	}
        }
        
        // similarity of the jaccard is (intersection) / (intersection + union)
        // J(A, B) = (intersection) / (intersection + union)
        double jaccard = (double) intersection.size() / (double) (intersection.size() + union.size());
        answer = (int) (jaccard * 65536);
        return answer;
    }	
}