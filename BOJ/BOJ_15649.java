package _202203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 176ms
// 메모리 : 20128KB
public class BOJ_15649 {

	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		perm(0, new int[M], new boolean[N]);
		System.out.println(sb.toString());
	}

	private static void perm(int cnt, int[] num, boolean[] v) {

		int N = v.length;
		int M = num.length;
		
		if(cnt==M) {
			
			for (int i = 0; i < M; i++) {
				sb.append(num[i]+1);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			v[i] = true;
			num[cnt] = i;
			perm(cnt+1, num, v);
			v[i] = false;
		}
	}

}
