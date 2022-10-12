import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

// 시간 : 444ms
// 메모리 : 71508KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j*2) - '0';
			}
		}
		int[] marble = new int[4];
		while(--M >= 0) {
			int[] shark = new int[2];
			st = new StringTokenizer(br.readLine());
			shark[0] = Integer.parseInt(st.nextToken())-1;
			shark[1] = Integer.parseInt(st.nextToken());
			
            break_marble(map, shark);
			move_marble(map);
			while(bomb_marble(map, marble)) {
				move_marble(map);
			}
			change_map(map);
		}
		int total = 0;
		for (int i = 1; i < 4; i++) {
			total += i * marble[i];
		}
		System.out.println(total);
	}

	private static void change_map(int[][] map) {

		int N = map.length;
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		
		int next_step = 1;
		int step_cnt = 2;
		int step = 0;
		int dir = 2;
		int r = N/2;
		int c = N/2;
		int standard = 0;
		Queue<int[]> que = new LinkedList<>();
		Queue<Integer> pack = new LinkedList<>();
		while(true) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr < 0 || nc < 0) break;
			if(map[nr][nc] != 0) {
				if(map[nr][nc] != standard) {
					if(que.size() != 0) {						
						pack.offer(que.size());
						pack.offer(standard);
					}
					while(!que.isEmpty()) {
						que.poll();
					}
					standard = map[nr][nc];
				}
				que.offer(new int[] {nr, nc});
			} else {
				if(que.size() != 0) {						
					pack.offer(que.size());
					pack.offer(standard);
				}
				break;
			}
			step++;
			if(step == next_step) {
				step = 0;
				step_cnt--;
				dir--;
				if(dir == -1) {
					dir = 3;
				}
				if(step_cnt == 0) {
					next_step += 1;
					step_cnt = 2;
				}
			}
			r = nr;
			c = nc;
		}
		
		next_step = 1;
		step_cnt = 2;
		step = 0;
		dir = 2;
		r = N/2;
		c = N/2;
		while(true) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr < 0 || nc < 0) break;
			if(!pack.isEmpty()) {
				map[nr][nc] = pack.poll();
			} else map[nr][nc] = 0;
			step++;
			if(step == next_step) {
				step = 0;
				step_cnt--;
				dir--;
				if(dir == -1) {
					dir = 3;
				}
				if(step_cnt == 0) {
					next_step += 1;
					step_cnt = 2;
				}
			}
			r = nr;
			c = nc;
		}
	}

	private static boolean bomb_marble(int[][] map, int[] marble) {

		int N = map.length;
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		
		int next_step = 1;
		int step_cnt = 2;
		int step = 0;
		int dir = 2;
		int r = N/2;
		int c = N/2;
		int standard = 0;
		Queue<int[]> que = new LinkedList<>();
		Queue<int[]> zero = new LinkedList<>();
		while(true) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr < 0 || nc < 0) break;
			if(map[nr][nc] != 0) {
				if(map[nr][nc] != standard) {
					if(que.size() >= 4) {
						while(!que.isEmpty()) {
							zero.offer(que.poll());
						}
					} else {
						while(!que.isEmpty()) {
							que.poll();
						}
					}
					standard = map[nr][nc];
				}
				que.offer(new int[] {nr, nc});
			} else {
				if(que.size() >= 4) {
					while(!que.isEmpty()) {
						zero.offer(que.poll());
					}
				}
				break;
			}
//			map[nr][nc] = ++standard;
			step++;
			if(step == next_step) {
				step = 0;
				step_cnt--;
				dir--;
				if(dir == -1) {
					dir = 3;
				}
				if(step_cnt == 0) {
					next_step += 1;
					step_cnt = 2;
				}
			}
			r = nr;
			c = nc;
		}
		
		if(zero.isEmpty()) return false;
		else {
			while(!zero.isEmpty()) {
				int[] cur = zero.poll();
				marble[map[cur[0]][cur[1]]]++;
				map[cur[0]][cur[1]] = 0;
			}
			return true;
		}
	}

	private static void move_marble(int[][] map) {

		int N = map.length;
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		
		// 구슬을 한 데 그러모으기
		int next_step = N - 1;
		int step_cnt = 3;
		int step = 0;
		int dir = 0;
		int r = 0;
		int c = 0;
		
		Deque<Integer> que = new LinkedList<>();
		que.offer(map[r][c]);
		while(!(r == N/2 && c == N/2)) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(map[nr][nc] != 0) que.offerLast(map[nr][nc]);
			step++;
			if(step == next_step) {
				step = 0;
				step_cnt--;
				dir++;
				if(dir == 4) {
					dir = 0;
				}
				if(step_cnt == 0) {
					next_step -= 1;
					step_cnt = 2;
				}
			}
			r = nr;
			c = nc;
		}
		
		next_step = 1;
		step_cnt = 2;
		step = 0;
		dir = 2;
		r = N/2;
		c = N/2;
		while(true) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr < 0 || nc < 0) break;
            if(!que.isEmpty())map[nr][nc] = que.removeLast();
			else map[nr][nc] = 0;
			step++;
			if(step == next_step) {
				step = 0;
				step_cnt--;
				dir--;
				if(dir == -1) {
					dir = 3;
				}
				if(step_cnt == 0) {
					next_step += 1;
					step_cnt = 2;
				}
			}
			r = nr;
			c = nc;
		}
		
	}

	private static void break_marble(int[][] map, int[] shark) {

		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		int N = map.length;
		int r = N / 2;
		int c = N / 2;
		for (int i = 1; i <= shark[1]; i++) {
			int nr = r + dr[shark[0]]*i;
			int nc = c + dc[shark[0]]*i;
			map[nr][nc] = 0;
		}
	}

}
