import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 112ms
// 메모리 : 16644KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] v = new boolean[100001];
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {N, 0});
		v[N] = true;
		
		int answer = 0;
 		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(cur[0]==K) {
				answer = cur[1];
				break;
			}
			if(cur[0]<K) {
				if(cur[0]*2<=100000 && !v[cur[0]*2]) {
					que.offer(new int[] {cur[0]*2, cur[1]+1});
					v[cur[0]*2] = true;
				}
				if(cur[0]+1<=100000 && !v[cur[0]+1]) {
					que.offer(new int[] {cur[0]+1, cur[1]+1});
					v[cur[0]+1] = true;
				}
			}
			if(cur[0]-1>=0 && !v[cur[0]-1]) {
				que.offer(new int[] {cur[0]-1, cur[1]+1});
				v[cur[0]-1] = true;
			}
		}
 		System.out.println(answer);
	}

}
