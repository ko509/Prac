import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 300ms
// 메모리 : 73436KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int len = N*N;
		boolean[][] tmp = new boolean[N][N];
		int[] dr = {-1,0,1,0,0};
		int[] dc = {0,-1,0,1,0};
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j < len; j++) {
				if(i == j) continue;
				for (int k = j+1; k < len; k++) {
					if(i == k || j == k) continue;
					int r1 = i/N;
					int c1 = i%N;
					int r2 = j/N;
					int c2 = j%N;
					int r3 = k/N;
					int c3 = k%N;
					int cost = 0;
					boolean flag = true;
					for (int d = 0; d < 5; d++) {
						int nr1 = r1 + dr[d];
						int nc1 = c1 + dc[d];
						int nr2 = r2 + dr[d];
						int nc2 = c2 + dc[d];
						int nr3 = r3 + dr[d];
						int nc3 = c3 + dc[d];
						if(nr1 >= N || nr1 < 0 || nr2 >= N || nr2 < 0 || nr3 >= N || nr3 < 0) {
							flag = false;
							break;
						}
						if(nc1 >= N || nc1 < 0 || nc2 >= N || nc2 < 0 || nc3 >= N || nc3 < 0) {
							flag = false;
							break;
						}
						if(tmp[nr1][nc1] || tmp[nr2][nc2] || tmp[nr3][nc3]) {
							flag = false;
							break;
						}
						tmp[nr1][nc1] = true;
						tmp[nr2][nc2] = true;
						tmp[nr3][nc3] = true;
						cost += map[nr1][nc1] + map[nr2][nc2] + map[nr3][nc3];
						if(cost >= min) break;
					}
					tmp = new boolean[N][N];
					if(!flag) continue;
					min = Math.min(min, cost);
				}
			}
		}
		System.out.println(min);
	}

}
