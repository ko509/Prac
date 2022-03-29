import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 236ms
// 메모리 : 26456KB
public class Main {

	static int min;
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
		min = Integer.MAX_VALUE;
		comb(0,1, map, new boolean[N]);
		System.out.println(min);
	}

	private static void comb(int cnt, int start, int[][] map, boolean[] num) {

		int N = num.length;
		int M = N/2;
		if(cnt==M) {
			int[] link = new int[M];
			int[] st = new int[M];
			int sti = 0;
			int li = 0;
			for (int i = 0; i < N; i++) {
				if(num[i]) {
					st[sti++] = i;
				}else {
					link[li++] = i;
				}
			}
			min = Math.min(Math.abs(power(st, map)-power(link, map)), min);
			return;
		}
		for (int i = start; i < N; i++) {
			num[i] = true;
			comb(cnt+1, i+1, map, num);
			num[i] = false;
		}
	}

	private static int power(int[] link, int[][] map) {

		int len = link.length;
		int total = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if(i==j) continue;
				total += map[link[i]][link[j]];
			}
		}
		return total;
	}

}
