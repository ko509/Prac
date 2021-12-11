package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638 {

	static int R;
	static int C;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int N;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = 0;
		int[][] cheese = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken()); 
				if(cheese[i][j]==1) N++;
			}
		}
		int time = 0;
		while(N!=0) {
			melting(cheese);
			time++;
		}
		System.out.println(time);
	}

	private static void melting(int[][] cheese) {

		int[][] temp = new int[R][C];
		boolean[][] v = new boolean[R][C];
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {0,0});
		v[0][0] = true;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(nr<0 || nc<0 || nr>=R || nc>=C || v[nr][nc]) continue;
				if(cheese[nr][nc]==0) {
					v[nr][nc] = true;
					que.offer(new int[] {nr, nc});
				}
				if(cheese[nr][nc]==1) {
					temp[nr][nc]++;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(temp[i][j]>=2) {
					cheese[i][j] = 0;
					N--;
				}
			}
		}
	}

	private static boolean ischeese(int[][] cheese) {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(cheese[i][j]==1) return true;
			}
		}
		return false;
	}

}
