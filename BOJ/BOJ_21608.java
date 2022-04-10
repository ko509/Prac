import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 시간 : 164ms
// 메모리 : 13416KB
public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] seat = new int[N][N];
		int len = N*N;
		Map<Integer, int[]> map = new HashMap<>();
		
		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			int kid = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map.put(kid, new int[] {a,b,c,d});
			bfs(kid, new int[] {a,b,c,d}, seat);
		}
		
		gocount(seat, map);

	}

	private static void gocount(int[][] seat, Map<Integer, int[]> map) {
		
		int N = seat.length;
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		int total = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int fcount = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i+dr[d];
					int nc = j+dc[d];
					if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
					for (int f : map.get(seat[i][j])) {
						if(seat[nr][nc]==f) fcount++;
					}
				}
				switch (fcount) {
				case 1:
					total+=1;
					break;
				case 2:
					total+=10;
					break;
				case 3:
					total+=100;
					break;
				case 4:
					total+=1000;
					break;
				default:
					break;
				}
			}
		}
		System.out.println(total);
	}

	private static void bfs(int key, int[] friend, int[][] seat) {

		int N = seat.length;
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		int maxi = -1;
		int maxj = -1;
		int fmax = -1;
		int max = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(seat[i][j]==0) {
					int fcount = 0;
					int count = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
						for (int f : friend) {
							if(seat[nr][nc]==f) fcount++;
						}
						if(seat[nr][nc]==0)count++;
					}
					if(fcount>fmax) {
						fmax = fcount;
						max = count;
						maxi = i;
						maxj = j;
					}else if(fcount==fmax) {
						if(count>max) {
							max = count;
							maxi = i;
							maxj = j;
						}else if(count==max) {
							if(maxi>i) {
								maxi = i;
								maxj = j;
							}else if(maxi==i){
								if(maxj>j) {
									maxj = j;
								}
							}
						}
					}
				}
			}
		}
		seat[maxi][maxj] = key;
	}

}
