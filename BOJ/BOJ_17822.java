package _202203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 192ms
// 메모리 : 29256KB
public class BOJ_17822 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] circle = new int[N+1][M];
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				circle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[][] answer = new boolean[N+1][M];
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // x의 배수인 원판을
			int d = Integer.parseInt(st.nextToken()); // 0 -> 시계     1-> 반시계
			int K = Integer.parseInt(st.nextToken()); // 회전 수
		
			for (int i = 1; i < N+1; i++) {
				if(i%x!=0) continue;
				if(d==0) {
					for (int k = 0; k < K; k++) {
						int tmp = circle[i][M-1];
						for (int j = M-1; j >= 1; j--) {
							circle[i][j] = circle[i][j-1];
						}
						circle[i][0] = tmp;
					}
				}else {
					for (int k = 0; k < K; k++) {
						int tmp = circle[i][0];
						for (int j = 0; j < M-1; j++) {
							circle[i][j] = circle[i][j+1];
						}
						circle[i][M-1] = tmp;
					}
				}
			}
			
			int[] di = {-1,0,1,0};
			int[] dj = {0,-1,0,1};
			boolean flag = false;
			for (int i = 1; i < N+1; i++) {
				for (int j = 0; j < M; j++) {
					if(circle[i][j]==0) continue;
					Queue<int[]> que = new LinkedList<int[]>();
					que.offer(new int[] {i,j, circle[i][j]});
					while(!que.isEmpty()) {
						int[] cur = que.poll();
						for (int l = 0; l < 4; l++) {
							int ni = cur[0]+di[l];
							int nj = cur[1]+dj[l];
							if(ni<0 || ni>=N+1) continue;
							if(nj==M) nj = 0;
							else if(nj==-1) nj = M-1;
							if(cur[2]!=circle[ni][nj]) continue;
							circle[ni][nj] = 0;
							que.offer(new int[] {ni,nj, cur[2]});
							flag = true;
						}
					}
				}
			}
			if(!flag){
				int total = 0;
				int count = 0;
				for (int i = 1; i < N+1; i++) {
					for (int j = 0; j < M; j++) {
						total+=circle[i][j];
						if(circle[i][j]!=0) count++;
					}
				}
				double avg = 1d*total/count;
				for (int i = 1; i < N+1; i++) {
					for (int j = 0; j < M; j++) {
						if(circle[i][j]>avg) circle[i][j]--;
						else if(circle[i][j]!=0&&circle[i][j]<avg) {
							circle[i][j]++;
						}
					}
				}
			}
			
		}
		int count = 0;
		for (int i = 1; i < N+1; i++) {
			for (int j = 0; j < M; j++) {
				if(!answer[i][j]) count+=circle[i][j];
			}
		}
//		for (boolean[] bs : answer) {
//			System.out.println(Arrays.toString(bs));
//		}
//		System.out.println();
//		for (int[] bs : circle) {
//			System.out.println(Arrays.toString(bs));
//		}
//		System.out.println();
		System.out.println(count);
		
	}

}
