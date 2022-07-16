import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;

// 시간 : 448ms
// 메모리 : 114048KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, parent);
		}
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			if(find(i, parent)==i) count++;
		}
		System.out.println(count);
				
	}

	private static void union(int a, int b, int[] parent) {

		int pa = find(a, parent);
		int pb = find(b, parent);
		if(pa==pb) return;
		parent[pb] = pa;
	}

	private static int find(int a, int[] parent) {
		if(a==parent[a]) return a;
		return parent[a] = find(parent[a], parent);
	}

}
