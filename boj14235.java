package boj14235;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // 입력을 파일에서 받기 위한 설정
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 이벤트 수를 입력받음
        int n = Integer.parseInt(br.readLine());
        // 우선순위 큐 생성 (내림차순 정렬)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // n개의 이벤트 처리
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.equals("0")) { // 선물 요청 이벤트
                if (!pq.isEmpty()) {
                    // 가장 큰 선물 출력
                    bw.write(pq.poll() + "");
                } else {
                    // 선물이 없으면 -1 출력
                    bw.write(-1 + "");
                }
                bw.newLine();
            } else { // 선물 기부 이벤트
                StringTokenizer st = new StringTokenizer(input);
                int a = Integer.parseInt(st.nextToken()); // 기부된 선물 개수
                for (int j = 0; j < a; j++) {
                    pq.add(Integer.parseInt(st.nextToken())); // 선물 추가
                }
            }
        }
        
        // 자원 해제
        br.close();
        bw.flush();
        bw.close();
    }
}
