import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 시간 : 764ms
// 메모리 : 64248KB
public class Main {

    static int[] parent;
    static int[] rank;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			Map<String, Integer> name = new HashMap<>();
			int name_cnt = 0;
			
			parent = new int[200000];
			rank = new int[200000];
			for (int i = 0; i < 200000; i++) {
				parent[i] = i;
				rank[i] = 1;
			}
			
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String first = st.nextToken();
				String sec = st.nextToken();
				int first_idx = -1;
				int sec_idx = -1;
				if(name.containsKey(first)) {
					first_idx = name.get(first);
				} else {
					name.put(first, name_cnt);
					first_idx = name_cnt++;
				}
				if(name.containsKey(sec)) {
					sec_idx = name.get(sec);
				} else {
					name.put(sec, name_cnt);
					sec_idx = name_cnt++;
				}
				
				
				sb.append(union(first_idx, sec_idx)).append("\n");
			}
			
		}
		System.out.println(sb);
	}

	private static int union(int first_idx, int sec_idx) {

		int pf = find(first_idx);
		int sf = find(sec_idx);
		if(pf == sf) return rank[pf];
		if(rank[pf] >= rank[sf]) {
			rank[pf] += rank[sf];
			parent[sf] = pf;
			return rank[pf];
		} else {
			rank[sf] += rank[pf];
			parent[pf] = sf;
			return rank[sf];
		}
	}

	private static int find(int idx) {

		if(idx == parent[idx]) return idx;
		return parent[idx] = find(parent[idx]);
	}

}
