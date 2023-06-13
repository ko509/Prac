import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 344ms
// 메모리 : 40952KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dist = new int[N];
		int[] cost = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		long total = 0;
		long now = cost[0];
		long sum = 0;
		
		for (int i = 1; i < N; i++) {
			if(cost[i] < now) {
				sum += dist[i];
				total += now * sum;
				sum = 0;
				now = cost[i];
			} else {
				sum += dist[i];
			}
		}
		total += now * sum;
		System.out.println(total);
	}

}
