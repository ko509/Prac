import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 76ms
// 메모리 : 11624KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] friend = new boolean[N][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			
			friend[A][B] = friend[B][A] = true;
		}
		int min = Integer.MAX_VALUE;
		int minp = -1;
		for (int i = 0; i < N; i++) {
			int tmp = kevinBacon(friend, i);
			if(tmp < min) {
				min = tmp;
				minp = i;
			}
		}
		System.out.println(minp+1);
	}

	private static int kevinBacon(boolean[][] friend, int p) {

		int N = friend.length;
		boolean[] v = new boolean[N];
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {p,0});
		v[p] = true;
		
		int time = 0;
		while(!que.isEmpty()) {
			if(check(v)) return time;
			int[] cur = que.poll();
			for (int i = 0; i < N; i++) {
				if(friend[cur[0]][i] && !v[i]) {
					time += cur[1];
					v[i] = true;
					que.offer(new int[] {i, cur[1]+1});
				}
			}
		}
		return time;
	}

	private static boolean check(boolean[] v) {
		for (boolean i : v) {
			if(!i) return false;
		}
		return true;
	}

}
