package _1101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SWEA_1249 {
	
	public static class Node implements Comparable<Node>{
		int r;
		int c;
		int w;
		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Node(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j)-'0';
				}
			}
			
			int ans = calcost(map);
			System.out.println("#"+t+" "+ans);
		}
	}

	private static int calcost(int[][] map) {

		int N = map.length;
		int[][] cost = new int[N][N];
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<Node> que = new PriorityQueue<>();
		que.offer(new Node(0,0,map[0][0]));
		while(!que.isEmpty()) {
			Node cur = que.poll();
			int r = cur.r; int c = cur.c; int w = cur.w;
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
				if(map[nr][nc]+w>=cost[nr][nc]) continue;
				cost[nr][nc] = map[nr][nc]+w;
				que.offer(new Node(nr, nc, cost[nr][nc]));
			}
		}
		return cost[N-1][N-1];
	}

}
