import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 1592ms
// 메모리 : 57696KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], 987654321);
            dist[i][i] = 0;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int time = Integer.parseInt(st.nextToken());
			dist[start][end] = time;
			dist[end][start] = time;
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken())-1;
		int v2 = Integer.parseInt(st.nextToken())-1;
		
		if(dist[v1][v2] >= 987654321) System.out.println(-1);
		else if(dist[0][v1] >= 987654321 || dist[v2][N-1] >= 987654321) {
			if(dist[0][v2] >= 987654321 || dist[v1][N-1] >= 987654321) {
				System.out.println(-1);
			} else {
				System.out.println(dist[0][v2] + dist[v2][v1] + dist[v1][N-1]);
			}
		} else if(dist[0][v2] >= 987654321 || dist[v1][N-1] >= 987654321) {
			System.out.println(dist[0][v1] + dist[v1][v2] + dist[v2][N-1]);
		} else {
			int n1 = dist[0][v1] + dist[v1][v2] + dist[v2][N-1];
			int n2 = dist[0][v2] + dist[v2][v1] + dist[v1][N-1];
			if(n1 > n2) System.out.println(n2);
			else System.out.println(n1);
		}
	}

}
