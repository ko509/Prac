import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 516ms
// 메모리 : 59028KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		num[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken()) + num[i-1];
		}
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-2;
			int end = Integer.parseInt(st.nextToken())-1;
			if(start==-1) {
				sb.append(num[end]);
			} else {
				sb.append(num[end]-num[start]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
