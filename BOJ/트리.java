import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 76ms
// 메모리 : 11704KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] child = new ArrayList[N];
		int[] parent = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			child[i] = new ArrayList<>();
		}
		
		int[] c = new int[N];
		
		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());
			if(p == -1) continue;
			child[p].add(i);
			c[p]++;
			parent[i] = p;
		}
		
		int D = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<>();
		que.offer(D);
		
		boolean[] v = new boolean[N];
		v[D] = true;
		while(!que.isEmpty()) {
			int cur = que.poll();
			for (int b : child[cur]) {
				if(v[b]) continue;
				que.offer(b);
				
				v[b] = true;
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(child[i].size() == 0 && !v[i]) cnt++;
		}
        if(child[parent[D]].size() == 1 && !v[parent[D]]) cnt++;
		System.out.println(cnt);
	}

}
