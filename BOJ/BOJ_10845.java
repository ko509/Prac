package _202205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10845_큐_실버4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int top = 0;
		int bottom = 0;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			switch (op) {
			case "push":
				arr[top++] = Integer.parseInt(st.nextToken());
				break;
			case "pop":
				if(top!=bottom) sb.append(arr[bottom++]).append("\n");
				else sb.append(-1).append("\n");
				break;
			case "size":
				sb.append(top-bottom).append("\n");
				break;
			case "empty":
				if(top==bottom) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "front":
				if(top==bottom) sb.append(-1).append("\n");
				else sb.append(arr[bottom]).append("\n");
				break;
			case "back":
				if(top==bottom) sb.append(-1).append("\n");
				else sb.append(arr[top-1]).append("\n");
				break;				
			default:
				break;
			}
		}
		System.out.println(sb);
	}

}
