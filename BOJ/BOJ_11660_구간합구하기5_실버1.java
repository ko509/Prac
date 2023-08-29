import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] += map[i][j - 1];
			}
		}
		
		for (int j = 0; j <= N; j++) {
			for (int i = 1; i <= N; i++) {
				map[i][j] += map[i - 1][j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			int n = map[r2][c2] - map[r1 - 1][c2] - map[r2][c1 - 1] + map[r1 - 1][c1 - 1];
			sb.append(n).append("\n");
		}
		
		System.out.print(sb);
	}

}
