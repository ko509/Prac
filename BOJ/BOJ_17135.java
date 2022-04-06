import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 200ms
// 메모리 : 35228KB
public class Main {

	static int max;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = -1;
		comb(0, 0, map, new int[3], D);
		System.out.println(max);
	}

	private static void comb(int cnt, int start, int[][] tmp, int[] archer, int D) {

		int N = tmp.length;
		int M = tmp[0].length;
		int[] dr = {0,-1,1,0};
		int[] dc = {-1,0,0,1};
		
		if(cnt==3) {
			int[][] map = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = tmp[i][j];
				}
			}
			int count = 0; // 죽인 몬스터 마릿수
			boolean stop = false;
			while(!stop) {
				Queue<int[]> killmon = new LinkedList<>(); // 죽일 몬스터 위치 저장할 곳
				
				for (int i = 0; i < 3; i++) {
					Queue<int[]> que = new LinkedList<>(); // 최소 거리 이동
					que.offer(new int[] {N,archer[i], 0});
					boolean[][] v = new boolean[N][M];
					while(!que.isEmpty()) {
						boolean flag = false;
						int[] cur = que.poll();
						int r = cur[0]; int c = cur[1];
						if(cur[2]>=D) break; // 거리가 D 이상이면 나가기
						for (int d = 0; d < 4; d++) {
							int nr = r+dr[d];
							int nc = c+dc[d];
							// 범위 밖이면 지나치기
							if(nr<0 || nc<0 || nr>=N || nc>=M || v[nr][nc]) continue;
							// 몬스터 발견한 경우 큐에 넣고 밖에 나가기
							if(map[nr][nc]==1) {
								killmon.offer(new int[] {nr,nc});
								flag = true;
								break;
							}
							v[nr][nc] = true;
							que.offer(new int[] {nr, nc, cur[2]+1});
						}
						if(flag) break; // 몬스터 발견한 경우 밖에 나가기
					}
				}
				while(!killmon.isEmpty()) {
					int[] is = killmon.poll();
					if(map[is[0]][is[1]]==1) {
						count++;
					}
					map[is[0]][is[1]] = 0;
				}
				boolean ismon = false;
				for (int i = N-1; i >= 1 ; i--) {
					for (int j = M-1; j >= 0; j--) {
						if(map[i-1][j]==1) {
							ismon = true;
						}
						map[i][j] = map[i-1][j];
						map[i-1][j] = 0;
					}
				}
				if(!ismon) stop = true;
			}
			max = Math.max(max, count);
			return;
		}
		for (int i = start; i < M; i++) {
			archer[cnt] = i;
			comb(cnt+1, i+1, tmp, archer, D);
		}
	}

}
