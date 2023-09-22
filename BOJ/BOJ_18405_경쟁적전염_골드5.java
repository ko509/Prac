import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간: 272ms
// 메모리 : 19728KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<int[]>[] que = new LinkedList[K + 1];
		
		for (int i = 0; i <= K; i++) {
			que[i] = new LinkedList<>();
		}
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0) {
					que[map[i][j]].offer(new int[] {i, j, 0});
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;
		int Y = Integer.parseInt(st.nextToken()) - 1;
		
		
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		int time = 0;
		while(time < S) {
			for (int i = 1; i <= K; i++) {
				while(!que[i].isEmpty()) {
					if(que[i].peek()[2] == time) {
						int[] cur = que[i].poll();
						for (int d = 0; d < 4; d++) {
							int nr = cur[0] + dr[d];
							int nc = cur[1] + dc[d];
							
							if(nr >= N || nc >= N || nr < 0 || nc < 0) continue;
							if(map[nr][nc] > 0) continue;
							map[nr][nc] = i;
							que[i].offer(new int[] {nr, nc, cur[2] + 1});
						}
					} else break;
				}
			}
			time++;
		}
		System.out.println(map[X][Y]);
	}

}
