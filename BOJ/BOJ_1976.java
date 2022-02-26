import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 124ms
// 메모리 : 15596KB
public class BOJ_1976 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] cities = new int[N];
		int[] rank = new int[N];
		
		for (int i = 0; i < N; i++) {
			cities[i] = i;
			rank[i] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if(st.nextToken().charAt(0)=='1') {
					union(i,j, cities, rank);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int[] wanttogo = new int[M];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			wanttogo[i] = Integer.parseInt(st.nextToken())-1;
			if(i!=0) {
				if(!union(wanttogo[i-1], wanttogo[i], cities, rank)) {
					sb.append("NO");
					break;
				}
			}
		}
		if(sb.length()==0) sb.append("YES");
		System.out.println(sb.toString());
		
	}

	private static boolean union(int x, int y, int[] cities, int[] rank) {

		int px = find(x, cities);
		int py = find(y, cities);
		
		if(px==py) return true;
		
		if(rank[px]>=rank[py]) {
			rank[px]++;
			cities[py] = px;
		}else {
			rank[py]++;
			cities[px] = py;
		}
		return false;
	}

	private static int find(int x, int[] cities) {
		if(cities[x]==x) return x;
		else return cities[x] = find(cities[x], cities);
	}

}
