import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 시간 : 668ms
// 메모리 : 152868KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		boolean[] num = new boolean[20000001];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			num[Integer.parseInt(st.nextToken()) + 10000000] = true;
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			if(num[Integer.parseInt(st.nextToken()) + 10000000]) sb.append("1 ");
			else sb.append("0 ");
		}
		System.out.println(sb);
	}

}
