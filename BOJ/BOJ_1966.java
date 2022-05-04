import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 100ms
// 메모리 : 13056KB
public class Main {

	static class Arr implements Comparable<Arr>{
		int index;
		int priority;
		public Arr(int index, int priority) {
			super();
			this.index = index;
			this.priority = priority;
		}
		@Override
		public int compareTo(Arr o) {
			return Integer.compare(this.priority, o.priority);
		}
		
		
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int order = Integer.parseInt(st.nextToken());
			
			Queue<Arr> que = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				que.offer(new Arr(i, Integer.parseInt(st.nextToken())));
			}
			int count = 1;
			int answer = 0;
			while(!que.isEmpty()) {
				if(check(que)) {
					if(que.poll().index==order) {
						answer = count; 
						break;
					}
					count++;
				}else {
					que.offer(que.poll());
				}
			}
			sb.append(answer).append('\n');
		}
		System.out.println(sb);
	}
	private static boolean check(Queue<Arr> que) {
		int cur = que.peek().priority;
		for (Arr arr : que) {
			if(arr.priority>cur) return false;
		}
		return true;
	}

}
