import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 시간 : 400ms
// 메모리 : 203484KB
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			System.out.println(countyear(M, N, x, y));
			
		}
	}

	private static int countyear(int M, int N, int x, int y) {
		
		int D = findgcd(M, N);
		int nx = x;
		if(y==N) y=0;
		int len = N/D;
		int[] xlist = new int[len];
		for (int i = 0; i < len; i++) {
			xlist[i] = nx;
			nx += M;
		}
		for (Integer integer : xlist) {
			if(integer%N==y) return integer;
		}
		return -1;
	}

	private static int findgcd(int m, int n) {
		
		if(m%n==0) return n;
		return findgcd(n, m%n);
	}

}
