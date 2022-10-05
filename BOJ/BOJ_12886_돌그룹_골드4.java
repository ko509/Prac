import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 184ms
// 메모리 : 39892KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int goal = (A + B + C);
		if(goal % 3 != 0) {
			System.out.println(0);
			return;
		}
		goal /= 3;
		
		int[][] set = {{0,1,2}, {0,2,1}, {1,2,0}};
		boolean[][] v = new boolean[1501][1501];
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {A, B, C});
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(cur[0] == cur[1] && cur[1] == cur[2]) {
				System.out.println(1);
				return;
			}
			for (int i = 0; i < 3; i++) {
				if(cur[set[i][0]] < cur[set[i][1]]) {					
					int x = cur[set[i][0]];
					int y = cur[set[i][1]];
                    int tmp = cur[set[i][2]];
                    if(y - x < 0) continue;
					y -= x;
                    x += x;
					if(v[x][y]) continue;
					v[x][y] = true;
					que.offer(new int[] {x, y, tmp});
				} else if(cur[set[i][0]] > cur[set[i][1]]) {					
					int y = cur[set[i][0]];
					int x = cur[set[i][1]];
                    int tmp = cur[set[i][2]];
                    if(y - x < 0) continue;
					y -= x;
					x += x;
					if(v[x][y]) continue;
					v[x][y] = true;
					que.offer(new int[] {x, y, tmp});
				}
				
			}
		}
		System.out.println(0);
	}

}
