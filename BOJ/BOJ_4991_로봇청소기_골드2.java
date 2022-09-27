import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		String str;
		while(!(str = br.readLine()).equals("0 0")) {
			st = new StringTokenizer(str);
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			char[][] map = new char[N][M];
			List<int[]> dust = new ArrayList<>();
			int[] robot = new int[2];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 'o') {
                        dust.add(0, new int[]{i, j});
                        map[i][j] = '.';
					} else if(map[i][j] == '*') {
						dust.add(new int[] {i, j});
					}
				}
			}
			
			int dlen = dust.size();
			// 먼지구덩이 간 인접행렬 구하기
			int[][] adj = make_adj(dust, map);
			if(adj == null) {
				sb.append(-1).append("\n");
				continue;
			}
			// 청소할 먼지구덩이 perm 구하기
			min = Integer.MAX_VALUE;
			perm(1, new boolean[dlen], 0, 0, adj);
			sb.append(min).append("\n");
		}
        System.out.println(sb);
	}

	private static void perm(int cnt, boolean[] v, int prev, int total, int[][] adj) {
		
		int D = adj.length;
		if(min <= total) return;
		if(cnt == D) {
			min = Math.min(min, total);
			return;
		}
		
		for (int i = 1; i < D; i++) {
			if(v[i]) continue;
			v[i] = true;
			perm(cnt+1, v, i, total+adj[prev][i], adj);
			v[i] = false;
		}
	}

	private static int[][] make_adj(List<int[]> dust, char[][] map) {

		int N = map.length;
		int M = map[0].length;
		int D = dust.size();
		
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		
		int[][] adj = new int[D][D];
		for (int i = 0; i < D; i++) {
			Arrays.fill(adj[i], 987654321);
		}
		for (int i = 0; i < D; i++) {
//			Arrays.fill(adj[i], 987654321);
			adj[i][i] = 0;
			for (int j = i + 1; j < D; j++) {
				int[] start = dust.get(i);
				int[] end = dust.get(j);
				Queue<int[]> que = new LinkedList<>();
				boolean[][] v = new boolean[N][M];
				que.add(new int[] {start[0], start[1], 0});
				v[start[0]][start[1]] = true;
				while(!que.isEmpty()) {
					int[] cur = que.poll();
					if(cur[0] == end[0] && cur[1] == end[1]) {
						adj[i][j] = cur[2];
						adj[j][i] = adj[i][j];
						break;
					}
					for (int d = 0; d < 4; d++) {
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];
						if(nr >= N || nc >= M || nr < 0 || nc < 0 || v[nr][nc]) continue;
						if(map[nr][nc] == 'x') continue;
						v[nr][nc] = true;
						que.offer(new int[] {nr, nc, cur[2] + 1});
					}
				}
				if(adj[i][j] == 987654321) return null;
			}
		}
		return adj;
	}

}
