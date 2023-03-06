import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 80ms
// 메모리 : 11488KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int left = 0;
		int right = M;
		
		int J = Integer.parseInt(br.readLine());
		
		int sum = 0;
		while(--J >= 0) {
			int n = Integer.parseInt(br.readLine());
			if(n > right) {
				sum += n - right;
				right = n;
				left = right - M + 1;
			} else if (n < left) {
				sum += left - n;
				left = n;
				right = n + M - 1;
			}
		}
		
		System.out.println(sum);
	}

}
