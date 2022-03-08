import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 시간 : 96ms
// 메모리 : 12744KB
public class Main {

	static class Dragon{
		int x;
		int y;
		int d;
		int G;
		int g;
		List<int[]> list;
		
		public Dragon(int r, int c, int d, int g) {
			super();
			this.x = r;
			this.y = c;
			this.d = d;
			G = g;
			this.g = 0;
			this.list = new ArrayList<int[]>();
			list.add(new int[] {r,c});
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] dr = {0,-1,0,1};
		int[] dc = {1,0,-1,0};
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101];
		int time = 1;
		Dragon[] dragon = new Dragon[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			dragon[i] = new Dragon(y, x, d, g);
			map[y][x] = 1;
			dragon[i].list.add(new int[] {y+dr[d],x+dc[d]});
			dragon[i].d = (dragon[i].d++)%4;
			dragon[i].x = x+dc[d];
			dragon[i].y = y+dr[d];
			map[y+dr[d]][x+dc[d]] = 1;
			
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < dragon[i].G; j++) {
				List<int[]> tmp = new ArrayList<>();
				int basey = dragon[i].y;
				int basex = dragon[i].x;
				for (int[] ks : dragon[i].list) {
					int nx = basex+basex-ks[1];
					int ny = ks[0];
					int diffy = ny-basey;
					int diffx = nx-basex;
					tmp.add(new int[] {basey-diffx, basex-diffy});
				}
				boolean flag = false;
				for (int[] ks : tmp) {
					dragon[i].list.add(ks);
					if(flag==false) {
						dragon[i].y = ks[0];
						dragon[i].x = ks[1];
						flag = true;
					}
					map[ks[0]][ks[1]] = 1;
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j]==1 && map[i][j+1]==1 && map[i+1][j]==1 && map[i+1][j+1]==1) count++;
			}
		}
		System.out.println(count);
	}

}
