package _202202_sk_jina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.StringTokenizer;

// 시간  : 240ms
// 메모리 : 22528KB
public class BOJ_2806 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] original = new int[N];
		int total = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			original[i] = Integer.parseInt(st.nextToken());
			total += original[i];
		}
		
		int start = 0;
		int end = 0;
		int sum = original[0];
		int min = Integer.MAX_VALUE;
		
		while(end<N) {
			if(sum<S) {
				end++;
				if(end>=N) break;
				sum+=original[end];
			}else {
				min = Math.min(min, end-start+1);
				sum-=original[start];
				start++;
			}
		}
		if(min == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(min);
		
	}


}
