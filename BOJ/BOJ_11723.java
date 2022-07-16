import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 시간 : 1028ms
// 메모리 : 326296KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		boolean[] v = new boolean[21];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			switch (op) {
			case "add":
				v[Integer.parseInt(st.nextToken())] = true;
				break;
			case "remove":
				v[Integer.parseInt(st.nextToken())] = false;
				break;
			case "check":
				if(v[Integer.parseInt(st.nextToken())]) sb.append(1);
				else sb.append(0);
				sb.append("\n");
				break;
			case "toggle":
                int to = Integer.parseInt(st.nextToken());
				v[to] = !v[to];
				break;
			case "all":
				for (int j = 1; j <= 20; j++) {
					v[j] = true;
				}
				break;
			case "empty":
				for (int j = 1; j <= 20; j++) {
					v[j] = false;
				}
				break;
			default:
				break;
			}
		}
		System.out.println(sb);
	}

}
