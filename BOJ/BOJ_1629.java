import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 76ms
// 메모리 : 11536KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		System.out.println(power(N%K, M, K));
	}

	private static long power(int n, int m, int k) {

		if(m==0) return 1;
		else if(m==1) return n;
		long n2 = power(n, m/2, k) % k;
		if(m%2==0) {
			return 1l * ((n2%k) * (n2%k)) % k;
		} else {
			return 1l * (((n2%k) * (n2%k)) % k * (n % k)) % k;
		}
	}

}
