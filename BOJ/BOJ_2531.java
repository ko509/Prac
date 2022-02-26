import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 시간 : 564ms
// 메모리 : 105464KB
public class BOJ_2531 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] sushi = new int[N];
		
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int max = -1;
		
		for (int i = 0; i < N; i++) {
			boolean[] each = new boolean[d+1];
			each[c] = true;
			int count = 1;
			for (int j = i; j < i+k; j++) {
				int tmp = j;
				if(tmp>=N) tmp%=N;
				if(!each[sushi[tmp]]) {
					count++;
					each[sushi[tmp]] = true;
				}
			}
			max = Math.max(max, count);
		}
		System.out.println(max);
	}
}
