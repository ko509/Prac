import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;

// 시간 : 80ms
// 메모리 : 11664KB
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 최대 : 9876543210
		Queue<Long> que = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			que.offer(i*1l);
		}
		
		int cnt = -1;
		while(!que.isEmpty()) {
			long cur = que.poll();
			cnt++;
			if(cnt == N) {
				System.out.println(cur);
				return;
			}
			long tmp = cur%10;
			for (int i = 0; i < tmp; i++) {
				que.offer(cur*10+i);
			}
		}
		System.out.println(-1);
	}



}
