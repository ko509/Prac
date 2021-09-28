package _0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859 {

	static long sum = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] day = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				day[i] = Integer.parseInt(st.nextToken());
			}
			sum = 0;
			stock(day);
			System.out.println("#"+t+" "+sum);
		
		}
	}

	private static void stock(int[] day) {

		int N = day.length;
		if(N==1) return;
		int max = Integer.MIN_VALUE;
		int maxi = -1;
		for (int i = 0; i < N; i++) {
			if(max<=day[i]) {
				max = day[i];
				maxi = i;
			}
		}
		
		for (int i = 0; i < maxi; i++) {
			sum += (max-day[i]);
		}
		if(maxi!=N-1) {
			int[] tmp = new int[N-maxi-1];
			for (int i = maxi+1; i < N; i++) {
				tmp[i-maxi-1] = day[i];
			}
			stock(tmp);
		}
	}

}
