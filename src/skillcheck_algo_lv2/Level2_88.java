package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// Programmers Level 2 : Emoticon discount event (2023 KAKAO BLIND RECRUITMENT)
// exhaustive search using dfs
public class Level2_88 {
    static ArrayList<int[]> discountList;
    static int[] data = {10, 20, 30, 40};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int user_count = Integer.parseInt(br.readLine());
        int[][] users = new int[user_count][2];
        for(int i = 0; i < user_count; ++i) {
            st = new StringTokenizer(br.readLine());
            users[i][0] = Integer.parseInt(st.nextToken());
            users[i][1] = Integer.parseInt(st.nextToken());
        }

        int emoticon_count = Integer.parseInt(br.readLine());
        int[] emoticons = new int[emoticon_count];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < emoticon_count; ++i) {
            emoticons[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(users, emoticons);
        sb.append(result[0]).append(" ").append(result[1]);
        System.out.print(sb);
    }

    private static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        discountList = new ArrayList<>();
        int[] discount = new int[emoticons.length];

        // Returns a combination of discount rates.
        dfs(discount, 0, emoticons.length);

        int maxSubs = -1;
        int maxPrice = -1;
        for(int[] dc : discountList) {
            int totalSubs = 0;
            int totalPrice = 0;
            // For each user, the price of the emoticons and whether or not they subscribed are retrieved.
            for(int i = 0; i < users.length; ++i) {
                int price = 0;
                for(int j = 0; j < emoticons.length; ++j) {
                    if(users[i][0] <= dc[j]) {
                        price += emoticons[j] * (100 - dc[j]) / 100;
                    }
                }

                if(price >= users[i][1]) totalSubs++;
                else totalPrice += price;
            }

            // Update the number of subscriptions and the total price.
            if(maxSubs < totalSubs) {
                maxSubs = totalSubs;
                maxPrice = totalPrice;
            }
            else if(maxSubs == totalSubs) {
                if(maxPrice < totalPrice) maxPrice = totalPrice;
            }
        }

        answer[0] = maxSubs;
        answer[1] = maxPrice;
        return answer;
    }

    /*
     * Depth First Search for Discount Rate Combinations
     */
    private static void dfs(int[] temp, int depth, int dest) {
        if(depth == dest) {
            int[] arr = new int[temp.length];
            for(int i = 0; i < temp.length; ++i) {
                arr[i] = temp[i];
            }
            discountList.add(arr);
            return;
        }

        for(int i = 0; i < 4; ++i) {
            temp[depth] = data[i];
            dfs(temp, depth+1, dest);
        }
    }
}