package _1207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class SWEA_7965 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int p = 1000000007;
		int T = Integer.parseInt(br.readLine());
		long[] arr = new long[1000001];
		for (int i = 1; i < 1000001; i++) {
			arr[i] = power(i,i);
		}
		for (int t = 1; t <= T; t++) {
			long sum = 0l;
			int N = Integer.parseInt(br.readLine());
			for (int i = 1; i <= N; i++) {
				sum+= arr[i];
				sum%=p;
			}
			System.out.println("#"+t+" "+sum%p);
		}
	}

	private static long power(long num, long expo) {
		int p = 1000000007;
		if(expo==1) {
			return num%p;
		}
		long temp = power(num, expo/2)%p;
		if((expo&1)==1) {
			return ((temp*temp%p)*num)%p;
		}
		return temp*temp%p;
	}

}

