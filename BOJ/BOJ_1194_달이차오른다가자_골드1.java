import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 104ms
// 메모리 : 14344KB
public class Main {

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int N;
	static int M;
	static int min;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		Queue<int[]> que = new LinkedList<>();
		boolean[][][] v = new boolean[N][M][64];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0') {
					que.offer(new int[] {i, j, 0, 0});
					v[i][j][0] = true;
					map[i][j] = '.';
				}
			}
		}

		int time = -1;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(map[cur[0]][cur[1]] == '1') {
				time = cur[3];
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr >= N || nc >= M || nr < 0 || nc < 0) continue;
				if(v[nr][nc][cur[2]] || map[nr][nc] == '#') continue;
				if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
					if((cur[2] & (1 << map[nr][nc] - 'A')) > 0) {
						v[nr][nc][cur[2]] = true;
						que.offer(new int[] {nr, nc, cur[2], cur[3] + 1});
					}
				} else if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
					v[nr][nc][cur[2]] = true;
					que.offer(new int[] {nr, nc, cur[2] | (1 << map[nr][nc] - 'a'), cur[3] + 1});
				} else {
					v[nr][nc][cur[2]] = true;
					que.offer(new int[] {nr, nc, cur[2], cur[3] + 1});
				}
			}
		}
		System.out.println(time);
	}
}
