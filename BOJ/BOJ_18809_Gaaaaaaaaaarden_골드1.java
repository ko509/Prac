package _2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18809_Gaaaaaaaaaarden_골드1 {

	static int N;
	static int M;
	static int G;
	static int R;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		List<int[]> avail = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					avail.add(new int[] {i, j});
				}
			}
		}
		
		max = 0;
		green(0, 0, new int[G], new boolean[avail.size()], avail, map);
		System.out.println(max);
	}
	private static void green(int cnt, int start, int[] green, boolean[] v, List<int[]> avail, int[][] map) {

		int A = v.length;
		if(cnt == G) {
			red(0, 0, new int[R], green, v, avail, map);
			return;
		}
		
		for (int i = start; i < A; i++) {
			green[cnt] = i;
			v[i] = true;
			green(cnt + 1, i + 1, green, v, avail, map);
			v[i] = false;
		}
	}
	private static void red(int cnt, int start, int[] red, int[] green, boolean[] v, List<int[]> avail, int[][] map) {

		int A = v.length;
		if(cnt == R) {
//			System.out.println("배양액 뿌릴 수 있는 곳 개수 : " + avail.size());
			System.out.println("green : " + Arrays.toString(green));
			System.out.println("red : " + Arrays.toString(red));
			blooming(red, green, avail, map);
			return;
		}
		
		for (int i = start; i < A; i++) {
			if(v[i]) continue;
			red[cnt] = i;
			red(cnt + 1, i + 1, red, green, v, avail, map);
		}
	}
	
	static int max;
	private static void blooming(int[] red, int[] green, List<int[]> avail, int[][] map) {

		int[][] g_map = new int[N][M];
		int[][] r_map = new int[N][M];
		
		Queue<int[]> g_que = new LinkedList<>();
		Queue<int[]> r_que = new LinkedList<>();
		
		for (int i = 0; i < G; i++) {
			int[] g = avail.get(green[i]);
			g_que.offer(new int[] {g[0], g[1], 1});
			g_map[g[0]][g[1]] = 1;
		}
		
		for (int i = 0; i < R; i++) {
			int[] r = avail.get(red[i]);
			r_que.offer(new int[] {r[0], r[1], 1});
			r_map[r[0]][r[1]] = 1;
		}
		
		int cnt = 1;
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		
		int flower = 0;
		while(!g_que.isEmpty() || !r_que.isEmpty()) {
			while(!g_que.isEmpty() && g_que.peek()[2] == cnt) {
				int[] cur = g_que.poll();
				if(g_map[cur[0]][cur[1]] == -1) continue;
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					
					if(nr >= N || nr < 0 || nc >= M || nc < 0 || map[nr][nc] == 0) continue;
					if(g_map[nr][nc] != 0) continue;
					g_map[nr][nc] = cnt + 1;
					g_que.offer(new int[] {nr, nc, cnt + 1});
				}
			}
			
			while(!r_que.isEmpty() &&r_que.peek()[2] == cnt) {
				int[] cur = r_que.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					
					if(nr >= N || nr < 0 || nc >= M || nc < 0 || map[nr][nc] == 0) continue;
					if(r_map[nr][nc] > 0) continue;
					r_map[nr][nc] = cnt + 1;
					if(g_map[nr][nc] == cnt + 1) {
						flower++;
						g_map[nr][nc] = -1;
					} else {
						r_que.offer(new int[] {nr, nc, cnt + 1});
					}
				}
			}
			cnt++;
		}
		if(max < flower) max = flower;
	}

}
