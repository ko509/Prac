import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int n = o1[0] - o2[0];
				if(n != 0) return n;
				return o2[1] - o1[1];
			}
		});
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			que.offer(new int[] {start, end});
		}
		
		int point = -1000000001;
		int len = 0;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			
			if(cur[1] <= point) continue;
			if(cur[0] >= point) {
				len += cur[1] - cur[0];
				point = cur[1];
			} else {
				len += cur[1] - point;
				point = cur[1];
			}
		}
		
		System.out.println(len);
	}

}
