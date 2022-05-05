import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 504ms
// 메모리 : 172616KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] trees = new long[N];
		st = new StringTokenizer(br.readLine());
		long end = -1;
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if(end<trees[i]) end = trees[i];
		}
		long start = 0;
		long mid = (start+end)/2;
		while(start<=end) {
			long total = 0;
			for (long i : trees) {
				if(i>=mid) total += i-mid;
			}
			if(total>=M) {
				start = mid + 1;
				
			}else {
				end = mid - 1;
			}
			mid = (start+end)/2;
		}
		System.out.println(end);
	}

}
