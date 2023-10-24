import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 504ms
// 메모리 : 121732KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] num = new int[N];
		int idx = 0;
		num[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
            if(n == num[idx]) continue;
			if(n > num[idx]) {
				num[++idx] = n;
			} else {
				int start = 0;
				int end = idx;
				
				while(start < end) {
					int mid = (start + end) / 2;
					if(num[mid] < n) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
				}
				num[end] = n;
			}
		}
		System.out.println(idx + 1);
	}

}
