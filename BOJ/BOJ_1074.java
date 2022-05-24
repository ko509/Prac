import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 76ms
// 메모리 : 11504KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int time = N-1;
		int _N = 1;
		for (int i = 0; i < N; i++) {
			_N *= 2;
		}
		int r = 0;
		int c = 0;
		while(_N!=1) {
            int n = _N/2;
            int n2 = n * n;
			if(R<n + r) {
				if(C<n + c) {
					arr[time] = 0;
					
				}
				else {
					arr[time] = n2;
					c += n;
				}
			} else {
				if(C<_N/2 + c) {
					arr[time] = 2 * n2;
					r += n;
				}
				else {
					arr[time] = 3 * n2;
					r += n;
					c += n;
				}
			}
			_N = n;
			time-=1;
		}
		long total = 0;
		for (int i = 0; i < N; i++) {
			int tmp = arr[i];
			total += tmp;
		}
		System.out.println(total);
	}

}
