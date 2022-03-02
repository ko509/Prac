import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 228ms
// 메모리 : 41648KB

public class BOJ_17142 {

	static int min;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		List<int[]> virus = new ArrayList<>();
		int total = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0) - '0';
				if(map[i][j]==2) virus.add(new int[] {i,j});
				else if(map[i][j]==0) total++;
			}
		}
		
		min = Integer.MAX_VALUE;
		perm(0, 0, 0, new int[M], virus, map, total);
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}

	private static void perm(int cnt, int start, int flag, int[] num, List<int[]> virus, int[][] map, int total) {

		int V = virus.size();
		int N = map.length;
		int M = num.length;
		if(cnt==M) {
			int[] dr = {-1,0,1,0};
			int[] dc = {0,-1,0,1};
			
			Queue<int[]> que = new LinkedList<int[]>();
			boolean[][] v = new boolean[N][N];
			
			for (int i = 0; i < M; i++) {
				int[] cur = virus.get(num[i]);
				que.offer(new int[] {cur[0], cur[1], 0});
			}
			int count = 0;
			while(!que.isEmpty()) {
				int[] cur = que.poll();
				int r = cur[0], c = cur[1], t = cur[2];
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr<0 || nc<0 || nr>=N || nc>=N || map[nr][nc]==1 || v[nr][nc]) continue;
					if(map[nr][nc]!=2) {
						total--;
						count = t+1;
						if(count>=min) return;
						if(total==0) {
							min = Math.min(count, min);
							return;
						}
						v[nr][nc] = true;
						que.offer(new int[] {nr,nc, t+1});
					}else if(total==0) {
						min = Math.min(count, min);
						return;
					}else {
						count = t+1;
						v[nr][nc] = true;
						que.offer(new int[] {nr,nc, t+1});
					}
					
				}
			}
			if(total==0) min = Math.max(count, min);
			return;
		}
		
		for (int i = start; i < V; i++) {
			if((flag&(1<<i))!=0) continue;
			flag |= (1<<i);
			num[cnt] = i;
			perm(cnt+1, i+1, flag, num, virus, map, total);
			flag &= ~(1<<i);
		}
	}
}
