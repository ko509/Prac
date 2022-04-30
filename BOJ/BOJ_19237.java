import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 시간 : 124ms
// 메모리 : 14592KB
public class Main {

	static class Smell {
		int shark;
		int count;
		public Smell(int shark, int count) {
			super();
			this.shark = shark;
			this.count = count;
		}
	}
	static class Shark {
		int r;
		int c;
		int index;
		int dir;
		int[][] pr = new int[4][4];
		public Shark(int r, int c, int index) {
			super();
			this.r = r;
			this.c = c;
			this.index = index;
		}
	}
	static int K;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Smell[][] smell = new Smell[N][N];
		Shark[] sharks = new Shark[M+1];
		sharks[0] = new Shark(-1, -1, -1);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int shark = Integer.parseInt(st.nextToken());
				int count = 0;
				if(shark!=0) {
					count = K;
					sharks[shark] = (new Shark(i, j, shark));
				}
				smell[i][j] = new Smell(shark, count);
			}
		}
		String str = br.readLine();
		for (int i = 1; i <= M; i++) {
			sharks[i].dir = str.charAt((i-1)*2)-'1';
		}
		
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				str = br.readLine();
				for (int k = 0; k < 4; k++) {
					sharks[i].pr[j][k] = str.charAt(k*2)-'1';
				}
			}
		}
		
		// 위를 향할 때, 아래, 왼쪽, 오른쪽을 향할 떄
		// 방향을 가리키는 숫자는 위, 아래, 왼, 오
		int time = 0;
		while(true) {
			moveshark(sharks, smell);
			time++;
			if(check(sharks)) break;
			if(time>1000) break;
		}
		if(time>1000) time = -1;
		System.out.println(time);
		
	}
	private static boolean check(Shark[] sharks) {
		int M = sharks.length;
		for (int i = M-1; i > 1; i--) {
			if(sharks[i].index!=-1) return false;
		}
		return true;
	}
	private static void moveshark(Shark[] sharks, Smell[][] smell) {

		int N = smell.length;
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		for (Shark sk : sharks) {
			if(sk.index==-1) continue;
			int r = sk.r;
			int c = sk.c;
			int dir = sk.dir;
			int[][] pr = sk.pr;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[pr[dir][d]];
				int nc = c + dc[pr[dir][d]];
				if(nr>=N || nc>=N || nr<0 || nc<0 || smell[nr][nc].shark!=0) continue;
				r = nr;
				c = nc;
				dir = d;
				break;
			}
			if(sk.r==r && sk.c==c) {
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[pr[dir][d]];
					int nc = c + dc[pr[dir][d]];
					if(nr>=N || nc>=N || nr<0 || nc<0 || smell[nr][nc].shark!=sk.index) continue;
					r = nr;
					c = nc;
					dir = d;
					break;
				}
			}
			sk.r = r;
			sk.c = c;
			sk.dir = pr[sk.dir][dir];
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(smell[i][j].count>0) smell[i][j].count--;
				if(smell[i][j].count==0) smell[i][j].shark=0;
			}
		}
		int M = sharks.length;
		for (int i = 0; i < M; i++) {
			if(sharks[i].index==-1) continue;
			int r = sharks[i].r;
			int c = sharks[i].c;
			if(smell[r][c].shark == 0) {
				smell[r][c].shark = sharks[i].index;
				smell[r][c].count = K;
			}
			if(smell[r][c].shark != 0 && smell[r][c].shark!=sharks[i].index) {
				sharks[i].index = -1;
			}else if(smell[r][c].shark==sharks[i].index) {
				smell[r][c].count = K;
			}
			
		}
	}

}
