import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[H][W];
		
		int[][] C = new int[2][2];
		int c = 0;
		
		for (int i = 0; i < H; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < W; j++) {
				if(map[i][j] == 'C') {
					C[c][0] = i;
					C[c++][1] = j;
				}
			}
		}
		
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		
		PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		que.offer(new int[] {C[0][0], C[0][1], 1, -1});
		
		int[][][][] v = new int[H][W][4][4];
		v[C[0][0]][C[0][1]][0][0] = 1;
		v[C[0][0]][C[0][1]][1][1] = 1;
		v[C[0][0]][C[0][1]][2][2] = 1;
		v[C[0][0]][C[0][1]][3][3] = 1;
		
		
		int min = 0;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(cur[0] == C[1][0] && cur[1] == C[1][1]) {
				min = cur[2];
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr >= H || nc >= W || nr < 0 || nc < 0) continue;
				if(map[nr][nc] == '*') continue;
				if(cur[3] == -1) {
					v[nr][nc][d][d] = cur[2];
					que.offer(new int[] {nr, nc, cur[2], d});
					continue;
				}
				if(v[nr][nc][cur[3]][d] != 0 && v[nr][nc][cur[3]][d] <= cur[2]) continue;
				
				v[nr][nc][cur[3]][d] = cur[2];
				if(d == cur[3]) que.offer(new int[] {nr, nc, cur[2], d});
				else que.offer(new int[] {nr, nc, cur[2] + 1, d});
			}
		}
		
		System.out.println(min - 1);
		
	}

}
