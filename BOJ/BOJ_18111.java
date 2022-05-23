import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 560ms
// 메모리 : 34532KB
public class Main {

	static int B;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		long time = Long.MAX_VALUE;
		int height = 0;
		for (int i = 0; i <= 256; i++) {
			long newTime = getTime(map, i);
			if(time>=newTime && newTime!=Long.MAX_VALUE) {
				time = newTime;
				height = i;
			}
		}
		System.out.println(time+" "+height);
	}

	private static long getTime(int[][] map, int mid) {

		int N = map.length;
		int M = map[0].length;
		int total = B;
		long time = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int diff = map[i][j]-mid;
				total += diff;
				if(diff > 0) time += (2l * diff);
				else if(diff < 0) time += (-1l * diff);
			}
		}
		if(total < 0) return Long.MAX_VALUE;
		return time;
	}

}
