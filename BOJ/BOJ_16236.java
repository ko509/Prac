package _1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
	
	public static class Shark{
		int r;
		int c;
		int level;
		int eat;
		public Shark(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			this.level = 2;
			this.eat = 0;
		}
		
		public Shark(int r, int c, int level) {
			super();
			this.r = r;
			this.c = c;
			this.level = level;
		}

		public void eat() {
			this.eat++;
			if(this.eat==this.level) {
				this.eat=0;
				this.level++;
			}
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		Shark bs = null;
		List<Shark> slist = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					bs = new Shark(i,j);
					map[i][j] = 0;
				}else if(map[i][j]!=0) {
					slist.add(new Shark(i,j, map[i][j]));
				}
			}
		}
		int cnt =0;
		int n =0;
		while((n=eatfish(bs, slist, map))!=0) {
			cnt+=n;
		};
		System.out.println(cnt);
	}

	private static int eatfish(Shark bs, List<Shark> slist, int[][] map) {

		int min = Integer.MAX_VALUE;
		int r = -1;
		int c = -1;
		int blevel = bs.level;
		int l = slist.size();
		int kill = -1;
		for (int i = 0; i<l; i++) {
			Shark s = slist.get(i);
			int n = distance(s, bs, map, min);
			if(s.level>=blevel) continue;
			if(min>n) {
				min = n;
				kill = i;
				r = s.r;
				c = s.c;
			}else if(min==n) {
				if(r>s.r) {
					kill = i;
					r = s.r;
					c = s.c;
				}else if(r==s.r) {
					if(c>s.c) {
						kill = i;
						c = s.c;
					}
				}
			}
		}
		if(min!=Integer.MAX_VALUE) {
			//System.out.println(r+" "+c+" == "+map[r][c]);
			bs.r = r;
			bs.c = c;
			bs.eat();
			slist.remove(kill);
			return min;
		}
		return 0;
	}

	private static int distance(Shark s, Shark bs, int[][]map, int min) {
		int[] dr = {-1,0,1,0};
		int[] dc = {0,-1,0,1};
		int N = map.length;
		
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		que.offer(new int[] {bs.r, bs.c, 0});
		visited[bs.r][bs.c] = true;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			int n = cur[2];
			if(n>min) return n;
			if(r==s.r && c==s.c) {
				return n;
			}
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(nr>=N || nc>=N || nr<0|| nc<0) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc]>bs.level) continue;
				visited[nr][nc] = true;
				que.offer(new int[] {nr,nc,n+1});
			}
		}
		return Integer.MAX_VALUE;
	}

}
