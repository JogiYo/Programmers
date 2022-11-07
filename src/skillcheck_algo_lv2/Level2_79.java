package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// Programmers Level 2 : Parcel box
// use Stack & Queue
public class Level2_79 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] order = new int[st.countTokens()];

        for(int i = 0; i < order.length; ++i) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(solution(order));
        System.out.print(sb);
    }

    private static int solution(int[] order) {
        int answer = 0;

        Queue<Integer> main_belt = new LinkedList<>();
        Stack<Integer> aux_belt = new Stack<>();

        for(int i = 0; i < order.length; ++i) {
            main_belt.offer(i+1);
        }

        // Box recently loaded into truck
        int recent = 0;

        for(int box : order) {
            while(true) {
                /*
                 * If the box number to be loaded is smaller than the recently loaded box number,
                 * find it in the auxiliary container belt.
                 * If not, it can no longer be loaded.
                 */
                if(box < recent) {
                    if(aux_belt.peek() == box) {
                        recent = aux_belt.pop();
                        answer++;
                        break;
                    }
                    else return answer;
                }
                /*
                 * If the above conditions are not satisfied and a box exists on the main container belt,
                 * the search is performed on the main belt.
                 * If not, it can no longer be loaded.
                 */
                else if(!main_belt.isEmpty()) {
                    if(main_belt.peek() == box) {
                        recent = main_belt.poll();
                        answer++;
                        break;
                    }
                    else aux_belt.push(main_belt.poll());
                }
            }
        }

        return answer;
    }
}
