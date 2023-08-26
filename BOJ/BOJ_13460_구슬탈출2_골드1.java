import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 96ms
// 메모리 : 13040KB
public class Main {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		
		int[] red = new int[2];
		int[] blue = new int[2];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'R') {
					red[0] = i;
					red[1] = j;
					map[i][j] = '.';
				} else if(map[i][j] == 'B') {
					blue[0] = i;
					blue[1] = j;
					map[i][j] = '.';
				}
			}
		}
		
		boolean[][][][] v = new boolean[N][M][N][M];
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {red[0], red[1], blue[0], blue[1], 0});
		v[red[0]][red[1]][blue[0]][blue[1]] = true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			red[0] = cur[0];
			red[1] = cur[1];
			blue[0] = cur[2];
			blue[1] = cur[3];
			
			if(cur[4] > 10) break;
			if(map[red[0]][red[1]] == 'O') {
				if(map[blue[0]][blue[1]] != 'O') {
					System.out.println(cur[4]);
					System.exit(0);
				} else continue;
			}
			
			if(map[blue[0]][blue[1]] == 'O') continue;
			
			for (int d = 0; d < 4; d++) {
				
				if(red[1] == blue[1]) {
					if(d == 0 && red[0] < blue[0]) {
						move_ball(red, blue, d, map);
					} else if(d == 0){
						move_ball(blue, red, d, map);
					} else if(d == 2 && red[0] < blue[0]) {
						move_ball(blue, red, d, map);
					} else if(d == 2) {
						move_ball(red, blue, d, map);
					} else {
						move_ball(red, blue, d, map);
					}
				} else if(red[0] == blue[0]) {
					if(d == 1 && red[1] < blue[1]) {
						move_ball(red, blue, d, map);
					} else if (d == 1) {
						move_ball(blue, red, d, map);
					} else if (d == 3 && red[1] < blue[1]) {
						move_ball(blue, red, d, map);
					} else if (d == 3) {
						move_ball(red, blue, d, map);
					} else {
						move_ball(red, blue, d, map);
					}
				} else {
					move_ball(red, blue, d, map);
				}
				
				if(!v[red[0]][red[1]][blue[0]][blue[1]]) {
					v[red[0]][red[1]][blue[0]][blue[1]] = true;
					que.offer(new int[] {red[0], red[1], blue[0], blue[1], cur[4] + 1});
					
				}
				red[0] = cur[0];
				red[1] = cur[1];
				blue[0] = cur[2];
				blue[1] = cur[3];
			}
			
		}
		
		System.out.println(-1);
	}
	
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	private static void move_ball(int[] first, int[] second, int d, char[][] map) {
		
		int fr = first[0];
		int fc = first[1];
		int sr = second[0];
		int sc = second[1];
		
		boolean f = true;
		boolean s = true;
		
		while(true) {
			int nr1 = fr + dr[d];
			int nc1 = fc + dc[d];
			int nr2 = sr + dr[d];
			int nc2 = sc + dc[d];
						
			if(f) {
				if(map[nr1][nc1] == '.') {
					fr = nr1;
					fc = nc1;
				} else if(map[nr1][nc1] == 'O') {
					fr = nr1;
					fc = nc1;
					f = false;
				} else {
					f = false;
				}
			}
			
			if(s) {				
				if(map[nr2][nc2] == '.') {
					if(fr == nr2 && fc == nc2) {
						first[0] = fr;
						first[1] = fc;
						second[0] = sr;
						second[1] = sc;
						return;
					} else {
						sr = nr2;
						sc = nc2;
					}
				} else if(map[nr2][nc2] == 'O') {
					first[0] = fr;
					first[1] = fc;
					second[0] = nr2;
					second[1] = nc2;
					return;
				} else {
					s = false;
				}
			}
			
			if(!f && !s) {
				first[0] = fr;
				first[1] = fc;
				second[0] = sr;
				second[1] = sc;
				break;
			}
		}
		return;
	}

}
