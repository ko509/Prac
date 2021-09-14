import java.util.Scanner;

public class JO_1707 {
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int N;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int[][] map = new int[N][N];
		int r = 0;
		int c = 0;
		int d = 0;
		for (int i = 1; i < N*N+1; i++) {
			map[r][c] = i;
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!checked(nr,nc) || map[nr][nc]!=0) {
				d =(d+1)%4;
				nr = r+dr[d];
				nc = c+dc[d];
			}
//			if(map[nr][nc]!=0) {
//				d=(d+1)%4;
//				nr = r+dr[d];
//				nc = c+dc[d];
//			}
			r = nr;
			c = nc;
			
			
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static boolean checked(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N ;
	}

}
