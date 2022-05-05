import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 : 84ms
// 메모리 : 11636KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			char[] set = br.readLine().toCharArray();
			if(check(set)) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean check(char[] set) {
		int N = set.length;
		int count = 0;
		for (int i = 0; i < N; i++) {
			if(set[i]=='(') count++;
			else if(set[i]==')'){
				if(count==0) return false;
				count--;
			}
		}
		if(count>0) return false;
		return true;
	}

}
