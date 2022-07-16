import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 72ms
// 메모리 : 11552KB
public class Main {

	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] stick = new int[N][2];
		
		stick[0][0] = 1;
		
		for (int i = 1; i < N; i++) {
			stick[i][0] = (stick[i-1][0] + stick[i-1][1])%10007;
			stick[i][1] = stick[i-1][0];
		}
		
		System.out.println((stick[N-1][0] + stick[N-1][1])%10007);
		
	}

}
