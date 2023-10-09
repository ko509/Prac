import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 시간 : 476ms
// 메모리 : 51172KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long P = Long.parseLong(st.nextToken());
		
		PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		int twice = 0;
		for (int i = 0; i < N; i++) {
			twice = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == -1) twice++;
				else que.offer(n);
			}
			
			while(!que.isEmpty()) {
				int cur = que.poll();
				if(cur <= P) {
					P += cur;
				} else {
					while(twice > 0 && P < cur) {
						twice--;
						P *= 2;
					}
					if(P < cur) {
						System.out.println(0);
						return;
					} else {
						P += cur;
					}
				}
			}
			
			while(twice > 0) {
				P *= 2;
				twice--;
			}
		}
		System.out.println(1);
		
	}

}
