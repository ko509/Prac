import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 시간 : 1668ms
// 메모리 : 480612KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10001; i++) {
			for (int j = 0; j < arr[i]; j++) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}

}
