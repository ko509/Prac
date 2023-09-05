import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 1964ms
// 메모리 : 470408KB
public class Main {

	static int N;
	static int M;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		
		int cnt = 0;
		Queue<int[]> que = new LinkedList<>();
		boolean[][][] v = new boolean[N][M][4];
		int[][] v2 = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j * 2) - '0';
				if(map[i][j] == 9) {
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						if(check(nr, nc)) continue;
						if(v[nr][nc][d]) continue;
						v[nr][nc][d] = true;
						que.offer(new int[] {nr, nc, d});
						v2[nr][nc] = 1;
					}
					v2[i][j] = 1;
				}
			}
		}
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			int dd = cur[2];
			
			int d = -1;
			if(map[r][c] == 0) {
				d = dd;
			} else if(map[r][c] == 1) {
				if(dd % 2 == 0) {
					d = dd;
				}
			} else if(map[r][c] == 2) {
				if(dd % 2 == 1) {
					d = dd;
				}
			} else if(map[r][c] == 3) {

				if(dd == 0) d = 3;
				else if(dd == 3) d = 0;
				else if(dd == 1) d = 2;
				else d = 1;
				
			} else if(map[r][c] == 4){

				if(dd == 0) d = 1;
				else if(dd == 1) d = 0;
				else if(dd == 2) d = 3;
				else d = 2;
				
			}
			
			if(d == -1) continue;
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(check(nr, nc)) continue;
			if(v[nr][nc][d]) continue;
			v[nr][nc][d] = true;
			que.offer(new int[] {nr, nc, d});
			v2[nr][nc] = 1;
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(v2[i][j] == 1) cnt++;
			}
		}
		
		System.out.println(cnt);
			
	}
	private static boolean check(int nr, int nc) {
		return nr >= N || nc >= M || nr < 0 || nc < 0;
	}

}
