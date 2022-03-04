import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Passenger {
		int sr;
		int sc;
		int er;
		int ec;
		public Passenger(int sr, int sc, int er, int ec) {
			super();
			this.sr = sr;
			this.sc = sc;
			this.er = er;
			this.ec = ec;
		}
	}
	static int N;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		
		int[][] map = new int[N][N];
		List<Passenger> p = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken())-1;
			int sc = Integer.parseInt(st.nextToken())-1;
			int er = Integer.parseInt(st.nextToken())-1;
			int ec = Integer.parseInt(st.nextToken())-1;
			p.add(new Passenger(sr, sc, er, ec));
		}
		
		while(true) {
			int min = Integer.MAX_VALUE;
			Passenger minp = null;
			for (Passenger passenger : p) {
				int dis = distance(r,c,passenger.sr, passenger.sc, map);
				if(dis==-1) continue;
				if(min > dis) {
					min = dis;
					minp = passenger;
				}else if(min==dis) {
					if(minp.sr>passenger.sr) {
						minp = passenger;
					}else if(minp.sr==passenger.sr) {
						if(minp.sc > passenger.sc) minp = passenger;
					}
				}
			}
			if(minp==null) {
                System.out.println(-1);
				return;
			}
			T -= min;
			if(T<0) {
                System.out.println(-1);
				return;
			}
			int t = distance(minp.sr, minp.sc, minp.er, minp.ec, map);
            if(t==-1){
                System.out.println(-1);
				return;
            }
			T -= t;
			if(T<0) {
                System.out.println(-1);
				return;
			}
			r = minp.er;
			c = minp.ec;
			T += t*2;
			p.remove(minp);
			if(p.size()==0) break;
		}
		System.out.println(T);
	}
	
	private static int distance(int i, int j, int sr, int sc, int[][] map) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {i,j,0});
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		boolean[][] v = new boolean[N][N];
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(cur[0]==sr && cur[1]==sc) {
				return cur[2];
			}
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] +dr[d];
				int nc = cur[1] +dc[d];
				if(nr<0 || nc < 0 || nr>=N || nc>=N || v[nr][nc] || map[nr][nc]==49) continue;
				v[nr][nc] = true;
				que.offer(new int[] {nr,nc, cur[2]+1});
			}
		}
		return -1;
	}

}
