import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 316ms
// 메모리 : 53940KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int highest = -1;
		int lowest = 101;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > highest) highest = map[i][j];
				if(map[i][j] < lowest) lowest = map[i][j];
			}
		}
		
		int max = 1;
		for (int i = lowest; i <= highest; i++) {
			max = Math.max(max, bfs(map, i));
		}
		System.out.println(max);
	}

	private static int bfs(int[][] map, int rain) {

		int N = map.length;
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		int cnt = 0;
		boolean[][] v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(v[i][j] || map[i][j] <= rain) continue;
				cnt++;
				Queue<int[]> que = new LinkedList<>();
				que.offer(new int[] {i,j});
				v[i][j] = true;
				while(!que.isEmpty()) {
					int[] cur = que.poll();
					for (int d = 0; d < 4; d++) {
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];
						if(nr >= N || nc >= N || nr < 0 || nc < 0) continue;
						if(v[nr][nc] || map[nr][nc] <= rain) continue;
						que.offer(new int[] {nr, nc});
						v[nr][nc] = true;
					}
				}
			}
		}
		return cnt;
	}

}
