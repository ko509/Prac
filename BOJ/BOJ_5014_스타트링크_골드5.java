import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 172ms
// 메모리 : 54964KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		boolean[] v = new boolean[F+1];
		v[S] = true;
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {S, 0});
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(cur[0] == G) {
				System.out.println(cur[1]);
				return;
			}
			else if(U != 0 && G > cur[0] && (G - cur[0]) % U == 0) {
				System.out.println(cur[1] + (G - cur[0]) / U);
				return;
			}
			else if(D != 0 && G < cur[0] && (cur[0] - G) % D == 0) {
				System.out.println(cur[1] + (cur[0] - G) / D);
				return;
			}
			if(cur[0]+U <= F && !v[cur[0] + U]) {
				que.offer(new int[] {cur[0] + U, cur[1]+1});
				v[cur[0] + U] = true;
			}
			if(cur[0] - D > 0 && !v[cur[0] - D]) {
				que.offer(new int[] {cur[0] - D, cur[1]+1});
				v[cur[0] - D] = true;
			}
		}
		System.out.println("use the stairs");
		
	}
	

}
