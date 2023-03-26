import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int zero;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		List<int[]> poss = new ArrayList<>();
		zero = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) poss.add(new int[] {i, j});
				else if(map[i][j] == 0) zero++;
			}
		}
		
		min = Integer.MAX_VALUE;
		comb(0, 0, new boolean[poss.size()], poss, map);
		if(min != Integer.MAX_VALUE) System.out.println(min);
		else System.out.println(-1);
	}

	static int min;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	private static void comb(int m, int start, boolean[] v, List<int[]> poss, int[][] map) {

		if(zero == 0) {
			min = 0;
			return;
		}
		int n = poss.size();
		int N = map.length;
		if(m == M) {
			int tmp = zero;
			boolean[][] virus = new boolean[N][N];
			Queue<int[]> que = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				if(v[i]) {
					int r = poss.get(i)[0];
					int c = poss.get(i)[1];
					que.offer(new int[] {r,c, 0});
					virus[r][c] = true;
				}
			}
			int time = 0;
			while(!que.isEmpty()) {
				int[] cur = que.poll();
				time = cur[2] + 1;
				if(time >= min) return;
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if(nr >= N || nc >= N || nr < 0 || nc < 0) continue;
					if(virus[nr][nc] || map[nr][nc] == 1) continue;
					if(map[nr][nc] == 0) tmp--;
					if(tmp == 0) {
						if(time < min) min = time;
						return;
					}
					virus[nr][nc] = true;
					que.offer(new int[] {nr, nc, cur[2] + 1});
				}
			}
			if(tmp != 0) return;
			if(time < min) min = time;
			return;
		}
		
		for (int i = start; i < n; i++) {
			v[i] = true;
			comb(m + 1, i+1, v, poss, map);
			v[i] = false;
		}
	}

}
