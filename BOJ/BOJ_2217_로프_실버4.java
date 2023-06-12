import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		if(N <= 0) {
			System.out.println(0);
			return;
		}
		int[] num = new int[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		
		int total = num[0] * N;
		
		for (int i = 1; i < N; i++) {
			int tmp = num[i] * (N - i);
			if(tmp > total) total = tmp;
		}
		
		System.out.println(total);
	}

}
