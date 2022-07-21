import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 224ms
// 메모리 : 23956KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if(j-1 < 0) map[i][j] += map[i-1][j];
				else {
					if(map[i-1][j] > map[i-1][j-1]) {
						map[i][j] += map[i-1][j];
					} else {
						map[i][j] += map[i-1][j-1];
					}
				}
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			if(max < map[N-1][i]) max = map[N-1][i];
		}
		System.out.println(max);
	}

}
