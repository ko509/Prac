package _0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2667 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = s[j]-'0';
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1)list.add(divide(map, i, j, 2));
			}
		}
		list.sort(null);
		System.out.println(list.size());
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}

	private static int divide(int[][] map, int r, int c, int group) {

		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		int cnt = 1;
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {r,c});
		map[r][c] = group;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				if(!checked(nr, nc, map) || map[nr][nc]!=1) continue;
				map[nr][nc]=group;
				que.offer(new int[] {nr,nc});
				cnt++;
			}
		}
		return cnt;
	}

	private static boolean checked(int nr, int nc, int[][] map) {

		int N = map.length;
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}

}
