import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 84ms
// 메모리 : 11892KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		Queue<int[]> que = new LinkedList<>();
        Queue<int[]> kaktus = new LinkedList<>();
        boolean[][] v = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '*') que.offer(new int[] {i, j, 0});
				else if(map[i][j] == 'S') {
					map[i][j] = '.';
                    kaktus.offer(new int[] {i, j, 0});
                    v[i][j] = true;
				}
			}
		}
		
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		int time = 0;
		
		while(!kaktus.isEmpty()) {
			// 물
			while(!que.isEmpty() && que.peek()[2] == time) {
				int[] cur = que.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					
					if(nr >= R || nc >= C || nr < 0 || nc < 0) continue;
					if(map[nr][nc] != '.') continue;
					map[nr][nc] = '*';
					que.offer(new int[] {nr, nc, cur[2] + 1});
				}
			}
			
			while(!kaktus.isEmpty() && kaktus.peek()[2] == time) {
				int[] cur = kaktus.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					
					if(nr >= R || nc >= C || nr < 0 || nc < 0) continue;
					if(v[nr][nc]) continue;
					if(map[nr][nc] == '*' || map[nr][nc] == 'X') continue;
					if(map[nr][nc] == 'D') {
						System.out.println(time + 1);
						return;
					}
					v[nr][nc] = true;
					kaktus.offer(new int[] {nr, nc, cur[2] + 1});
				}
			}
			time++;
		}
		System.out.println("KAKTUS");
	}

}
