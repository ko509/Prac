import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 80ms
// 메모리 : 11556KB
public class Main {

	static int N;
	static long B;
	static int[][] A;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		A = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		
		int[][] tmp = dfs(B);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(tmp[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	private static int[][] dfs(long b) {

		if(b == 1) {
			return A;
		}
		int[][] tmp = dfs(b / 2);
		int[][] matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					matrix[i][j] += (tmp[i][k] * tmp[k][j]) % 1000;
				}
			}
		}
		
		if(b % 2 == 1) {
			
			int[][] mat2 = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						mat2[i][j] += (matrix[i][k] * A[k][j]) % 1000;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					mat2[i][j] %= 1000;
				}
			}
			return mat2;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] %= 1000;
			}
		}
		
		return matrix;
	}

}
