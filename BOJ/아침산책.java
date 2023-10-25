import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

// 시간 : 916ms
// 메모리 : 76452KB
public class Main {

	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] inout = new int[N];
		parent = new int[N];
		int[] rank = new int[N];
		String str = br.readLine();
		
		for (int i = 0; i < N; i++) {
			parent[i] = i;
			inout[i] = str.charAt(i) - '0';
		}
		
		long cnt = 0;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			if(inout[u] == 1 && inout[v] == 1) cnt += 2;
			else if(inout[u] == 0 && inout[v] == 0) {
				union(u, v);
			} else if(inout[u] == 0 && inout[v] == 1) {
				rank[u]++;
			} else {
				rank[v]++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			int pi = find(i);
			if(pi != i) {
				rank[pi] += rank[i];
			}
		}
		
		for (int i = 0; i < N; i++) {
			if(parent[i] == i && rank[i] > 1) {
				cnt += (rank[i] * (rank[i] - 1));
			}
		}
		
		System.out.println(cnt);
	}
	private static void union(int u, int v) {

		int pu = find(u);
		int pv = find(v);
		
		if(pu == pv) return;
		if(pu < pv) {
			parent[pv] = pu;
		} else {
			parent[pu] = pv;
		}
	}

	private static int find(int u) {
		if(parent[u] == u) return u;
		else return parent[u] = find(parent[u]);
	}
}
