package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// Programmers Level 2 : Working on an assignment
// use Stack
public class Level2_97 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String[][] plans = new String[n][3];
        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            plans[i][0] = st.nextToken();
            plans[i][1] = st.nextToken();
            plans[i][2] = st.nextToken();
        }

        String[] result = solution(plans);
        sb.append(result[0]);
        for(int i = 1; i < n; ++i) {
            sb.append(" ").append(result[i]);
        }

        System.out.print(sb);
    }

    private static String[] solution(String[][] plans) {
        ArrayList<String> result = new ArrayList<>();
        Stack<String[]> stack = new Stack<>();

        String[][] convPlans = new String[plans.length][3];
        for(int i = 0; i < plans.length; ++i) {
            convPlans[i][0] = plans[i][0];
            convPlans[i][2] = plans[i][2];

            String[] startTime = plans[i][1].split(":");
            int totalMin =  Integer.parseInt(startTime[0])*60 + Integer.parseInt(startTime[1]);
            convPlans[i][1] =  Integer.toString(totalMin);
        }

        Arrays.sort(convPlans, (o1, o2) -> Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]));
        String currentTime = convPlans[0][1];
        for(int i = 0; i < convPlans.length-1; ++i) {
            String name = convPlans[i][0];
            int start = Integer.parseInt(convPlans[i][1]);
            int playTime = Integer.parseInt(convPlans[i][2]);

            if(start + playTime <= Integer.parseInt(convPlans[i+1][1])) {
                result.add(name);
                currentTime = Integer.toString(start + playTime);
                while(Integer.parseInt(currentTime) < Integer.parseInt(convPlans[i+1][1])) {
                    if(!stack.isEmpty()) {
                        // Verify that tasks in the stack can be handled during the remaining time.
                        String[] subject = stack.pop();
                        String subName = subject[0];
                        int remainTime = Integer.parseInt(subject[1]);

                        if(remainTime + Integer.parseInt(currentTime) <= Integer.parseInt(convPlans[i+1][1])) {
                            result.add(subName);
                            currentTime = Integer.toString(remainTime + Integer.parseInt(currentTime));
                        }
                        else {
                            stack.add(new String[] {subName, Integer.toString(remainTime + Integer.parseInt(currentTime) - Integer.parseInt(convPlans[i+1][1]))});
                            break;
                        }
                    }
                    else currentTime = convPlans[i+1][1];
                }
            }
            else {
                stack.add(new String[] {name, Integer.toString(start + playTime - Integer.parseInt(convPlans[i+1][1]))});
                currentTime = convPlans[i+1][1];
            }
        }
        // Do the last assignment.
        result.add(convPlans[convPlans.length-1][0]);

        // Carry out unfinished assignments.
        while(!stack.isEmpty()) result.add(stack.pop()[0]);
        return result.toArray(new String[result.size()]);
    }
}