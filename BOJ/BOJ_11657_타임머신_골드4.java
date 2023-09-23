import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 시간 : 288ms
// 메모리 : 25484KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<int[]>[] bus = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			bus[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			bus[start].add(new int[] {end, cost});
		}
		
		long[] dist = new long[N];
		if(bellman(bus, dist)) {
			System.out.println(-1);
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < N; i++) {
				if(dist[i] != 1000000000) sb.append(dist[i]);
				else sb.append(-1);
				sb.append("\n");
			}
			System.out.print(sb);
		}
		
	}

	private static boolean bellman(List<int[]>[] bus, long[] dist) {

		int N = bus.length;
		Arrays.fill(dist, 1000000000);
		dist[0] = 0;
		if(bus[0].size() == 0) return false;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
                if(dist[j] == 1000000000) continue;
				for (int[] d : bus[j]) {
					if(dist[d[0]] > dist[j] + d[1]) {
						dist[d[0]] = dist[j] + d[1];
					}
				}
			}
		}
		
		for (int j = 0; j < N; j++) {
			for (int[] d : bus[j]) {
				if(dist[d[0]] > dist[j] + d[1]) {
					return true;
				}
			}
		}
		
		return false;
	}


}
