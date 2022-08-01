import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 88ms
// 메모리 : 11632KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] rings = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			rings[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N; i++) {
			sb.append(cal(rings[i], rings[0])).append("\n");
		}
		System.out.println(sb);
	}

	private static String cal(int A, int B) {
		
		int gcb = gcb(A, B);
		StringBuilder sb = new StringBuilder();
		sb.append(B/gcb).append("/").append(A/gcb);
		return sb.toString();
	}

	private static int gcb(int a, int b) {
		if(a%b==0) return b;
		return gcb(b, a%b);
	}

}
