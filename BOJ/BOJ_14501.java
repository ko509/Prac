package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14501 {

	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] work = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			work[i][0] = Integer.parseInt(st.nextToken());
			work[i][1] = Integer.parseInt(st.nextToken());
			if(work[i][0]+i>N) {
				work[i][0] = work[i][1] = -1;
			}
		}
		max = Integer.MIN_VALUE;
		subset(work, 0, new boolean[N]);
		System.out.println(max);
	}

	private static void subset(int[][] work, int cnt, boolean[] v) {

		int N = work.length;
		if(cnt==N) {
			boolean[] havework = new boolean[N];
			int paid = 0;
			for (int i = 0; i < N; i++) {
				if(v[i]) {
					if(havework[i]) return;
					int endday = i+work[i][0];
					for (int j = i; j < endday; j++) {
						havework[j] = true;
					}
					paid+=work[i][1];
				}
			}
			max = Math.max(max, paid);
			return;
		}
		
		v[cnt] = true;
		subset(work, cnt+1, v);
		v[cnt] = false;
		subset(work, cnt+1, v);
	}



}
