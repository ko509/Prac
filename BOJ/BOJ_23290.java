import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


	// 시간 : 540ms
  // 메모리 : 61012KB
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dr = {0,-1,-1,-1,0,1,1,1};
		int[] dc = {-1,-1,0,1,1,1,0,-1};
		
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		List<Integer>[][] map = new ArrayList[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			map[r][c].add(d);
		}
		st = new StringTokenizer(br.readLine());
		int sr = Integer.parseInt(st.nextToken())-1;
		int sc = Integer.parseInt(st.nextToken())-1;
		int[][] smell = new int[4][4];
		for (int t = 0; t < S; t++) {
			// 2. 물고기 이동
			List<Integer>[][] fish = new ArrayList[4][4];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					fish[i][j] = new ArrayList<>();
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					int len = map[i][j].size();
					for (int d = len-1; d >= 0; d--) {
						int f = map[i][j].get(d);
						int count = 0;
						while(true) {
							int nr = i + dr[f];
							int nc = j + dc[f];
							if(nr>=4 || nc >= 4 || nr<0 || nc<0 || (nr==sr && nc==sc) || smell[nr][nc]!=0) {
								f-=1;
								if(f==-1) f = 7;
							}
							else {
								fish[nr][nc].add(f);
								break;
							}
							if(count++==8) {
								fish[i][j].add(map[i][j].get(d));
								break;
							}
						}
						
					}
				}
			}
			// 3. 상어 이동
			int[] shark = moveshark(sr, sc, fish, smell);
			sr = shark[0];
			sc = shark[1];
			// 4. 냄새 빠짐
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if(smell[i][j]!=0) {
						smell[i][j]--;
					}
				}
			}
			
			// 5. 복제 마법 끝
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					for (int tm : fish[i][j]) {
						map[i][j].add(tm);
					}
				}
			}
		}
		
		// 남은 물고기 수
		int answer = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				answer += map[i][j].size();
			}
		}
		System.out.println(answer);
	}
	
	private static int[] moveshark(int sr, int sc, List<Integer>[][] map, int[][] smell) {
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		int max = -1;
		int[] total = new int[3];
		int[] path = new int[3];
		
		for (int i = 0; i < 4; i++) {
			int nr = sr +dr[i];
			int nc = sc +dc[i];
			if(nr>= 4 || nc >= 4 || nr<0 || nc <0 ) continue;
			total[0] = map[nr][nc].size();
			for (int j = 0; j < 4; j++) {
				int jr = nr + dr[j];
				int jc = nc + dc[j];
				if(jr>= 4 || jc >= 4 || jr<0 || jc <0) continue;
				total[1] = map[jr][jc].size();
				for (int j2 = 0; j2 < 4; j2++) {
					int j2r = jr + dr[j2];
					int j2c = jc + dc[j2];
					if(j2r>= 4 || j2c >= 4 || j2r<0 || j2c <0) continue;
					if(j2r==nr && j2c==nc) total[2] = 0;
					else total[2] = map[j2r][j2c].size();
					int tmp = 0;
					for (int ks : total) {
						tmp += ks;
					}
					if(tmp>max) {
						max = tmp;
						path[0] = i;
						path[1] = j;
						path[2] = j2;
					}else if(max==tmp) {
						if(path[0]>i) {
							path[0] = i;
							path[1] = j;
							path[2] = j2;
						}else if(path[0]==i) {
							if(path[1]>j) {
								path[0] = i;
								path[1] = j;
								path[2] = j2;
							}else if(path[1]==j) {
								if(path[2]>j2) {
									path[0] = i;
									path[1] = j;
									path[2] = j2;
								}
							}
						}
					}
				}
				
			}
		}
		for (int is : path) {
			sr += dr[is];
			sc += dc[is];
			if(map[sr][sc].size()!=0) {
				map[sr][sc].clear();
				smell[sr][sc] = 3;
			}
		}
		return new int[] {sr, sc};
	}

}
