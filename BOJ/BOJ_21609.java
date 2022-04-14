import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 124ms
// 메모리 : 20804KB
public class Main {

	static int score;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		score = 0;
		while(true) {
			if(!findmax(map)) break;
			todown(map);
			map = turn(map);
			todown(map);
		}
		System.out.println(score);
	}

	private static int[][] turn(int[][] map) {

		int N = map.length;
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[N-j-1][i] = map[i][j];
			}
		}
		return tmp;
	}

	private static void todown(int[][] map) {

		int N = map.length;
	
			for (int i = N-1; i >= 0; i--) {
				for (int j = N-1; j >= 0; j--) {
					if(map[i][j]==-1 || map[i][j]==-2) {
						continue;
					}
					int nr = i + 1;
					int start = i;
					while(true){
						if(nr>=N || nr<0) break;
						if(map[nr][j]==-2) {
							map[nr][j]= map[start][j];
							map[start][j] = -2;
							start = nr;
							nr +=1;
						}else break;
					}
				}
			}
		
	}

	private static boolean findmax(int[][] map) {

		int N = map.length;
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		Queue<int[]> mque = new LinkedList<>();
		boolean[][] bigv = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]>=1 && !bigv[i][j]) {
					Queue<int[]> que = new LinkedList<int[]>();
					Queue<int[]> tmp = new LinkedList<>();
					que.offer(new int[] {i,j, 1});
					tmp.offer(new int[] {i,j});
					int stand = map[i][j];
					boolean[][] v = new boolean[N][N];
					v[i][j] = true;
					bigv[i][j] = true;
					while(!que.isEmpty()) {
						int[] cur = que.poll();
						int r = cur[0], c = cur[1];
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if(nr<0 || nc<0 || nr>=N || nc>=N || v[nr][nc] || bigv[nr][nc]) continue;
							if(map[nr][nc]==stand || map[nr][nc]==0) {
								v[nr][nc] = true;
								que.offer(new int[] {nr, nc});
								tmp.offer(new int[] {nr, nc});
								if(map[nr][nc]!=0) {
									bigv[nr][nc] = true;
								}
							}
							
						}
					
					}
                    int tsize = tmp.size();
                    int msize = mque.size();
					if(tsize>msize) {
						mque.clear();
						while(!tmp.isEmpty()) {
							mque.offer(tmp.poll());
						}
					}else if(tsize==msize) {
						int tmprainbow = 0;
						int tr = tmp.peek()[0];
						int tc = tmp.peek()[1];
						int mr = mque.peek()[0];
						int mc = mque.peek()[1];
						for (int[] bs : tmp) {
							if(map[bs[0]][bs[1]]==0) tmprainbow++;
						}
						for (int[] bs : mque) {
							if(map[bs[0]][bs[1]]==0) tmprainbow--;
						}
						if(tmprainbow>0) {
							mque.clear();
							while(!tmp.isEmpty()) {
								mque.offer(tmp.poll());
							}
						}else if(tmprainbow==0) {
							if(tr>mr) {
								mque.clear();
								while(!tmp.isEmpty()) {
									mque.offer(tmp.poll());
								}
							}else if(tr==mr) {
								if(tc>mc) {
									mque.clear();
									while(!tmp.isEmpty()) {
										mque.offer(tmp.poll());
									}
								}
							}
							
						}
					}
				}
			}
		}
        int len = mque.size();
		if(len<2) return false;
		score += len*len;
		while(!mque.isEmpty()) {
			int[] bs = mque.poll();
			map[bs[0]][bs[1]] = -2;
		}
		return true;
	}

}
