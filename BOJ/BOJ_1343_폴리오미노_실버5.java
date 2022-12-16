import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 76ms
// 메모리 : 11500KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] cs = br.readLine().toCharArray();
		int len = cs.length;
		char[] answer = new char[len];
		
		int cnt = 0;
		for (int i = 0; i < len; i++) {
			if(cs[i] == 'X') {
				cnt++;
				if(cnt == 4) {
					for (int j = i-cnt+1; j <= i; j++) {
						answer[j] = 'A';
					}
					cnt = 0;
				}
			} else {
				if(cnt % 2 == 1) {
					System.out.println(-1);
					return;
				} else {
					for (int j = i-cnt; j < i; j++) {
						answer[j] = 'B';
					}
					cnt = 0;
				}
				answer[i] = '.';
			}
		}
		if(cnt % 2 == 1) {
			System.out.println(-1);
			return;
		} else {
			for (int j = len-cnt; j < len; j++) {
				answer[j] = 'B';
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char c : answer) {
			sb.append(c);
		}
		System.out.println(sb);
	}

}
