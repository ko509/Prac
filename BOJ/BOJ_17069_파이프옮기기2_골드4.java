import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 84ms
// 메모리 : 11864KB
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
		
		long[][][] pipe = new long[N][N][3]; // 0 : 가로, 1 : 세로, 2 : 대각선
		pipe[0][0][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) continue;
				// 현재 위치에 가로가 되려면
				if(j > 0 && j < N - 1 && map[i][j + 1] != 1) {
					pipe[i][j][0] += pipe[i][j - 1][0];
					if(i > 0) {
						pipe[i][j][0] += pipe[i - 1][j - 1][2];
					}
				}
				
				//  현재 위치에 세로
				if(i > 0 && i < N - 1 && map[i + 1][j] != 1) {
					pipe[i][j][1] += pipe[i - 1][j][1];
					if(j > 0) {
						pipe[i][j][1] += pipe[i - 1][j - 1][2];
					}
				}
				
				// 대각선
				if(i < N - 1 && j < N - 1 && map[i][j + 1] != 1 && map[i + 1][j] != 1 && map[i + 1][j + 1] != 1) {
					if(j > 0) {
						pipe[i][j][2] += pipe[i][j - 1][0];
						if(i > 0) {
							pipe[i][j][2] += pipe[i - 1][j - 1][2];
						}
					}
					if(i > 0) {
						pipe[i][j][2] += pipe[i - 1][j][1];
					}
				}
			}
		}
		
		System.out.println(pipe[N - 1][N - 2][0] + pipe[N - 2][N - 2][2] + pipe[N - 2][N - 1][1]);
	}

}
