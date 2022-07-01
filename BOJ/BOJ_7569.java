import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 616ms
// 메모리 : 129164KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][][] tomato = new int[H][N][M];
		int total = 0;
		Queue<int[]> que = new LinkedList<int[]>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					if(tomato[i][j][k]==1) {
						que.offer(new int[] {i, j, k, 0});
					} else if(tomato[i][j][k]==0) total++;
				}
			}
		}
		
		int[] dh = {0,0,0,0,-1,1};
		int[] dr = {0,0,-1,1,0,0};
		int[] dc = {-1,1,0,0,0,0};
		
		int count = 0;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			count = cur[3];
			for (int d = 0; d < 6; d++) {
				int nh = cur[0] + dh[d];
				int nr = cur[1] + dr[d];
				int nc = cur[2] + dc[d];
				if(nh >= H || nr >= N || nc >= M || nh < 0 || nr < 0 || nc < 0) continue;
				if(tomato[nh][nr][nc]!=0) continue;
				tomato[nh][nr][nc] = 1;
				total--;
				que.offer(new int[] {nh, nr, nc, cur[3]+1});
			}
			
		}
		if(total > 0) count = -1;
		System.out.println(count);
	}

}
