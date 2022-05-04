import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 552ms
// 메모리 : 57828KB
public class Main {

    static int[] numbers;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(findnum(n)) {
				sb.append("1\n");
			}else {
				sb.append("0\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean findnum(int n) {
		int start = 0;
		int end = numbers.length-1;
		int mid = (start+end)/2;
		while(start<=end) {
			if(numbers[mid]==n) {
				return true;
			}else if(numbers[mid]>n) {
				end = mid-1;
			}else {
				start = mid+1;
			}
			mid = (start+end)/2;
		}
		return false;
	}

}
