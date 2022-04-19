import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 80ms
// 메모리 : 11796KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)=='W'? true : false;
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int count = 0;
				boolean flag = map[i][j];
				for (int r = 0; r < 8; r++) {
					if(r%2==1) flag = !map[i][j];
					else flag = map[i][j];
					for (int c = 0; c < 8; c++) {
						if(map[i+r][j+c]==flag) {
							count++;
						}
						flag = !flag;
					}
				}
				if(min>count) min = count;
				if(min>64-count) min = 64-count;
			}
		}
		System.out.println(min);
	}

}
