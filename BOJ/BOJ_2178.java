import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 96ms
// 메모리 : 12360KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[j]-'0';
			}
		}
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0,0,1});
		map[0][0] = 2;
		
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		
		int answer = 0;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(cur[0]==N-1 && cur[1]==M-1) {
				answer = cur[2];
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr >= N || nc >= M || nr < 0 || nc < 0) continue;
				if(map[nr][nc]!=1) continue;
				map[nr][nc] = 2;
				que.offer(new int[] {nr, nc, cur[2]+1});
			}
		}
		System.out.println(answer);
	}

}
