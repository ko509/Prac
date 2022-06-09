import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 644ms
// 메모리 : 148048KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[M][N];
			Queue<int[]> fire = new LinkedList<>();
			
			int sr = -1;
			int sc = -1;
			for (int i = 0; i < M; i++) {
				char[] str = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = str[j];
					if(map[i][j]=='@') {
						sr = i;
						sc = j;
						map[i][j] = '.';
					} else if(map[i][j]=='*') {
						fire.offer(new int[] {i, j});
					}
				}
			}
			
			int[] dr = {-1,0,1,0};
			int[] dc = {0,-1,0,1};
			
			Queue<int[]> que = new LinkedList<int[]>();
			que.offer(new int[] {sr, sc, 0});
			boolean[][] v = new boolean[M][N];
			v[sr][sc] = true;
			
			int time = 0;
			int answer = -1;
			move_fire(map, fire);
			outer : while(!que.isEmpty()) {
				int[] cur = que.poll();
				if(time!=cur[2]) {
					move_fire(map, fire);
					time++;
				}
				for (int d = 0; d < 4; d++) {
					int nr = cur[0]+dr[d];
					int nc = cur[1]+dc[d];
					if(nr >= M || nc >= N || nr<0 || nc < 0) {
						answer = cur[2]+1;
						break outer;
					}
					if(v[nr][nc] || map[nr][nc]!='.') continue;
					v[nr][nc] = true;
					que.offer(new int[] {nr, nc, cur[2]+1});
				}
			}
			if(answer==-1) sb.append("IMPOSSIBLE\n");
			else sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static void move_fire(char[][] map, Queue<int[]> fire) {

		int M = map.length;
		int N = map[0].length;
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};

		int len = fire.size();
		
		for (int i = 0; i < len; i++) {
			int[] cur = fire.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr >= M || nc >= N || nr < 0 || nc < 0) continue;
				if(map[nr][nc]!='.') continue;
				map[nr][nc] = '*';
				fire.offer(new int[] {nr, nc});
			}
		}
		
	}

}
