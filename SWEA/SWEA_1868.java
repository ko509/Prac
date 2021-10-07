package _1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1868 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int[][] counter = new int[N][N];
			for (int i = 0; i < N; i++) {
				String st = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = st.charAt(j)=='.'? -1:-2;
				}
			}
			int cnt =0;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==-1 && iszero(map, i, j)==0) {
				//		int[][] tmp = deepcopy(map);
						poping(map, counter, i, j);
						cnt++;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==-1) cnt++;
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}
		
	}

	private static void poping(int[][] map, int[][] counter, int r, int c) {

		int[] dr = {-1,-1,-1,0,0,1,1,1};
		int[] dc = {-1,0,1,-1,1,-1,0,1};
		
		int N = map.length;
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {r,c});
		boolean[][] v = new boolean[N][N];
		map[r][c] = 0;
		v[r][c] = true;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			for (int d = 0; d < 8; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				if(!checked(map, nr, nc)) continue;
				if(v[nr][nc]) continue;
				v[nr][nc] = true;
				map[nr][nc] = iszero(map, nr, nc);
				if(map[nr][nc]==0) que.offer(new int[] {nr,nc});
			}
		}
	}

	private static int[][] deepcopy(int[][] map) {

		int N = map.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
			}
		}
		return null;
	}

	private static int iszero(int[][] map, int r, int c) {

		int[] dr = {-1,-1,-1,0,0,1,1,1};
		int[] dc = {-1,0,1,-1,1,-1,0,1};
		
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(!checked(map, nr, nc)) continue;
			if(map[nr][nc]==-2) cnt++;
		}
		return cnt;
	}

	private static boolean checked(int[][] map, int nr, int nc) {

		int N = map.length;
		return nr>=0 && nr<N && nc<N && nc>=0;
	}



}
