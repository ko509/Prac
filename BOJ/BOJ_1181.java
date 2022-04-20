import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 시간 : 256ms
// 메모리 : 27068KB
public class Main {
	
	static class Sentence implements Comparable<Sentence>{
		int len;
		String str;
		public Sentence(String str) {
			super();
			this.str = str;
			this.len = str.length();
		}
		@Override
		public int compareTo(Sentence o) {
			int n = Integer.compare(this.len, o.len);
			if(n!=0) return n;
			return this.str.compareTo(o.str);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Sentence> sen = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			sen.offer(new Sentence(br.readLine()));
		}
		StringBuilder sb = new StringBuilder();
		String tmp = "";
		while(!sen.isEmpty()) {
			Sentence s = sen.poll();
			if(s.str.equals(tmp)) continue;
			sb.append(s.str).append("\n");
			tmp = s.str;
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}

}
