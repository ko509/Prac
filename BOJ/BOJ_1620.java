import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 시간 : 460ms
// 메모리 : 57480KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] poket = new String[N+1];
		Map<String, Integer> mon = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			poket[i] = str;
			mon.put(str, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String test = br.readLine();
			if(test.charAt(0)<'A') sb.append(poket[Integer.parseInt(test)]).append("\n");
			else sb.append(mon.get(test)).append("\n");
		}
		System.out.println(sb);
	}

}
