import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 84ms
// 메모리 : 11544KB

public class Main {

	static StringBuilder sb;
	static int N;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		comb(0, 0, new int[M]);
		System.out.println(sb.toString());
	}

	private static void comb(int cnt, int start, int[] num) {

		int M = num.length;
		if(cnt==M) {
			for (int i = 0; i < M; i++) {
				sb.append(num[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			num[cnt] = i+1;
			comb(cnt+1, i+1, num);
		}
	}

}
