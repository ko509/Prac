import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Comparator;

// 시간 : 340ms
// 메모리 : 26024KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n > 0) {
				que.offer(n);
			} else {
				if(que.isEmpty()) sb.append(0).append("\n");
                else sb.append(que.poll()).append("\n");
			}
		}
		System.out.println(sb);
	}

}
