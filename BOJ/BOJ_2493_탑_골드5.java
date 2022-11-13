import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 시간 : 644ms
// 메모리 : 110160KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<int[]> stack = new Stack<>();
		int[] see = new int[N];
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty() && stack.peek()[1] < n) {
				stack.pop();
			}
			if(!stack.isEmpty()) {
				see[i] = stack.peek()[0];
			}
			stack.add(new int[] {i+1, n});
		}
		StringBuilder sb = new StringBuilder();
		for (int i : see) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

}
