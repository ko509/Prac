import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 4300ms
// 메모리 : 310084KB
public class Main {
	static class DSLR {
		int[] arr;
		int num;
		String sb;
		public DSLR(int[] arr, String str) {
			super();
			this.arr = new int[4];
			this.sb = str;
			for (int i = 0; i < 4; i++) {
				this.arr[i] = arr[i];
			}
		}
//		
		public DSLR(int num, String str) {
			super();
			this.num = num;
			this.sb = str;
		}
		
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] start = new int[4];
			int[] end = new int[4];
			String s = st.nextToken();
			String e = st.nextToken();
			String answer = "";
			for (int i = 4-s.length(); i < 4; i++) {
				start[i] = s.charAt(i-4+s.length())-'0';
			}
			for (int i = 4-e.length(); i < 4; i++) {
				end[i] = e.charAt(i-4+e.length())-'0';
			}
			
			Queue<DSLR> que = new LinkedList<>();
			que.offer(new DSLR(start, ""));
			boolean[] v = new boolean[10000];
			v[Integer.parseInt(s)] = true;
			
			while(!que.isEmpty()) {
				DSLR cur = que.poll();
				int[] arr = cur.arr;
				int carry = 0;
				int[] tmp = new int[4];
				for (int i = 3; i>=0; i--) {
					tmp[i] = arr[i]*2%10 + carry;
					carry = 0;
					if(arr[i]*2>=10) {
						carry = 1;
					}
				}
				if(checkvisited(tmp, v)) {
					if(samearr(tmp, end)) {
						answer = cur.sb.toString()+"D";
						break;
					}
					que.offer(new DSLR(tmp, cur.sb+"D"));
				}
				for (int i = 0; i < 4; i++) {
					int next = i-1;
					if(i-1==-1) next = 3;
					tmp[next] = arr[i];
				}
				if(checkvisited(tmp, v)) {
					if(samearr(tmp, end)) {
						answer = cur.sb.toString()+"L";
						break;
					}
					que.offer(new DSLR(tmp, cur.sb+"L"));
				}
				carry = -1;
				for (int i = 3; i >= 0; i--) {
					tmp[i] = arr[i] + carry;
					carry = 0;
					if(tmp[i]<0) {
						tmp[i] = 9;
						carry = -1;
					}
				}
				if(checkvisited(tmp, v)) {
					if(samearr(tmp, end)) {
						answer = cur.sb.toString()+"S";
						break;
					}
					que.offer(new DSLR(tmp, cur.sb+"S"));
				}
				for (int i = 0; i < 4; i++) {
					int next = i-1;
					if(i-1==-1) next = 3;
					tmp[i] = arr[next];
				}

				if(checkvisited(tmp, v)) {
					if(samearr(tmp, end)) {
						answer = cur.sb.toString()+"R";
						break;
					}
					que.offer(new DSLR(tmp, cur.sb+"R"));
				}
			}
			System.out.println(answer);
		}
	}

	private static boolean checkvisited(int[] tmp, boolean[] v) {

		int total = 0;
		int c = 1;
		for (int i = 3; i >= 0; i--) {
			total += c * tmp[i];
			c *= 10;
		}
		if(v[total]) return false;
		v[total] = true;
		return true;
	}

	private static boolean samearr(int[] start, int[] end) {
		for (int i = 0; i < 4; i++) {
			if(start[i]!=end[i]) return false;
		}
		return true;
	}

}
