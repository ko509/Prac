package _202204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 384ms
// 메모리 : 112108KB
public class BOJ_15651 {

	static StringBuilder sb;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		perm(0, new int[M], N);
		System.out.println(sb.toString());
	}

	private static void perm(int cnt, int[] num, int N) {
		
		int M = num.length;
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(num[i]+1);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			num[cnt] = i;
			perm(cnt+1, num, N);
		}
	}

}
