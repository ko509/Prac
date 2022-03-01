package _202202_sk_jina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 시간 : 148ms
// 메모리 : 12376KB

public class BOJ_14658 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int max = -1;
		
		
		List<int[]> list = new ArrayList<int[]>();
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < K; j++) {
				int cnt = 0;
				for (int k = 0; k < K; k++) {
					int x = list.get(i)[0];
					int y = list.get(j)[1];
					int r = list.get(k)[0];
					int c = list.get(k)[1];
					if(r>=x && r<= x+L && c >= y && c<=y+L) cnt++;
				}
				max = Math.max(max, cnt);
			}
		}
		
		System.out.println(K-max);
	}

}
