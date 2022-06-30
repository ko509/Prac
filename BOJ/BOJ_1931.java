import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 : 460ms
// 메모리 : 42424KB
public class Main {

	static class Time implements Comparable<Time> {
		int start;
		int end;
		public Time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Time o) {
			int n = Integer.compare(this.end, o.end);
			if(n!=0) return n;
			else return Integer.compare(this.start, o.start);
		}
		
		
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Time[] time = new Time[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			time[i] = new Time(start, end);
		}
		
		Arrays.sort(time);
		
		int start = time[0].end;
		int count = 1;
		for (int i = 1; i < N; i++) {
            if(time[i].start >= start) {
                count++;
                start = time[i].end;
            }
		}
		
		System.out.println(count);
	}

}
