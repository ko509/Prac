import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 : 132ms
// 메모리 : 14348KB
public class Main {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int top = 0;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			if(op.equals("push")) {
				arr[top++] = Integer.parseInt(st.nextToken());
			}else if(op.equals("pop")) {
				if(top>0) sb.append(arr[--top]).append("\n");
				else sb.append(-1).append("\n");
			}else if(op.equals("size")) {
				sb.append(top).append("\n");
			}else if(op.equals("empty")) {
				if(top==0) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}else {
				if(top>0) sb.append(arr[top-1]).append("\n");
				else sb.append(-1).append("\n");
			}
		}
		System.out.println(sb);
	}

}
