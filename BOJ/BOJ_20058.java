import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 408ms
// 메모리 : 88372KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int N2 = (int) Math.pow(2, N);
		int[][] map = new int[N2][N2];
		
		for (int i = 0; i < N2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N2; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int op = Integer.parseInt(st.nextToken());
			op = (int) Math.pow(2, op);
			turn(map, op);
			meltiong(map);
		}
		int[] answer = checking(map);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}

	private static int[] checking(int[][] map) {
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		int N = map.length;
		boolean[][] v = new boolean[N][N];
		int max = 0;
		int total = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(v[i][j] || map[i][j]<=0) continue;
				int count = 1;
				Queue<int[]> que = new LinkedList<>();
				que.offer(new int[] {i,j});
				v[i][j] = true;
				total+=map[i][j];
				while(!que.isEmpty()) {
					int[] cur = que.poll();
					int r = cur[0];
					int c = cur[1];
					for (int d = 0; d < 4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if(nr<0 || nc<0 || nr>=N || nc>=N || v[nr][nc] || map[nr][nc]<=0) continue;
						count++;
						total+=map[nr][nc];
						v[nr][nc] = true;
						que.offer(new int[] {nr, nc});
					}
				}
				max = Math.max(max, count);
			}
		}
		return new int[] {total, max};
	}

	private static void meltiong(int[][] map) {

		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		int N = map.length;
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int count = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i+dr[d];
					int nc = j+dc[d];
					if(nr>=N || nc>=N || nr<0 || nc<0 || map[nr][nc]<=0) continue;
					count++;
				}
				if(count<3) {
					tmp[i][j]--;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] +=tmp[i][j];
			}
		}
	}

	private static void turn(int[][] map, int op) {

		int N = map.length;
		for (int i = 0; i < N; i+=op) {
			for (int j = 0; j < N; j+=op) {
				turnsmall(map, i, j, op);
			}
		}
	}

	private static void turnsmall(int[][] map, int r, int c, int op) {

		int[][] tmp = new int[op][op];
		for (int i = 0; i < op; i++) {
			for (int j = 0; j < op; j++) {
				tmp[j][op-i-1] = map[r+i][c+j];
			}
		}
		for (int i = 0; i < op; i++) {
			for (int j = 0; j < op; j++) {
				map[r+i][c+j] = tmp[i][j];
			}
		}
	}

}
