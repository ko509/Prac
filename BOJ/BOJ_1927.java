package _202202_sk_jina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


// 시간 : 304ms
// 메모리 : 25904KB
public class BOJ_1927 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Long> que = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			long n = Long.parseLong(br.readLine());
			if(n==0) {
				if(que.isEmpty()) {
					sb.append(0);
					sb.append("\n");
				}else {
					sb.append(que.poll());
					sb.append("\n");
				}
			}else {
				que.offer(n);
			}
		}
		System.out.println(sb);
	}

}
