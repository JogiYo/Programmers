package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// Programmers Level 1 : Making hamburgers
// use Stack
public class Level1_51 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int[] ingredient = new int[st.countTokens()];
        int i = 0;
        while(st.hasMoreTokens()) {
            ingredient[i++] = Integer.parseInt(st.nextToken());
        }

        sb.append(solution(ingredient));
        System.out.print(sb);
    }

    public static int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stk = new Stack<>();

        for (int num : ingredient) {
            if(num == 1) {
                if(stk.size() >= 3) {
                    Stack<Integer> temp = new Stack<>();
                    temp.push(num);
                    if(stk.peek() == 3) {
                        temp.push(stk.pop());
                        if(stk.peek() == 2) {
                            temp.push(stk.pop());
                            if(stk.peek() == 1) {
                                answer++;
                                stk.pop();
                            }
                            else {
                                while(!temp.isEmpty()) {
                                    stk.push(temp.pop());
                                }
                            }
                        }
                        else {
                            while(!temp.isEmpty()) {
                                stk.push(temp.pop());
                            }
                        }
                    }
                    else stk.push(num);
                }
                else stk.push(num);
            }
            else stk.push(num);
        }

        return answer;
    }
}