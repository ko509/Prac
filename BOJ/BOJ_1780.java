import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 788ms
// 메모리 : 316540KB
public class Main {

	static int[] count;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken())+1;
			}
		}
		
		count = new int[3];
		dfs(0, 0, N, map);
		StringBuilder sb = new StringBuilder();
		for (int bs : count) {
			sb.append(bs).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int r, int c, int n, int[][] map) {

		boolean flag = true;
        int standard = map[r][c];
		outer : for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(standard!=map[i+r][j+c]) {
					flag = false;
                    break outer;
				}
			}
		}
		if(flag) {			
			count[standard]++;
		}else {
            int nn = n/3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					dfs(r+i*nn, c+j*nn, nn, map);
				}
			}
		}
		return;
	}

}
