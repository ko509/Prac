import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 80ms
// 메모리 : 11540KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			if(N < 3) {
				sb.append(1).append("\n");
				continue;
			}
			long[] num = new long[N];
			for(int i = 0; i < 3; i++) {
				num[i] = 1l;
			}
			
			for(int i = 3; i < N; i++) {
				num[i] = num[i-3] + num[i-2];
			}
			sb.append(num[N-1]).append("\n");
		}
		System.out.println(sb);
	}

}
