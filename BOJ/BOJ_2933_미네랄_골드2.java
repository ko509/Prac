import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 412ms
// 메모리 : 50244KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int t = 1; t <= K; t++) {
			int h = N - Integer.parseInt(st.nextToken());
			if(t % 2 == 1) {
				// 왼쪽에서 오른쪽으로 던짐
				break_mineral(h, 0, map);
			} else {
				break_mineral(h, 1, map);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

	private static void break_mineral(int h, int type, char[][] map) {

		int N = map.length;
		int M = map[0].length;
		if(type == 0) {
			for (int i = 0; i < M; i++) {
				if(map[h][i] == 'x') {
					map[h][i] = '.';
					break;
				}
			}
		} else {
			for (int i = M-1; i >= 0; i--) {
				if(map[h][i] == 'x') {
					map[h][i] = '.';
					break;
				}
			}
		}
		
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		boolean[][] v = new boolean[N][M];
		Queue<int[]> que = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			if(map[N-1][i] == 'x') {
				v[N-1][i] = true;
				que.offer(new int[] {N-1, i});
			}
		}
		
		// 바닥이랑 이어져 있는 애들
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr >= N || nc >= M || nr < 0 || nc < 0) continue;
				if(v[nr][nc] || map[nr][nc] == '.') continue;
				v[nr][nc] = true;
				que.offer(new int[] {nr, nc});
			}
		}
		
		// 바닥이랑 안 이어져 있는 애들
		boolean[][] air = new boolean[N][M];
		for (int i = N - 2; i >= 0 ; i--) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'x' && !v[i][j] && !air[i][j]) {
					Queue<int[]> tmp = new LinkedList<>();
					List<int[]> store = new ArrayList<>();
					tmp.offer(new int[] {i, j});
					air[i][j] = true;
					while(!tmp.isEmpty()) {
						int[] cur = tmp.poll();
						store.add(cur);
						for (int d = 0; d < 4; d++) {
							int nr = cur[0] + dr[d];
							int nc = cur[1] + dc[d];
							if(nr >= N || nc >= M || nr < 0 || nc < 0) continue;
							if(v[nr][nc] || air[nr][nc] || map[nr][nc] == '.') continue;
							air[nr][nc] = true;
							tmp.offer(new int[] {nr, nc});
						}
					}
					int down = move_down(map, store, v);
					for (int[] ks : store) {
						map[ks[0]][ks[1]] = '.';
					}
					for (int[] ks : store) {
						map[ks[0]+down][ks[1]] = 'x';
						v[ks[0]+down][ks[1]] = true;
					}
				}
			}
		}

	}

	private static int move_down(char[][] map, List<int[]> tmp, boolean[][] v) {

		int N = map.length;
		int d = 1;
		tmp.sort(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
			
		});
		while(true) {
			for (int[] is : tmp) {
				if(is[0] + d == N - 1) {
					return d;
				}
				if(map[is[0] + d + 1][is[1]] == 'x' && v[is[0] + d + 1][is[1]]) {
					return d;
				}
				
			}
			d++;
		}
	}

}
