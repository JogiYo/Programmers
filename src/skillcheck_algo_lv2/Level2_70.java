package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Level2_70 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str_fee = br.readLine().split(" ");
        int[] fees = new int[str_fee.length];

        for(int i = 0; i < fees.length; ++i) {
            fees[i] = Integer.parseInt(str_fee[i]);
        }

        int n = Integer.parseInt(br.readLine());
        String[] records = new String[n];

        for(int i = 0; i < n; ++i) {
            records[i] = br.readLine();
        }

        int[] result = solution(fees, records);
        for(int num : result) {
            sb.append(num + " ");
        }

        System.out.print(sb);
    }

    public static int[] solution(int[] fees, String[] records) {
        int[] answer;
        HashMap<String, Integer> time_map = new HashMap<>();
        HashMap<String, Integer> parking_map = new HashMap<>();

        for(String record : records) {
            String[] input = record.split(" ");
            String[] time = input[0].split(":");
            int total_min = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);

            if(input[2].equals("IN")) {
                parking_map.put(input[1], total_min);
            }
            else {
                time_map.put(input[1], time_map.getOrDefault(input[1], 0) + total_min - parking_map.remove(input[1]));
            }
        }

        if(!parking_map.isEmpty()) {
            for(String key : parking_map.keySet()) {
                time_map.put(key, time_map.get(key) + 1439 - parking_map.get(key));
            }
        }

        ArrayList<Carfee> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : time_map.entrySet()) {
            String key = entry.getKey();
            Integer total_min = entry.getValue();

            int fee = fees[1];
            if(total_min > fees[0]) {
                fee += Math.ceil((total_min - fees[0]) / fees[2]) * fees[3];
            }

            list.add(new Carfee(key, fee));
        }

        Collections.sort(list);

        answer = new int[list.size()];
        for(int i = 0; i < answer.length; ++i) {
            answer[i] = list.get(i).fee;
        }
        return answer;
    }

    static class Carfee implements Comparable<Carfee>{
        String car_num;
        int fee;

        Carfee(String car_num, int fee) {
            this.car_num = car_num;
            this.fee = fee;
        }

        @Override
        public int compareTo(Carfee o) {
            return this.car_num.compareTo(o.car_num);
        }
    }
}
