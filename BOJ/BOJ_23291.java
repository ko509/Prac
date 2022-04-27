import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 100ms
// 메모리 : 13460KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());

		int[][] fishbowl = new int[N][N];
		for (int i = 0; i < N; i++) {
			fishbowl[N-1][i] = Integer.parseInt(st.nextToken());
		}
		
		int time = 0;
		while(true) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				if(min>fishbowl[N-1][i]) {
					min = fishbowl[N-1][i];
				}
				if(max<fishbowl[N-1][i]) {
					max = fishbowl[N-1][i];
				}
			}
			if(max-min<=K) break;
			else time++;
			for (int i = 0; i < N; i++) {
				if(fishbowl[N-1][i]==min) fishbowl[N-1][i]++;
			}
			roll(fishbowl);
			movefish(fishbowl);
			rollback(fishbowl);
			movedivide(fishbowl);
			movefish(fishbowl);
			rollback(fishbowl);
		}
		System.out.println(time);
	}
	private static void movedivide(int[][] fishbowl) {

		int N = fishbowl.length;
		int start = 0;
		int h = 1;
		
		for (int t = 1; t <= 2; t++) {
			for (int i = start; i < start + (N-start)/2; i++) {
				for (int j = N-1; j >= N-h; j--) {
					int nr = N - h - h + (N - 1 - j);
					int nc = N - (i - start) - 1;
					fishbowl[nr][nc] = fishbowl[j][i];
					fishbowl[j][i] = 0;
				}
			}
			start = N/2;
			h = 2;
		}
	}
	private static void rollback(int[][] fishbowl) {

		int N = fishbowl.length;
		int order = 0;
		for (int j = 0; j < N; j++) {
			for (int i = N-1; i >= 0; i--) {
				if(fishbowl[i][j]==0) continue;
				if(i==N-1 && order==j) {
					order++;
					continue;
				}
				fishbowl[N-1][order++] = fishbowl[i][j];
				fishbowl[i][j] = 0;
			}
		}
		
	}
	private static void movefish(int[][] fishbowl) {

		int N = fishbowl.length;
		int[][] diff = new int[N][N];
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(fishbowl[i][j]==0) continue;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(nr>=N || nc>=N || nr<0 || nc<0 || fishbowl[nr][nc]==0) continue;
					int minus = fishbowl[i][j] - fishbowl[nr][nc];
					if(minus > 0) {
						diff[nr][nc] += minus/5;
						diff[i][j] -= minus/5;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				fishbowl[i][j] += diff[i][j];
			}
		}
		
	}
	private static void roll(int[][] fishbowl) {

		int N = fishbowl.length;
		
		int start = 0;
		int w = 1;
		int h = 1;
		
		int time = 0;
		while(true) {
			if(start+w+h-1>=N) {
				break;
			}
			for (int i = start; i < start + w; i++) { // 열
				for (int j = N-1; j >= N-h; j--) { // 행
					int nr = N - 1 - w + i - start;
					int nc = start + w + (N-1-j);
					fishbowl[nr][nc] = fishbowl[j][i];
					fishbowl[j][i] = 0;
				}
			}
			start += w;
			if(time%2==1) w++;
			else h++;
			time++;
		}
	}

}
