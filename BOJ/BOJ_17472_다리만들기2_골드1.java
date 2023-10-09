import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 80ms
// 메모리 : 11740KB
public class Main {

	static int N;
	static int M;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int[] parent;
	static int[] rank;
	static int total;
    static int group;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 땅 분리
		init_land(map);
		
		// 다리의 경우의 수 저장할 우선순위 큐
		PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		// 경우의 수
		bridge(map, que);
		
		// 잇기
		bridge_land(que);
		
		if(rank[find(2)] == group - 2) System.out.println(total);
		else System.out.println(-1);
	}

	private static void bridge_land(PriorityQueue<int[]> que) {

		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			int n = union(cur[0], cur[1]);
			if(n == 0) continue;
			total += cur[2];
			if(n == 2) return;
			
		}
	}

	private static int union(int p, int q) {

		int pp = find(p);
		int pq = find(q);
		
		if(pp == pq) return 0;
		
		if(rank[pp] >= rank[pq]) {
			parent[pq] = pp;
			rank[pp] += rank[pq];
			if(rank[pp] == group - 2) return 2;
		} else {
			parent[pp] = pq;
			rank[pq] += rank[pp];
			if(rank[pq] == group - 2) return 2;
		}
		
		return 1;
		
	}

	private static int find(int p) {
		if(p == parent[p]) return p;
		return parent[p] = find(parent[p]);
	}

	private static void bridge(int[][] map, PriorityQueue<int[]> que) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) continue;
				
				for (int d = 0; d < 4; d++) {
					int nr = i;
					int nc = j;
					int time = 0;
					while(true) {
						nr = nr + dr[d];
						nc = nc + dc[d];
						
						if(nr >= N || nc >= M || nr < 0 || nc < 0 || map[i][j] == map[nr][nc]) break;
						if(map[nr][nc] > 0) {
							if(time < 2) break; 
							que.offer(new int[] {map[i][j], map[nr][nc], time});
							break;
						}
						time++;
					}
				}
			}
		}
	}

	private static void init_land(int[][] map) {

		group = 2;
		Queue<int[]> que = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 1) continue;
				que.offer(new int[] {i, j});
				map[i][j] = group;
				while(!que.isEmpty()) {
					int[] cur = que.poll();
					
					for (int d = 0; d < 4; d++) {
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];
						
						if(nr >= N || nc >= M || nr < 0 || nc < 0 || map[nr][nc] != 1) continue;
						map[nr][nc] = group;
						que.offer(new int[] {nr, nc});
					}
				}
				group++;
			}
		}
		parent = new int[group];
		rank = new int[group];
		for (int i = 0; i < group; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}

}
