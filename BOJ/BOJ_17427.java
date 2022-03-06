import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 108ms
// 메모리 : 34996KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Long total = 0L;
		
		for (int i = 1; i <= N; i++) {
			total += N/i * i;
		}
		System.out.println(total);
	}

}
