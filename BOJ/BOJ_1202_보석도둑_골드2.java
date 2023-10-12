import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 시간 : 1352ms
// 메모리 : 132108KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> jw = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		PriorityQueue<Integer> bp = new PriorityQueue<>();
		PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
			
		});
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jw.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		for (int i = 0; i < K; i++) {
			bp.offer(Integer.parseInt(br.readLine()));
		}
		
		
		long total = 0;
		while(!bp.isEmpty()) {
			int cur = bp.poll();
//			System.out.println(cur);
			while(!jw.isEmpty() && jw.peek()[0] <= cur) {
				que.offer(jw.poll()[1]);
			}
			
			if(!que.isEmpty()) total += que.poll();
		}
		
		System.out.println(total);
	}

}
