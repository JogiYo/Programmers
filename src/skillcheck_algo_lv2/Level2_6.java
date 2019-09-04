package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Programmers Level 2 : Skill trees
// Using method 'indexOf'
public class Level2_6 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String skill = br.readLine();
		String[] skill_trees = br.readLine().split(" ");
		sb.append(solution(skill, skill_trees) + "");
		System.out.print(sb);
	}
	
	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		
		for(int i = 0; i < skill_trees.length; i++) {
			boolean flag = true;
			String[] skills = skill_trees[i].split("");
			// cnt = The index of the character to be found
			int cnt = 0;
			
			// 'indexOf(ch)' returns -1 if the character is not included.
			// ex) skill = "CBD", 'C'-> 0, 'B' -> 1, 'D' -> 2
			for(int j = 0; j < skills.length; j++) {
				if(cnt < skill.indexOf(skills[j])) {
					flag = false;
					break;
				}
				else if (cnt == skill.indexOf(skills[j])) {
					cnt++;
				}
			}
			
			if(flag) answer++;
		}	
		return answer;
	}
}