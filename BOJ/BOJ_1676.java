import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 시간 : 84ms
// 메모리 : 11544KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] fac = new int[N+1];
		for (int i = 2; i <= N; i++) {
			double tmp = i;
			int time = 0;
			while(tmp>0) {
				if(tmp%5==0) time++;
				tmp/=5d;
			}
			fac[i] = fac[i-1] + time;
		}
		
		System.out.println(fac[N]);
	}

}
