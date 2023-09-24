import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 시간 : 964ms
// 메모리 : 213708KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>();
		int[] nge = new int[N];
		Arrays.fill(nge, -1);
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				int[] cur = stack.peek();
				if(n > cur[1]) {
					stack.pop();
					nge[cur[0]] = n;
				} else break;
			}
			stack.add(new int[] {i, n});
		}
		
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(nge[i]).append(" ");
		}
		System.out.println(sb);
	}

}
