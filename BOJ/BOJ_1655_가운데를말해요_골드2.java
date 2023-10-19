import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 시간 : 352ms
// 메모리 : 32004KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> lower = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		PriorityQueue<Integer> higher = new PriorityQueue<>();
		
		int mid = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append(mid).append("\n");
		for (int i = 1; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(i % 2 == 1) { // n까지 하면 짝수 개
				if(n < mid) {
					lower.add(n);
					higher.add(mid);
					mid = lower.poll();
				} else {
					higher.add(n);
				}
			} else { // n까지 하면 홀수 개
				if(n <= mid) {
					lower.add(n);
				} else {
					lower.add(mid);
					higher.add(n);
					mid = higher.poll();
				}
			}
			sb.append(mid).append("\n");
		}
		
		System.out.print(sb);
	}

}
