import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 652ms
// 메모리 : 92696KB
public class Main {

	static int cnt;
	static int prev;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int V = Integer.parseInt(br.readLine());
		
		List<int[]>[] list = new ArrayList[V];
		
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			list[start] = new ArrayList<>();
			while(true) {
				int n = Integer.parseInt(st.nextToken());
				if(n==-1) break;
				list[start].add(new int[] {n-1, Integer.parseInt(st.nextToken())});
			}
		}
		cnt = 0;
		boolean[] v = new boolean[V];
		dfs(0, 0, v, list);
		cnt = 0;
		v = new boolean[V];
		dfs(0, prev, v, list);
		System.out.println(cnt);
	}

	private static void dfs(int total, int t, boolean[] v, List<int[]>[] list) {

		if(v[t]) return;
		else {
			v[t] = true;
			if(cnt < total) {
				cnt = total;
				prev = t;
			}
			
		}
		for (int[] l : list[t]) {
			dfs(total+l[1], l[0], v, list);
		}
		
	}

}
