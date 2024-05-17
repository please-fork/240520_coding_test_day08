// package boj11866;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// 입력을 파일에서 받기 위해 설정
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력값을 읽어서 N과 K로 분리
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int K = Integer.parseInt(tmp[1]);

		// Queue 생성 및 1부터 N까지의 숫자를 추가
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		// 결과 출력 형식을 맞추기 위해 <로 시작
		bw.write("<");
		
		// Queue가 비어있지 않을 때까지 반복
		while (!queue.isEmpty()) {
			// K번째 사람을 제거하기 위해 K-1번 회전
			for (int i = 1; i <= K; i++) {
				if (i == K) {
					// K번째 사람을 제거하고 출력
					bw.write(queue.poll() + "");
					// Queue가 비어있다면 >로 마무리, 아니면 ,로 구분
					if (queue.isEmpty()) {
						bw.write(">");
					} else {
						bw.write(", ");
					}
				} else {
					// K번째가 아니라면 맨 앞의 사람을 뒤로 보냄
					queue.add(queue.poll());
				}
			}
		}
		
		// 출력 버퍼를 비움
		bw.flush();
		// 자원 해제
		br.close();
		bw.close();
	}
}
