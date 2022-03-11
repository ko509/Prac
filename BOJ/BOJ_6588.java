import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 1088ms
// 메모리 : 37756KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		boolean[] num = new boolean[1000001];
		for (int i = 2; i < 500001; i++) {
            if(num[i]) continue;
			int cnt = 2;
			while(cnt*i<=1000000) {
				num[cnt*i] = true;
				cnt++;
			}
		}
		
		while((str = br.readLine()) != null) {
			int N = Integer.parseInt(str);
			if(N==0) break;
			int start = 3;
			while(true) {
				int end = N-start;
				if(!num[start] && !num[end]) break;
				start+=2;				
			}
			System.out.println(N+" = "+start+" + "+(N-start));
		}
	}

}
