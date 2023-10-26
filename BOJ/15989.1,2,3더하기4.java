import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 88ms
// 메모리 : 11948KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] num = new int[T + 1];
		int max = 0;
		for (int t = 1; t <= T; t++) {
			num[t] = Integer.parseInt(br.readLine());
			if(max < num[t]) max = num[t];
		}
		
		int[][] kp = new int[4][max + 1];
		
		for (int i = 1; i < 4; i++) {
			kp[i][i] = 1;
			for (int j = 1; j <= max; j++) {
				if(j >= i && kp[i][j - i] > 0) {
					kp[i][j] += kp[i][j - i];
				}
				
				kp[i][j] += kp[i - 1][j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {
			sb.append(kp[3][num[i]]).append("\n");
		}
		System.out.print(sb);
	}

}
