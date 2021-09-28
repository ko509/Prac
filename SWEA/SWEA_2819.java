package _0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2819 {
	
	static ArrayList<int[]> list;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int[][] map = new int[4][4];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			list = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					int[] num = new int[7];
					num[0] = map[i][j];
					makenum(map, num, 0, i, j);
				}
			}
			System.out.println("#"+t+" "+list.size());
			for (int[] is : list) {
				System.out.println(Arrays.toString(is));
			}
		}
		
	}
	private static void makenum(int[][] map, int[] num, int cnt, int r, int c) {

		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		if(cnt==6) {
			for (int[] s : list) {
				if(go(s, num)) return;
			}
			int[] nnum = new int[7];
			for (int i = 0; i < 7; i++) {
				nnum[i] = num[i];
			} 
			list.add(nnum);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr>=4 || nr<0 || nc>=4 || nc<0) continue;
			num[cnt+1] = map[nr][nc]; 
			makenum(map, num, cnt+1, nr, nc);
		}
	}
	private static boolean go(int[] s, int[] num) {

		for (int i = 0; i < 7; i++) {
			if(s[i]!=num[i]) return false;
		}
		return true;
	}
}