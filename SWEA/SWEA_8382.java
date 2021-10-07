package _1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_8382 {

	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int sc = Integer.parseInt(st.nextToken())+100;
			int sr = Integer.parseInt(st.nextToken())+100;
			int ec = Integer.parseInt(st.nextToken())+100;
			int er = Integer.parseInt(st.nextToken())+100;
			
			ans = -1;
			go(sc, sr, ec, er);
			System.out.println("#"+t+" "+ans);
		}
	}

	private static void go(int sc, int sr, int ec, int er) {

		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		
		boolean[][][] visited = new boolean[201][201][2];
		
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {sr, sc, 0, 0, 0});
		que.offer(new int[] {sr, sc, 1, 0, 1});
		visited[sr][sc][0] = visited[sr][sc][1] = true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			int s = cur[2];
			int n = cur[4];
			if(r==er && c==ec) {
				ans = cur[3];
				return;
			}
			for (int d = 0; d < 4; d++) {
				if(d%2==s) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					if(nr>=201 || nc>=201|| nc<0 || nr<0) continue;
					if(visited[nr][nc][n]) continue;
					visited[nr][nc][n] = true;
					que.offer(new int[] {nr,nc, (s+1)%2, cur[3]+1, n});
				}
			}
		}
	}

}
