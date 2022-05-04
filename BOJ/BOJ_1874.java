import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 시간 : 320ms
// 메모리 : 27264KB
public class BOJ_1874_스택수열_실버3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int count = 0;
		for (int i = 1; i <= N; i++) {
			while(!stack.isEmpty() &&stack.peek()==num[count]) {
				stack.pop();
				sb.append('-').append('\n');
				count++;
			}
			stack.add(i);
			sb.append('+').append('\n');
		}
		while(!stack.isEmpty() && stack.peek()==num[count]) {
			stack.pop();
			sb.append('-').append('\n');
			count++;
		}
		if(stack.isEmpty()) System.out.println(sb);
		else System.out.println("NO");
	}

}
