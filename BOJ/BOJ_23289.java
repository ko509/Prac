import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 312ms
// 메모리 : 50396KB
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int[][] room = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int W = Integer.parseInt(br.readLine());
		int[][][] walls = new int[R][C][4];
		//[r][c][북, 서 , 남 , 동]
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			if(d==0) {
				walls[r][c][0] = 1;
				if(r-1>=0) walls[r-1][c][2] = 1;
			}else {
				walls[r][c][3] = 1;
				if(c+1<C) walls[r][c+1][1] = 1;
			}
		}
		
		
		
		int choco = 0;
		while(true) {
			higher(map, room, walls);
			control(map, walls);
			lower(map);
			++choco;
			if(findK(map, room, K) || choco>100) break;
		}
		System.out.println(choco);
	}

	private static void lower(int[][] map) {

		int R = map.length;
		int C = map[0].length;
		
		for (int i = 1; i < R-1; i++) {
			if(map[i][C-1]>0) map[i][C-1]--;
			if(map[i][0]>0) map[i][0]--;
		}
		for (int i = 1; i < C-1; i++) {
			if(map[R-1][i]>0) map[R-1][i]--;
			if(map[0][i]>0) map[0][i]--;
		}
		if(map[0][0]>0)map[0][0]--;
		if(map[R-1][C-1] >0)map[R-1][C-1]--;
		if(map[0][C-1]>0) map[0][C-1]--;
		if(map[R-1][0]>0) map[R-1][0]--;
	}

	private static void control(int[][] map, int[][][] walls) {

		int R = map.length;
		int C = map[0].length;
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		
		int[][] temp = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]==0) continue;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(nr>=R || nc>=C || nr<0 || nc<0 || walls[i][j][d]==1) continue;
					int diff = map[i][j]-map[nr][nc];
					if(diff>0) {
						temp[i][j] -= diff/4;
						temp[nr][nc] += diff/4;
					}
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += temp[i][j];
			}
		}
	}

	private static void higher(int[][] map, int[][] room, int[][][] walls) {

		int R = map.length;
		int C = map[0].length;
		int[][] dr = {{-1,0,1}, {-1,0,1}, {-1,-1,-1}, {1,1,1}};
		int[][] dc = {{1,1,1}, {-1,-1,-1}, {-1,0,1}, {-1,0,1}};
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(room[i][j]>0 && room[i][j]<5) {
					int d = room[i][j];
					Queue<int[]> que = new LinkedList<int[]>();
					que.offer(new int[] {i+dr[d-1][1], j+dc[d-1][1], 5});
					map[i+dr[d-1][1]][j+dc[d-1][1]] += 5;
					boolean[][] v = new boolean[R][C];
					v[i+dr[d-1][1]][j+dc[d-1][1]] = true;
					while(!que.isEmpty()) {
						int[] cur = que.poll();
						if(cur[2]==1) break;
						for (int dir = 0; dir < 3; dir++) {
							int nr = cur[0] + dr[d-1][dir];
							int nc = cur[1] + dc[d-1][dir];
							if(nr>=R || nc>=C || nr<0 || nc<0 || v[nr][nc] || checkwalls(walls, cur[0], cur[1], nr, nc, d-1)) continue;
							v[nr][nc] = true;
							map[nr][nc] += cur[2] - 1;
							que.offer(new int[] {nr, nc, cur[2]-1});
						}
					}
					
				}
			}
		}
	}


	private static boolean checkwalls(int[][][] walls, int r, int c, int nr, int nc, int d) {

		// 북, 서, 남, 동
		// d가 0이면 오른쪽으로 퍼지는 중
		// d가 1이면 왼쪽으로 퍼지는 중
		// d가 2이면 위쪽으로 퍼지는 중
		// d가 3이면 아래쪽으로 퍼지는 중
		
		if(d==0) {
			if(nr-r==-1) {
				if(walls[r][c][0]==1 || walls[r-1][c+1][1]==1) return true;
			}else if(nr-r==0) {
				if(walls[r][c][3]==1) return true;
			}else {
				if(walls[r][c][2]==1 || walls[r+1][c+1][1]==1) return true;
			}
		}else if(d==1) {
			if(nr-r==-1) {
				if(walls[r][c][0]==1 || walls[nr][nc][3]==1) return true;
			}else if(nr-r==0) {
				if(walls[r][c][1]==1) return true;
			}else {
				if(walls[r][c][2]==1 || walls[nr][nc][3]==1) return true;
			}
		}else if(d==2) {
			if(nc-c==-1) {
				if(walls[r][c][1]==1 || walls[nr][nc][2]==1) return true;
			}else if(nc-c==0) {
				if(walls[r][c][0]==1) return true;
			}else {
				if(walls[r][c][3]==1 || walls[nr][nc][2]==1) return true;
			}
		}else {
			if(nc-c==-1) {
				if(walls[r][c][1]==1 || walls[nr][nc][0]==1) return true;
			}else if(nc-c==0) {
				if(walls[r][c][2]==1) return true;
			}else {
				if(walls[r][c][3]==1 || walls[nr][nc][0]==1) return true;
			}
		}
		return false;
	}

	private static boolean findK(int[][] map, int[][] room, int K) {
		int R = map.length;
		int C = map[0].length;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(room[i][j]==5 && map[i][j]<K) return false;
			}
		}
		return true;
	}

}
