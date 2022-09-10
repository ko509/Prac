import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 100ms
// 메모리 : 12380KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] height = new int[W];
		int[][] map = new int[H][W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < height[i]; j++) {
				map[H - j - 1][i] = 1;
			}
		}

		int answer = 0;
		for (int i = 0; i < H; i++) {
			boolean flag = false;
			int tmp = 0;
			for (int j = 1; j < W; j++) {
				if(map[i][j - 1] == 1 && map[i][j] == 0) {
					flag = true;
				} else if(map[i][j - 1] == 0 && map[i][j] == 1) {
					answer += tmp;
					tmp = 0;
					flag = false;
					continue;
				}
				if(flag) {
					tmp++;
				}
			}
		}
		System.out.println(answer);
	}
}
