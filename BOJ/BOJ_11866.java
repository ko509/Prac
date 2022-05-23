import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 100ms
// 메모리 : 12296KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] v = new boolean[N];
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int start = 0;
		while(!check(v)) {
			int n = 0;
			while(true) {
				if(!v[start]) {
					n++;
					if(n==M) break;
				}
				start++;
				if(start>=N) start -= N;
			}
			v[start] = true;
			sb.append(start+1).append(", ");
		}
		int len = sb.length();
		sb.replace(len-2, len-1, ">");
		System.out.println(sb);
	}

	private static boolean check(boolean[] v) {
		int N = v.length;
		for (int i = 0; i < N; i++) {
			if(!v[i]) return false;
		}
		return true;
	}

}
