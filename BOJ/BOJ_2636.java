package _1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] cheeze = new int[N][M];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheeze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		int cnt = 0;
		while(true) {
			int n = melting(cheeze);
			if(n==0) break;
			else ans = n;
			cnt++;
		}
		System.out.println(cnt);
		System.out.println(ans);
	}
	
	private static int melting(int[][] cheeze) {

		int N = cheeze.length;
		int M = cheeze[0].length;
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		
		int cnt = 0;
		boolean[][] v = new boolean[N][M];
		v[0][0] = true;
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {0,0});
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(nr>=N || nr<0 || nc>=M || nc<0) continue;
				if(v[nr][nc]) continue; 
				if(cheeze[nr][nc]==1) {
					v[nr][nc] = true;
					cheeze[nr][nc] = 0;
					cnt++;
				}
				else {
					v[nr][nc] = true;
					que.offer(new int[] {nr,nc});
				}
			}
		}
		return cnt;
	}

}
