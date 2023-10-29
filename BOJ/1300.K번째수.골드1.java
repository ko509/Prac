import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 124ms
// 메모리 : 11560KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		long K = Long.parseLong(br.readLine());
		
		long start = 1;
		long end = N * N;
		
		while(start <= end) {
			long mid = (start + end) / 2;
			
			long cnt = 0;
			boolean flag = false;
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(mid / i, N);
			}
			
			if(cnt >= K) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		System.out.println(start);
	}

}
