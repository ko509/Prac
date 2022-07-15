import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// 시간 : 300ms
// 메모리 : 24400KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int n = Integer.compare(Math.abs(o1), Math.abs(o2));
				if(n!=0) return n;
				return Integer.compare(o1, o2);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n!=0) {
				que.offer(n);
			} else {
				if(que.isEmpty()) sb.append(0).append("\n");
				else sb.append(que.poll()).append("\n");
			}
		}
		System.out.println(sb);
	}

}
