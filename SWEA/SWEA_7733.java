package _0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7733 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] cheese = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int turn = 100;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i <= turn; i++) {
				int [][] tmp = eat(cheese, i);
				int n = group(tmp);
				if(n>max) {
					max = n;
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}


	private static int group(int[][] tmp) {

		int N = tmp.length;
		int cnt = 0;
		
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(tmp[i][j]!=-1) {
					cnt++;
					Queue<int[]> que = new LinkedList<int[]>();
					tmp[i][j]=-1;
					que.offer(new int[] {i,j});
					while(!que.isEmpty()) {
						int[] cur = que.poll();
						for (int d = 0; d < 4; d++) {
							int nr = cur[0]+dr[d];
							int nc = cur[1]+dc[d];
							if(!checked(nr,nc,tmp) || tmp[nr][nc]==-1) continue;
							tmp[nr][nc]=-1;
							que.offer(new int[] {nr,nc});
						}
					}
				}
			}
		}
		return cnt;
	}


	private static boolean checked(int nr, int nc, int[][] tmp) {

		int N = tmp.length;
		return nr>=0 && nr< N && nc>=0 && nc<N;
	}


	private static int[][] eat(int[][] cheese, int day) {

		int N = cheese.length;
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(cheese[i][j]==day) cheese[i][j]=-1;
				tmp[i][j] = cheese[i][j];
			}
		}
		return tmp;
	}

}
