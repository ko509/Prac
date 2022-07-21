import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 시간 : 508ms
// 메모리 : 19904KB
public class Main {

	static int maxnode = -1;
	static int d = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<int[]>[] list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken()) - 1;
			int child = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			list[parent].add(new int[] {child, weight});
			list[child].add(new int[] {parent, weight});
		}
		if(N==1) {
            System.out.println(0);
		    return;
        }
        int src = dijkstra(0, list)[1];
		int answer = dijkstra(src, list)[0];
		System.out.println(answer);
	}

	
	private static int[] dijkstra(int src, List<int[]>[] list) {
		
		int N = list.length;
		boolean[] v = new boolean[N];
		v[src] = true;
        int[] dist = new int[N];
		Arrays.fill(dist, 987654321);
		for (int[] l : list[src]) {
			dist[l[0]] = l[1];
		}
		for (int i = 0; i < N - 2; i++) {
			int cur = getSmallestNode(dist, v);
			v[cur] = true;
			for (int[] l : list[cur]) {
				if(dist[l[0]] > dist[cur] + l[1]) {
					dist[l[0]] = dist[cur] + l[1];
				}
			}
		}
		int max = 0;
		int mi = -1;
		for (int i = 0; i < N; i++) {
            if(i==src) continue;
			if(dist[i] != 987654321 && dist[i] > max) {
				max = dist[i];
				mi = i;
			}
		}
		return new int[] {max, mi};
	}


	private static int getSmallestNode(int[] dist, boolean[] v) {

		int N = dist.length;
		int min = Integer.MAX_VALUE;
		int mi = -1;
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			if(dist[i] < min) {
				min = dist[i];
				mi = i;
			}
		}
		return mi;
	}

}
