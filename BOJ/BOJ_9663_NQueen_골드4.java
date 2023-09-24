import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 시간 : 1784ms
// 메모리 : 13088KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		count = 0;
		n_queen(0, new int[N], new int[N][N]);
		System.out.println(count);
	}

	static int count;
	private static void n_queen(int cnt, int[] line, int[][] col) {

		int N = col.length;

		
		if(cnt == N) {
			count++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			
			if(col[cnt][i] > 0) continue;
			
			line[cnt] = i;
			for (int j = cnt; j < N; j++) {
				col[j][i]++;
				if(i + j - cnt < N) col[j][i + (j - cnt)]++;
				if(i - (j - cnt) >= 0) col[j][i - (j - cnt)]++;
			}
			n_queen(cnt + 1, line, col);
			for (int j = cnt; j < N; j++) {
				col[j][i]--;
				if(i + j - cnt < N) col[j][i + (j - cnt)]--;
				if(i - (j - cnt) >= 0) col[j][i - (j - cnt)]--;
			}
		}
		
		return;
	}

}
