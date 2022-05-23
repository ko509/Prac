import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 80ms
// 메모리 : 11520KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int mod = 1234567891;
		int r = 31;
		
        String str = br.readLine();
		long total = 0;
		for (int i = 0; i < N; i++) {
            long n = str.charAt(i) - 'a' + 1;
			for (int j = 0; j < i; j++) {
				n *= r % mod;
				n %= mod;
			}
			total += n % mod;
		}
		
		total %= mod;
		System.out.println(total);
	}

}
