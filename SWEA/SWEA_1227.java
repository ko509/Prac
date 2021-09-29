package _0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1227 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		for (int t = 1; t <= T; t++) {
			int N = 100;
			int K = Integer.parseInt(br.readLine());
			int sr = -1; int sc = -1;
			int er = -1; int ec = -1;
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j)-'0';
					if(map[i][j]==2) {
						sr = i; sc = j;
					}else if(map[i][j]==3){
						er = i; ec = j;
					}
				}
			}
			System.out.println("#"+K+" "+bfs(map, sr, sc, er, ec));
			
		}
	}

	private static int bfs(int[][] map, int sr, int sc, int er, int ec) {

		int N = 100;
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {sr, sc});
		visited[sr][sc] = true;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0]; int c = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(nr==er && nc==ec) return 1;
				if(!checked(nr,nc)|| map[nr][nc]==1) continue;
				if(visited[nr][nc]) continue;
				visited[nr][nc]=true;
				que.offer(new int[] {nr,nc});
			}
		}
		return 0;
	}

	private static boolean checked(int nr, int nc) {

		int N = 100;
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}

}
