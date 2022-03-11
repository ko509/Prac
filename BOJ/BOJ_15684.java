import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 136ms
// 메모리 : 13676KB
public class Main {

	static int min;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][] labber = new int[H][N];
		int[] even = new int[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			
			labber[r][c] = 1;
			even[c]++;
			if(c+1<N) labber[r][c+1] = -1;
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			if(even[i]%2!=0) count++;
		}
		if(count>3) {
			System.out.println(-1);
			return;
		}	
		min = 4;
		dfs(0, 0, labber);
		System.out.println(min==4? -1 : min);
	}
	
	private static void dfs(int cnt, int starti, int[][] labber) {
		
		int H = labber.length;
		int N = labber[0].length;
		
		if(min<=cnt) {
			return;
		}
		if(cnt<=3) {
			if(canreach(labber)) {
				min = Math.min(min, cnt);
				return;
			}
			if(cnt==3) return;
		}
		int K = N*H;
		for (int i = starti; i < K; i++) {
			int nr = i/N;
			int nc = i%N;
			if(nc==N-1) continue;
			if(labber[nr][nc]!=0 || labber[nr][nc+1]!=0) continue;
			labber[nr][nc]=1;
			labber[nr][nc+1] = -1;
			dfs(cnt+1, i+1, labber);
			labber[nr][nc]=0;
			labber[nr][nc+1] = 0;
		}
	}

	private static boolean canreach(int[][] labber) {
		
		int H = labber.length;
		int N = labber[0].length;
		
		for (int i = 0; i < N; i++) {
			int c = i;
			int r = 0;
			while(r<H) {
				if(labber[r][c]==1) c+=1;
				else if(labber[r][c]==-1) c-=1;
				r++;
			}
			if(c!=i) return false;
		}
		
		return true;
	}

	



}
