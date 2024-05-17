// package boj1417;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // 입력을 파일에서 받기 위한 설정 (주석 처리됨)
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 후보자 수 입력
        int N = Integer.parseInt(br.readLine());
        // System.out.println(N);

        // 우선순위 큐 생성 (내림차순 정렬)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 첫 번째 후보자의 득표수 입력
        int vote = Integer.parseInt(br.readLine());
        // 나머지 후보자의 득표수를 우선순위 큐에 추가
        for (int i = 1; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;

        // 우선순위 큐가 비어 있지 않고, 가장 많은 득표를 한 후보의 득표수가 현재 득표수보다 크거나 같은 동안 반복
        while (!pq.isEmpty() && pq.peek() >= vote) {
            // 가장 많은 득표를 한 후보의 득표수 가져오기
            int val = pq.poll();
            // System.out.println(pq.peek());
            // 해당 후보의 득표수를 하나 줄이고 다시 큐에 추가
            val--;
            pq.add(val);
            // 현재 후보의 득표수를 하나 증가
            vote++;
            // 매수 횟수 증가
            count++;
        }

        // 매수 횟수 출력
        bw.write(count + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
