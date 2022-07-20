import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 352ms
// 메모리 : 46260KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] bus = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(bus[i], 100000001);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			if(bus[start][end] > weight) bus[start][end] = weight;
		}
		
		st = new StringTokenizer(br.readLine());
		int src = Integer.parseInt(st.nextToken()) - 1;
		int dest = Integer.parseInt(st.nextToken()) - 1;
		
		int[] dist = new int[N];
		boolean[] v = new boolean[N];
		v[src] = true;
		dijkstra(src, dist, bus, v);
		
		System.out.println(dist[dest]);
		
	}

	private static void dijkstra(int src, int[] dist, int[][] bus, boolean[] v) {
		int N = bus.length;
		for (int i = 0; i < N; i++) {
			dist[i] = bus[src][i];
		}
		for (int i = 0; i < N - 2; i++) {
			int cur = getSmallestIndex(dist, v);
			v[cur] = true;
			for (int j = 0; j < N; j++) {
				if(v[j]) continue;
				if(bus[cur][j]==100000001) continue;
				if(dist[cur] + bus[cur][j] < dist[j]) {
					dist[j] = dist[cur] + bus[cur][j];
				}
			}
		}
		
	}

	private static int getSmallestIndex(int[] dist, boolean[] v) {

		int N = dist.length;
		int min = Integer.MAX_VALUE;
		int idx = -1;
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			if(dist[i] < min) {
				min = dist[i];
				idx = i;
			}
		}
		return idx;
	}

}
