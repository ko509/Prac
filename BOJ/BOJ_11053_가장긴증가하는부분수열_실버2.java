import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 96ms
// 메모리 : 11904KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] num = new int[N + 1];
		int[] len = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				if(num[j] >= num[i]) continue; 
				if(len[i] < len[j] + 1) len[i] = len[j] + 1;
			}
			if(max < len[i]) max = len[i];
		}
		
		System.out.println(max);
		
		
	}

}
