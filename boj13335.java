// package boj13335;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // 입력을 파일에서 받기 위한 설정 (주석 처리됨)
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력값을 읽어 n, w, l로 분리
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int w = Integer.parseInt(tmp[1]);
        int l = Integer.parseInt(tmp[2]);
        // System.out.println(n + " " + w + " " + l);

        // 트럭의 무게를 저장할 Queue 생성
        Queue<Integer> A = new LinkedList<>();
        tmp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            A.add(Integer.parseInt(tmp[i]));
        }
        // System.out.println(A);

        // 다리를 나타내는 Queue 생성 및 초기화 (다리의 길이만큼 0으로 채움)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            queue.add(0);
        }

        int time = 0;
        int total = 0;

        // 모든 트럭이 다리를 건널 때까지 반복
        while (!queue.isEmpty()) {
            time++;
            // 다리의 맨 앞 부분에서 트럭을 내림
            total -= queue.poll();

            if (!A.isEmpty()) {
                // 다리 위 트럭의 총 무게가 제한 이하일 경우 새로운 트럭을 올림
                if (A.peek() + total <= l) {
                    total += A.peek();
                    queue.add(A.poll());
                } else {
                    // 제한을 초과할 경우 0을 추가하여 다리의 길이 유지
                    queue.add(0);
                }
            }
        }

        // 걸린 시간 출력
        bw.write(time + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
