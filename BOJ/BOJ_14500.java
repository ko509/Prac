import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 612ms
// 메모리 : 32836KB
public class BOJ_14500_테트로미노_골드5 {

	static int answer;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dr = {{0,0,0}, {0,1,1}, {1,2,2}, {1,1,2}, {0,0,1}};
		int[][] dc = {{1,2,3}, {1,0,1}, {0,0,1}, {0,1,1}, {1,2,1}};
		
		int[] tr = {1,1,-1,-1};
		int[] tc = {1,-1,1,-1};
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 4; k++) {
					for (int t = 0; t < 5; t++) {
						int tmp = map[i][j];
						for (int d = 0; d < 3; d++) {
							int nr = i + dr[t][d]*tr[k];
							int nc = j + dc[t][d]*tc[k];
							if(nr >= N || nc >= M || nr < 0 || nc < 0) break;
							tmp += map[nr][nc];
						}
						if(tmp > answer) answer = tmp;
						tmp = map[i][j];
						for (int d = 0; d < 3; d++) {
							int nr = i + dc[t][d]*tr[k];
							int nc = j + dr[t][d]*tc[k];
							if(nr >= N || nc >= M || nr < 0 || nc < 0) break;
							tmp += map[nr][nc];
						}
						if(tmp > answer) answer = tmp;
					}
				}
			}
		}
		System.out.println(answer);
	}



}
