import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 736ms
// 메모리 : 119516KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][N];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(N >= 2) {				
				sticker[0][1] = sticker[1][0] + sticker[0][1];
				sticker[1][1] = sticker[0][0] + sticker[1][1];
				for (int i = 2; i < N; i++) {
					if(sticker[1][i-1] > sticker[1][i-2]) {
						sticker[0][i] = sticker[1][i-1] + sticker[0][i];
					} else {
						sticker[0][i] = sticker[1][i-2] + sticker[0][i];
					}
					if(sticker[0][i-1] > sticker[0][i-2]) {
						sticker[1][i] = sticker[0][i-1] + sticker[1][i];
					} else {
						sticker[1][i] =sticker[0][i-2] + sticker[1][i];
					}
				}
				
			}
			if(sticker[0][N-1] > sticker[1][N-1]) {
				sb.append(sticker[0][N-1]);
			} else {
				sb.append(sticker[1][N-1]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
