import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		move_2048(0, map);
		
		System.out.println(max);
	}

	static int max;
	private static void move_2048(int cnt, int[][] map) {
		
		int N = map.length;
		if(cnt == 5) {
			int m = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(m < map[i][j]) m = map[i][j];
				}
			}
			max = Math.max(max, m);
			return;
		}
		
		int[][] tmp = new int[N][N];
		reset_map(tmp, map);
		
		move_up(tmp);
		move_2048(cnt + 1, tmp);
		reset_map(tmp, map);
		
		move_down(tmp);
		move_2048(cnt + 1, tmp);
		reset_map(tmp, map);
		
		move_left(tmp);
		move_2048(cnt + 1, tmp);
		reset_map(tmp, map);
		
		move_right(tmp);
		move_2048(cnt + 1, tmp);
		reset_map(tmp, map);
	}
	
	
	private static void move_right(int[][] map) {

		int N = map.length;
		
		for (int i = 0; i < N; i++) {
			int o = N - 1;
			for (int j = N - 2; j >= 0; j--) {
				if(map[i][j] == 0) continue;
				if(map[i][o] == 0) {
					map[i][o] = map[i][j];
					map[i][j] = 0;
				} else if(map[i][o] == map[i][j]) {
					map[i][o] += map[i][o];
					map[i][j] = 0;
					o--;
				} else {
					o--;
					map[i][o] = map[i][j];
					if(o != j) map[i][j] = 0;
				}
			}
		}
	}


	private static void move_left(int[][] map) {

		int N = map.length;
		
		for (int i = 0; i < N; i++) {
			int o = 0;
			for (int j = 1; j < N; j++) {
				if(map[i][j] == 0) continue;
				if(map[i][o] == 0) {
					map[i][o] = map[i][j];
					map[i][j] = 0;
				} else if(map[i][o] == map[i][j]) {
					map[i][o] += map[i][o];
					map[i][j] = 0;
					o++;
				} else {
					o++;
					map[i][o] = map[i][j];
					if(o != j) map[i][j] = 0;
				}
			}
		}
	}


	private static void move_down(int[][] map) {
		int N = map.length;
		
		for (int j = 0; j < N; j++) {
			int o = N - 1;
			for (int i = N - 2; i >= 0; i--) {
				if(map[i][j] == 0) continue;
				if(map[o][j] == 0) {
					map[o][j] = map[i][j];
					map[i][j] = 0;
				} else if(map[o][j] == map[i][j]) {
					map[o][j] += map[o][j];
					map[i][j] = 0;
					o--;
				} else {
					o--;
					map[o][j] = map[i][j];
					if(o != i) map[i][j] = 0;
				}
			}
		}		
	}


	private static void move_up(int[][] map) {
		
		int N = map.length;
		
		for (int j = 0; j < N; j++) {
			int o = 0;
			for (int i = 1; i < N; i++) {
				if(map[i][j] == 0) continue;
				if(map[o][j] == 0) {
					map[o][j] = map[i][j];
					map[i][j] = 0;
				} else if(map[o][j] == map[i][j]) {
					map[o][j] += map[o][j];
					map[i][j] = 0;
					o++;
				} else {
					o++;
					map[o][j] = map[i][j];
					if(o != i) map[i][j] = 0;
				}
			}
		}
	}


	private static void reset_map(int[][] tmp, int[][] map) {

		int N = map.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = map[i][j];
			}
		}
	}

}
