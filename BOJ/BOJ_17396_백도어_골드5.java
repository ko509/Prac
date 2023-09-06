import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 시간 : 924ms
// 메모리 : 146220KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] watch = new int[N];
		List<int[]>[] list = new ArrayList[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			watch[i] = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			if(watch[a] == 1 && a != N - 1) continue;
			if(watch[b] == 1 && b != N - 1) continue;
			list[a].add(new int[] {b, t});
			list[b].add(new int[] {a, t});
		}
		
		System.out.println(dijkstra(list, watch));
	}

	static class Node implements Comparable<Node> {

		int next;
		long cost;
		
		public Node(int next, long cost) {
			super();
			this.next = next;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}
		
	}
	private static long dijkstra(List<int[]>[] list, int[] watch) {

		int N = list.length;
		long[] dist = new long[N];
		Arrays.fill(dist, Long.MAX_VALUE);
		PriorityQueue<Node> que = new PriorityQueue<>();
		que.offer(new Node(0, 0));
		dist[0] = 0;
		
		while (!que.isEmpty()) {
			Node cur = que.poll();
			
			if(cur.cost >= dist[N - 1]) continue;
			if(cur.cost > dist[cur.next]) continue;
			
			for (int[] i : list[cur.next]) {
				if(dist[i[0]] > cur.cost + i[1]) {
					dist[i[0]] = cur.cost + i[1];
					que.add(new Node(i[0], dist[i[0]]));
				}
			}
		}
		
		return dist[N - 1] == Long.MAX_VALUE ? -1 : dist[N - 1];
	}


}
