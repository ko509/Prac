package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17141 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] room = new int[N][N];
		ArrayList<int[]> germ = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				// 세균 놓을 수 있는 자리 2, 벽 1, 빈 공간 0
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j]==2) germ.add(new int[] {i,j});
				
			}
		}
		
		comb(0,0, new boolean[germ.size()], room, M, germ); 
		if (min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
		
	}

	static int min = Integer.MAX_VALUE;
	private static void comb(int start, int cnt, boolean[] v, int[][] room, int M, ArrayList<int[]> germ) {

		
		if (cnt==M) {
			// 바이러스 냅둘 공간 M개 선정 완료
//			System.out.println(Arrays.toString(v));
//			System.out.println();
			
			// 깊은 복사 + 바이러스 위치 초기값  3, 벽 1, 빈 공간 0
			int[][] copy = deepcopy(room, v, germ);
			int N = room.length;
			int ans = virus(copy);
			
			min = Math.min(ans, min);
			return;
		}
		
		for (int i = start; i < germ.size(); i++) {
			if(v[i]) continue;
			v[i] = true;
			comb(i+1, cnt+1, v, room, M, germ);
			v[i] = false;
		}
	}

	private static int virus(int[][] copy) {

		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		
		int N = copy.length;
		Queue<int[]> que = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copy[i][j]==3) {
					que.offer(new int[] {i,j, 4});
					//visited[i][j] = true;
				}
				//if(copy[i][j]==1) visited[i][j] = true;
			}
		}
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			int time = cur[2];
			
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(nr>=N || nc>=N || nc<0 || nr<0 || copy[nr][nc]!=0) continue;
				que.offer(new int[] {nr, nc, time+1});
				copy[nr][nc] = time;
				//visited[nr][nc] = true;
			}
			
		}
		int maxtime = Integer.MIN_VALUE;
		outer : for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				maxtime = Math.max(maxtime, copy[i][j]-3);
				if(copy[i][j]==0){
					maxtime = Integer.MAX_VALUE;
					break outer;
				}
			}
		}
		
		return maxtime;
	}

	private static int[][] deepcopy(int[][] room, boolean[] v, ArrayList<int[]> germ) {

		int N = room.length;
		// 깊은 복사
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = room[i][j];
			}
		}
		
		// 선정된 바이러스 
		int G = germ.size();
		for (int i = 0; i < G; i++) {
			if(v[i]) copy[germ.get(i)[0]][germ.get(i)[1]] = 3;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(copy[i][j]==2) copy[i][j]=0;
			}
		}
		
		return copy;
	}

}
