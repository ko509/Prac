import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 시간 : 196ms
// 메모리 : 21144KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int total = 0;
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				total -= stack.pop();
			}else {
				total += n;
				stack.add(n);
			}
		}
		
		System.out.println(total);
	}

}
