import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 756ms
// 메모리 : 131884KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int n = Integer.compare(o2[0], o1[0]);
				return n;
			}
			
		});
		
		boolean[][] v = new boolean[N][M];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0 || j == 0 || i == N - 1 || j == M - 1) {
					que.offer(new int[] {map[i][j], i, j});
					v[i][j] = true;
				}
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		
		StringBuilder sb = new StringBuilder();
		while(K > 0) {
			int[] cur = que.poll();
			int r = cur[1];
			int c = cur[2];
			K--;
			sb.append(r + 1).append(" ").append(c + 1).append("\n");
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= N || nc >= M || nr < 0 || nc < 0) continue;
				if(v[nr][nc]) continue;
				v[nr][nc] = true;
				que.offer(new int[] {map[nr][nc], nr, nc});
			}
			
		}
		
		System.out.print(sb);
	}

}
