import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

// 시간 : 784ms
// 메모리 : 142800KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new ArrayList[M];
		boolean[] v = new boolean[N];
		for (int i = 0; i < M; i++) {
			list[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				int a = Integer.parseInt(st.nextToken()) - 1;
				list[i].add(a);
				v[a] = true;
			}
		}
		
		int[] covid = new int[N];
		int[] origin = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			covid[i] = Integer.parseInt(st.nextToken());
			origin[i] = covid[i];
		}
		
		int[] order = new int[N];
		Arrays.fill(order, -1);
		for (int i = M - 1; i >= 0; i--) {
			boolean flag = true;
			for (int j : list[i]) {
				if(origin[j] == 0) {
					for (int k : list[i]) {
						origin[k] = 0;
					}
					flag = false;
					break;
				}
			}
			if(flag) {
				for (int j : list[i]) {
					order[j] = i;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("YES\n");
		for (int i = 0; i < N; i++) {
			if(covid[i] == 1 && order[i] == -1 && v[i]) {
				System.out.println("NO");
				return;
			}
			sb.append(origin[i]).append(" ");
		}
		System.out.println(sb);
		
	}

}
