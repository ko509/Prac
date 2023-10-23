import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 시간 : 224ms
// 메모리 : 22180KB
public class Main {

	static boolean flag;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		flag = false;
		for (int i = 0; i < N; i++) {
			if(!flag) {
				boolean[] v = new boolean[N];
				v[i] = true;
				dfs(list, v, i, 1);
			} else {
				System.out.println(1);
                return;
			}
		}
		System.out.println(0);
	}
	private static void dfs(List<Integer>[] list, boolean[] v, int cur, int cnt) {

		if(cnt == 5) {
			flag = true;
			return;
		}
		
		for (Integer b : list[cur]) {
			if(v[b]) continue;
			v[b] = true;
			dfs(list, v, b, cnt + 1);
			v[b] = false;
		}
	}

}
