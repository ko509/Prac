import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 104ms
// 메모리 : 14680KB
public class Main {

	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		
		perm(0, 1, new int[M]);
		System.out.println(sb);
	}
	private static void perm(int cnt, int start, int[] num) {
		
		int M = num.length;
		if(cnt==M) {
			for (int i : num) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <= N; i++) {
			num[cnt] = i;
			perm(cnt+1, i, num);
		}
	}

}
