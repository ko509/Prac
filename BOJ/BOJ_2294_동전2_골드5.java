import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 120ms
// 메모리 : 15980KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N + 1];
		int[][] bp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(br.readLine());
			num[i] = n;
			Arrays.fill(bp[i], 987654321);
		}
		
		
		for (int i = 1; i <= N; i++) {
			bp[i][0] = 0;
			for (int j = 1; j <= K; j++) {
				if(j >= num[i] && bp[i][j - num[i]] + 1 < bp[i][j]) {
					bp[i][j] = bp[i][j - num[i]] + 1;
				} 
				if(bp[i - 1][j] != 0 && bp[i - 1][j] < bp[i][j]) bp[i][j] = bp[i - 1][j];
			}
		}
		
		if(bp[N][K] != 987654321) System.out.println(bp[N][K]);
		else System.out.println(-1);
		
	}

}
