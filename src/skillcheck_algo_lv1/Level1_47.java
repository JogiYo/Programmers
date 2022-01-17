package skillcheck_algo_lv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

// Programmers Level 1 : Get report results (2022 KAKAO BLIND RECRUITMENT)
// use Set
public class Level1_47 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] id_list = br.readLine().split(", ");
        int n = Integer.parseInt(br.readLine());
        String[] report = new String[n];

        for(int i = 0; i < n; ++i) {
            report[i] = br.readLine();
        }

        int k = Integer.parseInt(br.readLine());

        int[] result = solution(id_list, report, k);
        for(int num : result) {
            sb.append(num + " ");
        }

        System.out.print(sb);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> reportMemList = new HashMap<>();
        HashMap<String, Integer> mailCount = new HashMap<>();

        // 유저가 받는 메일 수와 신고받은 횟루를 초기화 한다.
        for(String id : id_list) {
            reportMemList.put(id, new HashSet<>());
            mailCount.put(id, 0);
        }

        // set을 이용해 해당 유저가 어떤 유저에게 신고를 당했는지 추가한다.
        // a b -> a가 b를 신고했다.
        for(String rpt : report) {
            String[] add_report = rpt.split(" ");
            reportMemList.get(add_report[1]).add(add_report[0]);
        }

        // 신고당한 유저를 토대로 메일 수를 갱신한다.
        for(String key : reportMemList.keySet()) {
            HashSet<String> reporters = reportMemList.get(key);

            // k 이상일 때 신고자 유저가 받을 메일 수를 갱신한다.
            if(reporters.size() >= k) {
                for(String reporter : reporters) {
                    mailCount.put(reporter, mailCount.get(reporter) + 1);
                }
            }
        }

        for(int i = 0; i < answer.length; ++i) {
            answer[i] = mailCount.get(id_list[i]);
        }

        return answer;
    }
}
