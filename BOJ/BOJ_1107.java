package _1105;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_1107 {

	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String N = br.readLine();
		int M = Integer.parseInt(br.readLine());
		boolean[] v = new boolean[10];
		if(M!=0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				v[Integer.parseInt(st.nextToken())] = true;
			}
		}
		int len = N.length();
		int ch = Integer.parseInt(N);
		
		
		min = Math.abs(ch-100);
		perm(0, new int[len+2], v, N, ch);
		System.out.println(min);
		
	}

	private static void perm(int cnt, int[] num, boolean[] v, String N, int ch) {

		int len = N.length();
		int vlen = v.length;
		
		if(cnt>=len-1 && cnt!=0) {
			int newnum = 0;
			for (int i = 0; i < cnt; i++) {
				newnum+=num[i]*(Math.pow(10, i));
			}

//			if(newnum==999) System.out.println("999옴");
//			System.out.println(newnum);
			if(Math.abs(newnum-ch)+cnt<min) min = Math.abs(newnum-ch)+cnt;
//			if(Math.abs(newnum-ch)+cnt==1) System.out.println(newnum);
			if(cnt==len+1)return;
		}
		for (int i = 0; i < vlen; i++) {
			if(v[i]) continue;
			
			num[cnt] = i;
			perm(cnt+1, num, v, N, ch);
			
		}
	}



}