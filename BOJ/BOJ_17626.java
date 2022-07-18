import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 시간 : 396ms
// 메모리 : 13380KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int sqrtN = (int) Math.sqrt(N);
		
		int[] num = new int[sqrtN+1];
		int[] answer = new int[N+1];
		Arrays.fill(answer, Integer.MAX_VALUE);
		for (int i = 0; i <= sqrtN; i++) {
			num[i] = i*i;
		}
		
		for (int i = 0; i <= sqrtN; i++) {
			for (int j = i; j <= sqrtN; j++) {
				for (int d = j; d <= sqrtN; d++) {
					for (int k = d; k <= sqrtN; k++) {
						int t = 4;
						if(i==0) t--;
						if(j==0) t--;
						if(d==0) t--;
						if(k==0) t--;
						int n = num[i] + num[j] + num[d] + num[k];
						if(n <= N && answer[n] > t) {
							answer[n] = t;
						}
					}
				}
			}
		}
		
		System.out.println(answer[N]);
	}

}
