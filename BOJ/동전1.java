import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 96ms
// 메모리 : 15740KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N + 1];
        int[][] res = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
            if(coin[i] <= K) res[i][coin[i]] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if(j >= coin[i]) {
					if(res[i][j - coin[i]] > 0) {						
						res[i][j] += res[i][j - coin[i]];
					}
				}
				res[i][j] += res[i - 1][j];
			}
		}
		
		System.out.println(res[N][K]);
	}

}
