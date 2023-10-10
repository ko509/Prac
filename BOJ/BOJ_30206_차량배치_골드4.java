import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 1160ms
// 메모리 : 111052KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new ArrayList[N];
		int[] cnt = new int[N];
		boolean[] v = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
			cnt[i] = 1;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			
			list[start].add(end);
			list[end].add(start);
		}
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0, 0});
		v[0] = true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			cnt[cur[1]]++;
			
			for (int i : list[cur[0]]) {
				if(v[i]) continue;
				v[i] = true;
				que.offer(new int[] {i, cur[1] + 1});
			}
		}
		
		long total = 1l;
		for (int i = 0; i < N; i++) {
			total *= cnt[i];
			total %= 1000000007;
		}
		if(--total < 0) total += 1000000007;
		System.out.println(total);
	}

}
