import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// 시간 : 368ms
// 메모리 : 26004KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> que = new PriorityQueue<>(new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				return Long.compare(o1, o2);
			}
		});
		
		while(--N >= 0) {
			que.offer(Long.parseLong(br.readLine()));
		}
		
		long total = 0l;
		while(que.size() >= 2) {
			long a = que.poll();
			long b = que.poll();
			
			total += a + b;
			que.offer(a + b);
		}
		
		System.out.println(total);
	}

}
