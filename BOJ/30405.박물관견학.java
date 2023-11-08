import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 1032ms
// 메모리 199852KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] cnt = new int[M + 1];
		int min = M;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			for (int j = 2; j < k; j++) {
				st.nextToken();
			}
			int end = Integer.parseInt(st.nextToken());
			cnt[start]++;
			cnt[end]++;
			if(min > start) min = start;
			if(min > end) min = end;
		}
		
		long[] before = new long[M + 1];
		long[] after = new long[M + 1];
		
		before[min] = 0;
		
		for (int i = min + 1; i <= M; i++) {
			after[min] += Math.abs(i - min) * cnt[i];
		}
		
		int prev = min;
		long val = before[min] + after[min];
		int answer = min;
		
		int b = 0;
		int cur = cnt[min];
		int a = 2 * N - cur;
		
		for (int i = min + 1; i <= M; i++) {
			if(cnt[i] == 0) continue;
			
			b += cnt[prev];
			cur = cnt[i];
			a -= cur;
			
			before[i] = before[prev] + (i - prev) * b;
			after[i] = after[prev] - (i - prev) * (a + cur);
			
			prev = i;
			
			if(before[i] + after[i] < val) {
				val = before[i] + after[i];
				answer = i;
			} else break;
		}
		
		System.out.println(answer);
	}

}
