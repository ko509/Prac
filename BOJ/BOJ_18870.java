import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 2220ms
// 메모리 : 258316KB
public class Main {

	static class Node implements Comparable<Node>{

		int value;
		int index;
		
		public Node (int value, int index) {
			this.value = value;
			this.index = index;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.value, o.value);
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		Node[] node = new Node[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			node[i] = new Node(n, i);
		}
		
		Arrays.sort(node);
		
		int cnt = 0;
		num[node[0].index] = 0;
		for (int i = 1; i < N; i++) {
			if(node[i].value != node[i-1].value) cnt++;
			num[node[i].index] = cnt;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(num[i]).append(" ");
		}
		System.out.println(sb);
	}

}
