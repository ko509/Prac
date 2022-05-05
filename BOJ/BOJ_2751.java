import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 668ms
// 메모리 : 125028KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[2000001];
		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())+1000000] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2000001; i++) {
			if(arr[i]) sb.append(i-1000000).append('\n');
		}
		System.out.println(sb);
	}

}
