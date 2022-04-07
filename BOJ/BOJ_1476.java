import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 76ms
// 메모리 : 11516KB
public class BOJ_1476 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int e = 1;
		int s = 1;
		int m = 1;
		int time = 1;
		while(true) {
			if(E==e && S==s && M==m) break;
			if(++e==16) e=1;
			if(++s==29) s=1;
			if(++m==20) m=1;
			time++;
		}
		System.out.println(time);
	}

}






