import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 76ms
// 메모리 : 11540KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int t = Math.min(A, B);
		int min = -1;
		for (int i = 1; i <= t; i++) {
			if(A%i==0 && B%i==0) min = i;
		}
		int max = (A/min) * B;
		System.out.println(min);
		System.out.println(max);
		
	}

}
