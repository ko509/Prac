import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 76ms
// 메모리 : 11352KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] fivo = new int[41][2];
		fivo[0][0] = 1;
		fivo[0][1] = 0;
		fivo[1][0] = 0;
		fivo[1][1] = 1;
		
		for (int i = 2; i < 41; i++) {
			fivo[i][0] = fivo[i-1][0] + fivo[i-2][0];
			fivo[i][1] = fivo[i-1][1] + fivo[i-2][1];
		}
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(fivo[N][0]).append(" ").append(fivo[N][1]).append("\n");
		}
		System.out.println(sb);
	}
	

}
