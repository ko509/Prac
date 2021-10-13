package _1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int group = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					country(map, i, j, group++);
				}
			}
		}
		
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]!=0) {
					int n = bridge(map, i, j, map[i][j]);
					if(min>n) {
						min = n;
					}
				}
			}
		}
		System.out.println(min);
		
	}

	private static int bridge(int[][] map, int r, int c, int group) {

		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		int N = map.length;
		
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {r,c,0});
		boolean[][] visited = new boolean[N][N];
		visited[r][c] = true;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int cr = cur[0];
			int cc = cur[1];
			int n = cur[2];
			if(map[cr][cc]!=0 && map[cr][cc]!=group) {
				return n-1;
			}
			for (int d = 0; d < 4; d++) {
				int nr = cr+dr[d];
				int nc = cc+dc[d];
				if(nr>=N || nr<0 || nc>=N || nc<0) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc]==group) continue;
				visited[nr][nc] = true;
				que.offer(new int[] {nr,nc,n+1});
			}
		}
	
		return Integer.MAX_VALUE;
	}

	private static void country(int[][] map, int r, int c, int group) {

		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		int N = map.length;
		
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {r,c});
		map[r][c] = group;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int cr = cur[0];
			int cc = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr+dr[d];
				int nc = cc+dc[d];
				if(nr>=N || nr<0 || nc>=N || nc<0) continue;
				if(map[nr][nc]!=1) continue;
				map[nr][nc]=group;
				que.offer(new int[] {nr, nc});
			}
		}
	}

}
