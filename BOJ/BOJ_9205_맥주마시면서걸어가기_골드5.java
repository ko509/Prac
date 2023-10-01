import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 100ms
// 메모리 : 12488KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
            boolean[] v = new boolean[N];
			Queue<int[]> que = new LinkedList<>();
			que.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			int[][] map = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			
			boolean flag = false;
			while(!que.isEmpty()) {
				int[] cur = que.poll();
				if(Math.abs(cur[0] - er) + Math.abs(cur[1] - ec) <= 1000) {
					flag = true;
					break;
				}
				for (int i = 0; i < N; i++) {
					if(v[i]) continue;
					int dist = Math.abs(cur[0] - map[i][0]) + Math.abs(cur[1] - map[i][1]);
					if(dist <= 1000) {
						que.offer(new int[] {map[i][0], map[i][1]});
						v[i] = true;
					}
				}
			}
			if(!flag) sb.append("sad\n");
			else sb.append("happy\n");
		}
		System.out.println(sb);
	}


}
