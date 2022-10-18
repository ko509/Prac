import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 432ms
// 메모리 : 45748KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] student = new int[N];
		List<Integer>[] bigger = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			bigger[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int small = Integer.parseInt(st.nextToken())-1;
			int big = Integer.parseInt(st.nextToken())-1;
			bigger[small].add(big);
			student[big]++;
		}
		
		Queue<Integer> que = new LinkedList<>();
		boolean[] v = new boolean[N];
		find_zero_link(bigger, student, que, v);
		StringBuilder sb = new StringBuilder();
		while(!que.isEmpty()) {
			find_zero_link(bigger, student, que, v);
			sb.append(que.poll()).append(" ");
		}
		System.out.println(sb);
	}

	private static void find_zero_link(List<Integer>[] bigger, int[] student, Queue<Integer> que, boolean[] v) {

		int N = student.length;
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			if(student[i] == 0) {
				que.offer(i);
				v[i] = true;
				for (int b : bigger[i]) {
					student[b]--;
				}
			}
		}
	}

}
