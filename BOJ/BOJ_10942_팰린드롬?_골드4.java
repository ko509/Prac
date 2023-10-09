import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 772ms
// 메모리 : 242528KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] num = new int[N];
		int[][] p = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
            p[i][i] = 1;
		}
		
		init(num, p, 0, N - 1);
		
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			
			if(p[start][end] == 1) sb.append("1\n");
			else sb.append("0\n");
		}
		
		System.out.println(sb);
	}

	private static void init(int[] num, int[][] p, int start, int end) {

		if(start > end) return;
        if(p[start][end] > 0) return;
		
		if(num[start] == num[end]) {
            if(start + 1 == end) {
                p[start][end] = 1;
            } else {
                if(p[start + 1][end - 1] == 0){
				    init(num, p, start + 1, end - 1);
			    }
			    p[start][end] = p[start + 1][end - 1];
            }
		} else {
			p[start][end] = 2;
		}
		init(num, p, start + 1, end);
		init(num, p, start, end - 1);
	}

}
